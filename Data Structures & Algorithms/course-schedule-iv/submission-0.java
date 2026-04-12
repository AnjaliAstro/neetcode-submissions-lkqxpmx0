class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        //adj matrix by dfs on every query
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge:prerequisites){
            adj.get(edge[0]).add(edge[1]);
        }

        List<Boolean>answers = new ArrayList<>();
        for(int[] query:queries){
            Set<Integer> visited = new HashSet<>();
            answers.add(dfs(query[0], query[1], adj, visited));
        }
        return answers;
    }


    private boolean dfs(int start, int end, List<List<Integer>> adj, Set<Integer> visited){
        if(start == end){
            return true;
        }
        visited.add(start);
        for(Integer ele:adj.get(start)){
            if(!visited.contains(ele)){
                if(dfs(ele, end, adj, visited)){
                    return true;
                }
            }
        }
        return false;
    }
}