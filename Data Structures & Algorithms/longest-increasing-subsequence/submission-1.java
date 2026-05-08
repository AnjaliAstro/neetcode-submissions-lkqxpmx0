class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            lis[i] = 1;
        }
        int maxSoFar = 1;
        for(int i=nums.length-2; i>=0; i--){
            for(int j=i+1; j<nums.length; j++){
                if(nums[j] > nums[i]){
                    lis[i] = Math.max(lis[i], lis[j]+1);
                    maxSoFar = Math.max(maxSoFar, lis[i]);
                }
            }
        }
        return maxSoFar;
    }
}
