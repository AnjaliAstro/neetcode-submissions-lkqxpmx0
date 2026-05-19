class Solution {
    int[][] dir = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        visited = new boolean[rows][cols];

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(i, j, board, word, rows, cols, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int row, int col, char[][] board, String word, int rows, int cols, int index){
        visited[row][col] = true;
        if(index == word.length()-1){
            return true;
        }

        for(int[] d:dir){
                int x = d[0]+row;
                int y = d[1]+col;

                if(x<0 || x>=rows || y<0 || y>=cols || visited[x][y]){
                    continue;
                }

                if(board[x][y] == word.charAt(index+1)){
                    visited[x][y] = true;
                    if(dfs(x, y, board, word, rows, cols, index+1)){
                        return true;
                    }
                    visited[x][y] = false;
                }
        }
        visited[row][col] = false;
        return false;
    }
}
