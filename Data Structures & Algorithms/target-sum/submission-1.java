class Solution {
    //with memoization now
    int[][] indexSum;
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for(int i=0; i<nums.length; i++){
            totalSum += nums[i];
        }
        indexSum = new int[nums.length][2*totalSum+1];
        for(int i=0; i<nums.length; i++){
            Arrays.fill(indexSum[i], Integer.MIN_VALUE);
        }
        int ways = dfs(nums, target, 0, 0, totalSum);
        return ways;
    }

    private int dfs(int[] nums, int target, int index, int sum, int totalSum){
        if(index == nums.length){
            if(sum == target){
                return 1;
            }
            return 0;
        }

        if(index > nums.length){
            return 0;
        }

        if(indexSum[index][sum+totalSum] != Integer.MIN_VALUE){ //offset the sum to store the value
            return indexSum[index][sum+totalSum];
        }

        int ways = dfs(nums, target, index+1, sum+nums[index], totalSum);
        ways += dfs(nums, target, index+1, sum-nums[index], totalSum);
        indexSum[index][sum+totalSum] = ways;
        return ways;
    }
}
