class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length-1;

        while(left < right){
            int mid = (left+right)/2;

            long l = Long.MIN_VALUE;
            long r = Long.MIN_VALUE;
            if(mid != nums.length-1){
                r = (long)nums[mid+1];
            }

            if(mid != 0){
                l = (long)nums[mid-1];
            }

            if(nums[mid] > l && nums[mid] > r){
                return mid;
            }
            else if(nums[mid] > l && nums[mid] < r){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
}
