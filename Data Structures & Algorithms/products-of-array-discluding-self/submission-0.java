class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n+1];
        int[] suffix = new int[n+1];
        prefix[0] = 1;
        suffix[n] = 1;

        for(int i=1; i<n+1; i++){
            prefix[i] = prefix[i-1]*nums[i-1];
        }
        for(int i=n-1; i>=0; i--){
            suffix[i] = suffix[i+1]*nums[i];
        }

        int[] result = new int[n];
        for(int i=0; i<n; i++){
            result[i] = prefix[i]*suffix[i+1];
        }

        return result;
    }
}  

// preSum
// 1    2   8   48
// 48   48  24  6
// 