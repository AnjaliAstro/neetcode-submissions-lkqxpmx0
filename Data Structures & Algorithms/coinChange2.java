class Solution {
    public int change(int amount, int[] coins) {
        int[] amountWays = new int[amount + 1];
        amountWays[0] = 1;

        for (int coin : coins) {
            for (int i = 0; i < amount + 1; i++) {
                if (i - coin >= 0) {
                    amountWays[i] += amountWays[i - coin];
                }
            }
        }
        return amountWays[amount];
    }
}
