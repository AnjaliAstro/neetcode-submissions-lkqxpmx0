class Solution {
    public int minCostConnectPoints(int[][] points) {
        int minSum = 0;

        //form the graph every point with itself
        Map<Integer, List<int[]>> adj = new HashMap<>(); // point index, (pointIndex, manhattan weight)
        for(int i=0; i<points.length; i++){
            int[] point = points[i];
            int x = point[0];
            int y = point[1];
            adj.put(i, new ArrayList<>());
            for(int j=0; j<points.length; j++){
                if(i != j){
                    // List<int[]> list = adj.getOrDefault(i, new ArrayList<>());
                     List<int[]> list = adj.get(i);
                    list.add(new int[]{j, Math.abs(x-points[j][0]) + Math.abs(y-points[j][1])});
                    adj.put(i, list);
                }
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]); // weight, pointIndex, parent
        pq.add(new int[]{0, 0, -1});
        Set<Integer> visited = new HashSet<>();

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            if(visited.contains(curr[1])){
                continue;
            }
            visited.add(curr[1]);
            minSum += curr[0];

            for(int[] ele:adj.get(curr[1])){
                if(!visited.contains(ele[0])){
                    pq.add(new int[]{ele[1], ele[0], curr[1]});
                }
            }
        }

        return minSum;
    }
}

//seems like MSP - prims