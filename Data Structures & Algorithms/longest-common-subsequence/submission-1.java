class Solution {
    int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];
        return getLCS(text1, text2, 0, 0);
    }

    private int getLCS(String text1, String text2, int i, int j){
        if(i == text1.length() || j == text2.length()){
            return 0;
        }

        if(memo[i][j] != 0){
            return memo[i][j];
        }
        
        int maxLen = 0;
        if(text1.charAt(i) == text2.charAt(j)){
            maxLen = 1 + getLCS(text1, text2, i+1, j+1);
        }
        else{
            maxLen = Math.max(getLCS(text1, text2, i+1, j), getLCS(text1, text2, i, j+1));
        }
        memo[i][j] = maxLen;
        return maxLen;
    }
}
