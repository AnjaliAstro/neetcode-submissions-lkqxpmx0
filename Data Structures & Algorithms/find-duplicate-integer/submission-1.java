class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0; i<nums.length; i++){
            int ele = nums[i];
            int findPos = ele-1;

            if(nums[findPos] == ele){
                if(findPos != i){
                    return ele;
                }
                continue;
            }

            int temp = nums[findPos];
            nums[findPos] = ele;
            nums[i] = temp;
            i--;
        }
        return nums[nums.length-1];
    }
}
