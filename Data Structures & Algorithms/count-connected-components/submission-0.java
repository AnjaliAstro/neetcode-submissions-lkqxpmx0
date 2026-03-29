class Solution {
    Set<Integer> visited = new HashSet<>();
    List<List<Integer>> adjList = new ArrayList<>();
    public int countComponents(int n, int[][] edges) {
        //0-1
        //1-2
        //edge cases - circle
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] edge:edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        int components = 0;
        for(int i=0; i<n; i++){
            if(!visited.contains(i)){
                visited.add(i);
                dfs(i);
                components++;
            }
        }
        return components;
    }

    private void dfs(int start){
        for(Integer adj:adjList.get(start)){
            if(!visited.contains(adj)){
                visited.add(adj);
                dfs(adj);
            }
        }
    }
}
