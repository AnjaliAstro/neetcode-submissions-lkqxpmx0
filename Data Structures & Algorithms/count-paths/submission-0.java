class Solution {
    //down or right
    int[][] dir = new int[][]{{1,0}, {0,1}};
    Map<String, Integer> map = new HashMap<>(); //string is (row+","+col , ways)
    public int uniquePaths(int m, int n) {
        return dfs(m, n, 0, 0);
    }

    private int dfs(int m, int n, int row, int col){
        if(row == m-1 && col == n-1){
            return 1;
        }

        if(map.containsKey(row+","+col)){
            return map.get(row+","+col);
        }

        int ways = 0;
        for(int[] d:dir){
            int x = row+d[0];
            int y = col+d[1];
            if(x >= m || y >= n)
                continue;
            ways += dfs(m, n, x, y);
        }
        
        map.put(row+","+col, ways);
        return ways;
    }
}
