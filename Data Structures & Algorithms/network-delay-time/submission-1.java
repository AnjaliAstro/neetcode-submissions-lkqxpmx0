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

        dfs(k, nodeTime);
        
        int minTime = Integer.MIN_VALUE;
        for(int i=1; i<n+1; i++){
            if(nodeTime[i] == -1){
                return -1;
            }
            minTime = Math.max(minTime, nodeTime[i]);
        }
        return minTime;
    }

    private void dfs(int node, int[] nodeTime){
        Map<Integer, Integer> map =  adj.getOrDefault(node, new HashMap<>());
        for(Integer key:map.keySet()){
            int newTime = map.get(key) + nodeTime[node];
            if(nodeTime[key] == -1 || newTime < nodeTime[key]){
                nodeTime[key] = newTime;
                dfs(key, nodeTime);
            }
        }
    }
}
