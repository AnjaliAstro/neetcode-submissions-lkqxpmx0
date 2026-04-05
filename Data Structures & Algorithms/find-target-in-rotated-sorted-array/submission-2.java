class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left<=right){
            int mid = (left+right)/2;

            if(nums[mid] == target){ //exact
                return mid;
            }
            if(nums[left] <= nums[mid] ){ 
                if(target < nums[mid] && target >= nums[left]){//sorted
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }
            else if(nums[mid] >= nums[right]){
                if(target<=nums[right]){
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }
            }
            else if(nums[mid] <= nums[right]){
                if(target>nums[mid] && target <= nums[right]){
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }
            }

        }
        return -1;
    }
}


// 6, 7, 8, 0, 1, 2, 3, 4, 5

// 1
// left 3
// mid 5
//right 2
//mid>right

// left>right && 1<right
// left = mid+1

// left>right && 1>right
// right = mid