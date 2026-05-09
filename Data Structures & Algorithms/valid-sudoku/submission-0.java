class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> rowMap = new HashMap<>();
        Map<Integer, Set<Integer>> colMap = new HashMap<>();
        Map<Integer, Set<Integer>> sqMap = new HashMap<>();

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                char ch = board[i][j];
                if(ch == '.'){
                    continue;
                }
                int num = ch-'0';
                if(num>9 || num<1){
                    return false;
                }

                //sq index
                int sqIdx = (i/3)*3 + (j/3);
                //row-check, col-check, sq-check
                if(!checkDuplicate(rowMap, num, i) ||
                !checkDuplicate(colMap, num, j) ||
                !checkDuplicate(sqMap, num, sqIdx))
                    return false;
            }
        }
        return true;
    }

    private boolean checkDuplicate(Map<Integer, Set<Integer>> map, int num, int idx){
        if(map.getOrDefault(idx, new HashSet<>()).contains(num)){
            return false;
        }
        Set<Integer> set = map.getOrDefault(idx, new HashSet<>());
        set.add(num);
        map.put(idx, set);
        return true;
    }
}
//n^2 round cover up
//Map<0, Set<Integer>> row wise map
//Map<0, Set<Integer>> column wise map

//now n^2 check
// 3*3 check - put in Set<Integer> 


//main thing here is formula for the squares