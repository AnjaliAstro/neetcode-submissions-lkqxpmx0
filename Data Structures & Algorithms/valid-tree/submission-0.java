class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int[]edge:edges){
            List first = adj.getOrDefault(edge[0], new ArrayList<>());
            first.add(edge[1]);
            adj.put(edge[0], first);

            List second = adj.getOrDefault(edge[1], new ArrayList<>());
            second.add(edge[0]);
            adj.put(edge[1], second);
        }

        Set<Integer>visited = new HashSet<>();
        boolean res = dfs(0, adj, visited, -1);
        
        for(int i=0; i<n; i++){
            if(!visited.contains(i)){
                return false;
            }
        }
        return res;
    }

    private boolean dfs(int n, Map<Integer, List<Integer>> adj, Set<Integer>visited, int parent){
        if(visited.contains(n)){
            return false;
        }
        visited.add(n);
        for(Integer ele:adj.getOrDefault(n, new ArrayList<>())){
            if(ele != parent && !dfs(ele, adj, visited, n))
                return false;
        }
        return true;
    }
}
