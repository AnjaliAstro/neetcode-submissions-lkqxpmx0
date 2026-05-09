class Solution {
    int[][] memo;
    public int maxProfit(int[] prices) {
        memo = new int[prices.length][2]; // (index, isBought=0/1)
        for(int i=0; i<prices.length; i++){
            Arrays.fill(memo[i], -1);
        }

        return recurr(prices, 0, 0);// prices, index, isBought
    }

    private int recurr(int[] prices, int idx, int isBought){
        if(idx >= prices.length){
            return 0;
        }

        if(memo[idx][(isBought)] != -1){
            return memo[idx][isBought];
        }

        int res = 0;
        //if bought then try selling this day
        if(isBought == 1){
            //if sold then, buy on day after
            res = prices[idx] + Math.max(res, recurr(prices, idx+2, 0));

            //if not sold, then try selling the other day
            res = Math.max(res, recurr(prices, idx+1, isBought));
        }
        else{
            //buy and lets try and sell the other day
            res = (-prices[idx]) + Math.max(res, recurr(prices, idx+1, 1));

            //don't buy
            res = Math.max(res, recurr(prices, idx+1, 0));
        }
        memo[idx][isBought] = res;
        return res;
    }
}
