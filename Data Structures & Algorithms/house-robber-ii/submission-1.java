class Solution {
    Map<Integer, Integer> dp1;
    Map<Integer, Integer> dp2;
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return nums[0];
        }

        dp1 = new HashMap<>();
        dp2 = new HashMap<>();

        //circular indexes cant be considered as base conditions will be interrupted
        int[] num1 = new int[n-1];//0_n-2
        int[] num2 = new int[n-1];//1_n-1
        for(int i=1; i<n-1; i++){
            num1[i] = nums[i];
            num2[i-1] = nums[i];
        }
        num1[0] = nums[0];
        num2[n-2] = nums[n-1];

        return Math.max(robbery(num1, 0, dp1), robbery(num2, 0, dp2));
    }

    private int robbery(int[] nums, int index, Map<Integer, Integer> dp){
        if(index >= nums.length){
            return 0;
        }

        if(dp.containsKey(index)){
            return dp.get(index);
        }

        int profit = 0;

        //loot the house
        profit = nums[index] + robbery(nums, index+2, dp);

        //do not loot the house
        profit = Math.max(profit, robbery(nums, index+1, dp));

        dp.put(index, profit);
        return profit;
    }
}

