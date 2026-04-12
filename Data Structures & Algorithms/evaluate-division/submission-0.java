class Pair {
    String neighbor;
    Double weight;

    Pair(String nei, Double wei){
        this.neighbor = nei;
        this.weight = wei;
    }
}

class Solution {
    Map<String, List<Pair>> graph = new HashMap<>();
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Build graph
        for(int i = 0; i < equations.size(); i++){
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);

            // a→b with weight values[i]
            List<Pair> listU = graph.getOrDefault(u, new ArrayList<>());
            listU.add(new Pair(v, values[i]));
            graph.put(u, listU);

            // b→a with weight 1/values[i]
            List<Pair> listV = graph.getOrDefault(v, new ArrayList<>());
            listV.add(new Pair(u, 1.0 / values[i]));
            graph.put(v, listV);
        }

        // Answer queries
        double[] pathVal = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){
            String src = queries.get(i).get(0);
            String dst = queries.get(i).get(1);

            // edge case: variable not in graph
            if(!graph.containsKey(src) || !graph.containsKey(dst)){
                pathVal[i] = -1.0;
            } else {
                pathVal[i] = dfs(src, dst, 1.0, new HashSet<>());
            }
        }
        return pathVal;
    }

    private double dfs(String start, String end, double val, Set<String> visited){
        if(start.equals(end)) return val; 

        visited.add(start);

        for(Pair adj : graph.get(start)){
            if(!visited.contains(adj.neighbor)){
                double result = dfs(adj.neighbor, end, val * adj.weight, visited);
                if(result != -1.0) return result; 
            }
        }
        return -1.0; 
    }
}