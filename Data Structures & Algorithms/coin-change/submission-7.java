class Solution {
    public int coinChange(int[] coins, int amount) {
        //Iterative DP way
        int[] coinCount = new int[amount+1];
        Arrays.fill(coinCount, amount+1);
        coinCount[0] = 0;

        for(int coin:coins){
            for(int i=1; i<amount+1; i++){
                if(i >= coin){
                    coinCount[i] = Math.min(coinCount[i], coinCount[i-coin]+1);
                }
            }
        }

        return coinCount[amount]>amount? -1:coinCount[amount];
    }
}
