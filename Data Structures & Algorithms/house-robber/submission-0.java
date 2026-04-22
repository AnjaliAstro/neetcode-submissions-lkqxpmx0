class Solution {
    int[] maxMoney;
    public int rob(int[] nums) {
        maxMoney = new int[nums.length];
        Arrays.fill(maxMoney, -1);
        if(nums.length == 1){
            return nums[0];
        }

        return recurr(nums, 0);
    }

    private int recurr(int[] nums, int index){
        if(index >= nums.length){
            return 0;
        }

        if(maxMoney[index] != -1){
            return maxMoney[index];
        }

       int chosen = 0;
       int notChosen= 0;
       chosen = recurr(nums, index+2) + nums[index];
       notChosen = recurr(nums, index+1);
       
       maxMoney[index] = Math.max(chosen, notChosen);
       return maxMoney[index];
    }
}
