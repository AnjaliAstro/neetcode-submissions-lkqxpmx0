class Solution {
    int[][] dir = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
    public int numIslands(char[][] grid) {
        //iterate and dfs
        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j, rows, cols);
                    islands++;
                }
            }
        }

        return islands;
    }


    private void dfs(char[][] grid, int i, int j, int rows, int cols){        
        grid[i][j] = '0';

        for(int[] d:dir){
            int x1 = d[0]+i;
            int y1 = d[1]+j;
            if(x1<0 || x1>=rows || y1<0 || y1>=cols|| grid[x1][y1] == '0')
                continue;
            dfs(grid, x1, y1, rows, cols);
        }
        return;
    }
}
