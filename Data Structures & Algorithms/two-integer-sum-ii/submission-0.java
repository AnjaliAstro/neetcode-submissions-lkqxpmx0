class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = numbers.length-1;

        while(left < right){
            int sum = numbers[left] + numbers[right];

            if(sum == target){
                return new int[]{left+1, right+1};
            }
            else if(sum < target){
                left++;
            }
            else{
                right--;
            }

            while(left != 0 && numbers[left] == numbers[left-1]){
                left++;
            }

            while(right != numbers.length-1 && numbers[right] == numbers[right+1]){
                right--;
            }
        }
        return res;
    }
}


//O(n) - two pointers
//O(log n) - binary search ???
// 1 2 3 4
// blocked -> how to navigate low - mid
// low - mid
// 