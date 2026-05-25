class Solution {
    int[][] dir = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};

    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(board[i][j] == 'O'){
                    List<int[]> list = new ArrayList<>();
                    if(checkSurrounding(board, rows, cols, i, j, list)){
                        for(int[] ele:list){
                            board[ele[0]][ele[1]] = 'X';
                        }
                    }
                }
            }
        }
    }

    private boolean checkSurrounding(char[][] board, int rows, int cols, int row, int col, List<int[]> list){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        q.add(new int[]{row, col});
        list.add(new int[]{row, col});
        visited[row][col] = true;
        boolean isSurrounded = true; //yes surrounded by the X
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            if(curr[0] == 0 || curr[0] == rows-1 || curr[1] == 0 || curr[1] == cols-1){
                isSurrounded = false;
            }

            for(int[] d:dir){
                int x = d[0] + curr[0];
                int y = d[1] + curr[1];

                if(x<0 || x>=rows || y<0 || y>=cols || board[x][y] == 'X' || visited[x][y]){
                    continue;
                } 

                q.add(new int[]{x,y});
                list.add(new int[]{x,y});
                visited[x][y] = true;
            }
        }
        return isSurrounded;
    }
}
