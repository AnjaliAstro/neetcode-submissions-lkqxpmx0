class Solution {
    int maxArea = 0;
    Boolean[][] visited;
    int[][] dir = new int[][]{{1,0}, {0,1}, {0,-1}, {-1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        visited = new Boolean[rows][cols];

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 1 && visited[i][j] == null){
                    visited[i][j] = true;
                    maxArea = Math.max(maxArea, dfs(i, j, rows, cols, grid));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int row, int col, int rows, int cols, int[][] grid){
        int area = 1;
        for(int[] d:dir){
            int x = d[0]+row;
            int y = d[1]+col;

            if(x>=rows || y>=cols || x<0 || y<0 || grid[x][y] == 0 || visited[x][y] != null){
                continue;
            }
            visited[x][y] = true;
            area += dfs(x, y, rows, cols, grid);
        }
        return area;
    }
}
