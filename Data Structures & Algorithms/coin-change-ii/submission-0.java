class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, 0);
        dp[0] = 1;

        for(int coin:coins){
            for(int i=1; i<amount+1; i++){
                if(i-coin >= 0){
                    dp[i] = dp[i] + dp[i-coin];
                }
            }
        }
        return dp[amount];
    }
}


// bottom up
// 1, 2, 3, 4
// 1, 1, 1, 0
// 1, 2, 3, 

// 1*3
// 2*2
// 3*1

// 1 1 1
// 1 2
// 3
// 2 1 1