class Solution {
    public boolean canJump(int[] nums) {
        int jump = 0;
        int maxJump = nums[0];

        while(jump <= maxJump && jump < nums.length-1){
            maxJump = Math.max(jump+nums[jump], maxJump);
            jump++; 
        }

        return maxJump >= nums.length-1;
    }
}
