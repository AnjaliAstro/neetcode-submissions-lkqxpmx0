class Solution {
    int[][] memo;
    public int minDistance(String word1, String word2) {
        memo = new int[word1.length()][word2.length()];
        return minEdit(word1, word2, 0, 0);
    }

    private int minEdit(String word1, String word2, int i, int j){
        if(j == word2.length()){
            return word1.length() - i; //delete the remaining word1 letters
        }

        if(i == word1.length()){
            return word2.length() - j; //add the remaining word2 letters
        }

        if(memo[i][j] != 0){
            return memo[i][j];
        }

        int minOps = 0;
        if(word1.charAt(i) == word2.charAt(j)){
            minOps = minEdit(word1, word2, i+1, j+1);
        }
        else{
            minOps = 1 + Math.min(minEdit(word1, word2, i, j+1), Math.min(minEdit(word1, word2, i+1, j), minEdit(word1, word2, i+1, j+1)));
        }
        memo[i][j] = minOps;
        return minOps;
    }
}
