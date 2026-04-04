class Solution {
    public void islandsAndTreasure(int[][] grid) {
        //bfs
        int[][] dir = new int[][] {{1,0}, {0,1}, {-1,0}, {0,-1}};
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 0){
                    q.add(new int[]{i, j, 0});
                }
            }
        }

        while(!q.isEmpty()){
            int[] currCell = q.poll();
            int x = currCell[0];
            int y = currCell[1];
            int dis = currCell[2];

            for(int[] d:dir){
                int x1= d[0]+x;
                int y1 = d[1]+y;

                if(x1<0 || x1>= rows || y1<0 || y1>=cols || grid[x1][y1] != Integer.MAX_VALUE)
                    continue;
                
                grid[x1][y1] = dis+1;
                q.add(new int[]{x1, y1, dis+1});
            }
        }
    
    }
}
