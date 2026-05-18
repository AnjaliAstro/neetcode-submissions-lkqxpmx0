class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] validOrder = new int[numCourses];
        int[] inEdges = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge:prerequisites){
            inEdges[edge[0]]++;
            adj.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(inEdges[i] == 0){
                q.add(i);
            }
        }

        Arrays.fill(validOrder, -1);
        int index = 0;
        while(!q.isEmpty()){
            int course = q.poll();
            validOrder[index] = course;

            for(Integer ele:adj.get(course)){
                inEdges[ele]--;
                if(inEdges[ele] == 0){
                    q.add(ele);
                }
            }
            index++;
        }

        for(int i=0; i<numCourses; i++){
            if(validOrder[i] == -1){
                return new int[0];
            }
        }
        return validOrder;
    }
}
