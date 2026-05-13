class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;

        while(left < right){
            int mid = (left + right)/2;

            if(nums[mid] > nums[right]){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        return nums[left];
    }
}

// 1 2 3 4 5 6

// 6 1 2 3 4 5
// 5 6 1 2 3 4
// 4 5 6 1 2 3
// 3 4 5 6 1 2
// 2 3 4 5 6 1
// 1 2 3 4 5 6

// 3 4 5 6 1 2
