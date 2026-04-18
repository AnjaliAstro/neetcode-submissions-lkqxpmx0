class Solution {
    int[][] dir = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] water = new int[rows][cols];
        for(int i=0; i<rows; i++){
            Arrays.fill(water[i], 0);
        }

        //check pacific to atlantic
        int[][] pacific = new int[rows][cols];
        int[][] atlantic = new int[rows][cols];

        for(int i=0; i<cols; i++){
            bfs(pacific, 0, i, rows, cols, heights);
        }

        for(int i=0; i<cols; i++){
            bfs(atlantic, rows-1, i, rows, cols, heights);
        }

        for(int i=0; i<rows; i++){
            bfs(pacific, i, 0, rows, cols, heights);
        }

        for(int i=0; i<rows; i++){
            bfs(atlantic, i, cols-1, rows, cols, heights);
        }
        
        List<List<Integer>> solution = new ArrayList<>();
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(pacific[i][j] == 1 && atlantic[i][j] ==1){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    solution.add(list);
                }
            }
        }
        return solution;
    }

    private void bfs(int[][] ocean, int row, int col, int rows, int cols, int[][] heights){
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{row,col});
        while(!q.isEmpty()){
            int[] cords = q.poll();
            ocean[cords[0]][cords[1]] = 1;

            for(int[] d:dir){
                int x = cords[0]+d[0];
                int y = cords[1]+d[1];

                if(x<0 || x>=rows || y<0 || y>=cols){
                    continue;
                }

                if(heights[x][y]>= heights[cords[0]][cords[1]] && ocean[x][y] == 0){
                    q.add(new int[]{x,y});
                }
            }
        }
    }
}
