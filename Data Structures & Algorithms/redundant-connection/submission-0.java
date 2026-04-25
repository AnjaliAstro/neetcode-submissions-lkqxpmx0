class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        //dfs for each edge if the end points could be traversed, then, its a cycle

        Map<Integer, Set<Integer>> adj = new HashMap<>();

        for(int[] edge:edges){
            int a = edge[0];
            int b = edge[1];
            if(dfs(a, b, adj, new HashSet<>())){
                return edge;
            }
            Set<Integer> list1 = adj.getOrDefault(a, new HashSet<>());
            list1.add(b);
            adj.put(a, list1);

            Set<Integer> list2 = adj.getOrDefault(b, new HashSet<>());
            list2.add(a);
            adj.put(b, list2);
        }
        return new int[]{};     
    }

    private boolean dfs(int a, int b, Map<Integer, Set<Integer>> adj, Set<Integer> visited){
        visited.add(a);
        if(a == b){
            return true;
        }

        Set<Integer> set = adj.getOrDefault(a, new HashSet<>());
        for(Integer ele: set){
            if(!visited.contains(ele) && dfs(ele, b, adj, visited))
                return true;
        }
        return false;
    }
}
