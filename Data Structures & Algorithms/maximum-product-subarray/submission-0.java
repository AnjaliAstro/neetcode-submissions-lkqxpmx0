class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int maxMult = nums[0];

        for(int i=1; i<nums.length; i++){
            int prevMin = min;
            int prevMax = max;

            max = Math.max(nums[i], Math.max(prevMax * nums[i], prevMin * nums[i]));
            min = Math.min(nums[i], Math.min(prevMax * nums[i], prevMin * nums[i]));

            maxMult = Math.max(maxMult, max);
        }
        return maxMult;
    }
}

// -2 1 2 -2 4 -2
//pos mult = 1   1  2 8 24 24
//neg mult = -2 -2 -4 8 24 -48