class Solution {
    int[] dp;
    public int jump(int[] nums) {
        dp = new int[nums.length]; // optimal #jumps to reach the end
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[nums.length-1] = 0;
        return recurJump(nums, 0); //recurring Jump - nums, jumps so far
    }

    private int recurJump(int[] nums, int index){
        if(index >= nums.length-1){
            return 0;
        }

        if(dp[index] != Integer.MAX_VALUE){
            return dp[index];
        }

        int minJump = Integer.MAX_VALUE;
        for(int i=1; i<=nums[index]; i++){
            int jumpPossible = recurJump(nums, index+i);
            if(jumpPossible != Integer.MAX_VALUE)
                minJump = Math.min(minJump, 1+jumpPossible);
        }
        dp[index] = minJump;
        return minJump;
    }
}
