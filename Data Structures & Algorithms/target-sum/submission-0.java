class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int ways = dfs(nums, target, 0, 0);
        return ways;
    }

    private int dfs(int[] nums, int target, int index, int sum){
        if(index == nums.length){
            if(sum == target){
                return 1;
            }
            return 0;
        }

        if(index > nums.length){
            return 0;
        }

        int ways = dfs(nums, target, index+1, sum+nums[index]);
        ways += dfs(nums, target, index+1, sum-nums[index]);
        return ways;
    }
}
