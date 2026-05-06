class Solution {
    int[][] dir = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));// elevation-time, x, y
        // int reachTime = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        pq.add(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;


        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            // reachTime = curr[0];
            if(curr[1] == rows-1 && curr[2] == cols-1){
                return curr[0];
            }

            for(int[] d: dir){
                int x = d[0]+curr[1];
                int y = d[1]+ curr[2];
                if(x<0 || x>=rows || y<0 || y>=cols || visited[x][y])
                    continue;
                pq.add(new int[]{Math.max(curr[0], grid[x][y]), x, y});
                visited[x][y] = true;
            }
        }
        return 0;
    }
}

//pick the next valid time and keep it in the time passed section
// 0 time valid 0,0
// 1 time valid 0,1
// 2 time valid 