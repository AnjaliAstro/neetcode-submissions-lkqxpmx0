class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] price = new int[n][k+2];
        for(int i=0; i<n; i++){
            Arrays.fill(price[i], -1);
        }
        price[src][0] = 0;

        //build adj
        Map<Integer, Map<Integer, Integer>> adj = new HashMap<>();
        for(int[] flight:flights){
            int node1 = flight[0];
            int node2 = flight[1];
            int cost = flight[2];
            Map<Integer, Integer> map = adj.getOrDefault(node1, new HashMap<>());
            map.put(node2, cost);
            adj.put(node1, map);
        }

        //seems like Dijkstras with additional param of k hops
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[1]-b[1]));

        pq.add(new int[]{src, 0, 0}); // src, price from src, hops from src

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currNode = curr[0];
            int cost = curr[1];
            int hops = curr[2];

            if(currNode == dst){
                return cost;
            }

            Map<Integer, Integer> map = adj.getOrDefault(currNode, new HashMap<>());
            for(Integer ele:map.keySet()){
                if((hops <= k) && (price[ele][hops+1] == -1 || price[ele][hops+1] > cost + map.get(ele))){
                    price[ele][hops+1] = cost + map.get(ele);
                    pq.add(new int[]{ele, price[ele][hops+1], hops+1});
                }
            }
        }
        int ans = -1;
        for(int i=0; i<=k+1; i++){
            if(price[dst][i] != -1){
                if(ans == -1 || ans > price[dst][i]){
                    ans = price[dst][i];
                }
            }
        }
        return ans;
    }
}
