class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int i=0; i<nums.length; i++){
            totalSum += nums[i];
        }

        if(totalSum%2 != 0){
            return false;
        }

        int target = totalSum/2;
        return partition(nums, target, 0);
    }

    private boolean partition(int[] nums, int target, int index){
        if(target == 0){
            return true;
        }

        if(target < 0){
            return false;
        }

        if(index == nums.length){
            return false;
        }

        return partition(nums, target-nums[index], index+1) || partition(nums, target, index+1);
    }
}


// no rule
// random - taken, not taken strategy it seems
// equal subset sum 
// total = 10
// 5 - 5
// one subset should make 5 as total
//target sum = 5 question
// dp iterative 5 with just one usuage of the coins present