class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(b[0]-a[0]));

        for(int[] point:points){
            int sum = point[0]*point[0] + point[1]*point[1];
            pq.add(new int[]{sum, point[0], point[1]});

            if(pq.size() > k){
                pq.poll();
            }
        }

        int[][] results = new int[k][2];
        int i = 0;
        while(!pq.isEmpty()){
            int[] ele = pq.poll();
            results[i][0] = ele[1];
            results[i][1] = ele[2];
            i++;
        }
        return results;
    }
}
