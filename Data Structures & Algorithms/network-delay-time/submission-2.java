class Solution {
    Map<Integer, Map<Integer, Integer>> adj;
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] nodeTime = new int[n+1];
        Arrays.fill(nodeTime, -1);
        nodeTime[k] = 0;

        adj = new HashMap<>();

        for(int[] time:times){
            Map<Integer, Integer> map = adj.getOrDefault(time[0], new HashMap<>());
            map.put(time[1], time[2]);
            adj.put(time[0], map);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[1]-b[1]));
        pq.add(new int[]{k, 0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currNode = curr[0];
            int currWeight = curr[1];
            Map<Integer, Integer> map = adj.getOrDefault(currNode, new HashMap<>());

            for(Integer key: map.keySet()){
                if(nodeTime[key] == -1 || nodeTime[key] > map.get(key) + nodeTime[currNode]){
                    nodeTime[key] = map.get(key) + nodeTime[currNode];
                    pq.add(new int[]{key, nodeTime[key] });
                }
            }
        }
        
        int minTime = Integer.MIN_VALUE;
        for(int i=1; i<n+1; i++){
            if(nodeTime[i] == -1){
                return -1;
            }
            minTime = Math.max(minTime, nodeTime[i]);
        }
        return minTime;
    }
}
