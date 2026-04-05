class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(nums[mid] == target) return mid;

            // Left half is sorted
            if(nums[left] <= nums[mid]){
                if(target >= nums[left] && target < nums[mid]){ //left half peak
                    right = mid - 1; // target in left half
                } else {
                    left = mid + 1; // target in right half
                }
            }
            // Right half is sorted
            else {
                if(target > nums[mid] && target <= nums[right]){ //right half peak
                    left = mid + 1; // target in right half
                } else {
                    right = mid - 1; // target in left half
                }
            }
        }
        return -1;
    }
}


// ### 🧠 Visual Intuition
// ```
// [3, 4, 5, 6, 1, 2]
//           mid=6

// Left half [3,4,5,6] sorted? ✅
// Is target in [3...6]? 
//   YES → go left
//   NO  → go right

// [3, 4, 5, 6, 1, 2]
//     mid=4

// Right half [1,2] sorted? ✅
// Is target in [1...2]?
//   YES → go right
//   NO  → go left