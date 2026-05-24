class Solution {
    int[][] dp;
    public int numDistinct(String s, String t) {
        dp = new int[s.length()][t.length()]; // ways from this index
        for(int[] row : dp) 
            Arrays.fill(row, -1);
        getSubsequences(s, t, 0, 0);
        return dp[0][0];
    }


    private int getSubsequences(String s, String t, int indexS, int indexT){
        if(indexT == t.length()){
            return 1;
        }

        if(indexS == s.length()){
            return 0;
        }

        if(dp[indexS][indexT] != -1){
            return dp[indexS][indexT];
        }

        int ways = 0;
        for(int i=indexS; i<s.length(); i++){
            if(s.charAt(i) == t.charAt(indexT)){
                ways += getSubsequences(s, t, i+1, indexT+1);
            }
        }

        dp[indexS][indexT] = ways;
        return dp[indexS][indexT];
    }
}
//start with all the char at 0 pos of t in s 
// find in how many ways it can contribute
// for each one start a recursive process in search of all eligible 1st pos of t
// after reaching the t.length() return after adding 1 to the result
// after the return remove the character from the StringBuilder