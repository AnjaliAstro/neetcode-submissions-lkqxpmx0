class Solution {
    Set<List<Integer>> set;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        set = new HashSet<>();
        recur(nums, target, 0, 0, new ArrayList<>());
        return new ArrayList<>(set);
    }

    private void recur(int[] nums, int target, int idx, int sum, List<Integer> list){
        if(idx >= nums.length){
            return;
        }

        if(sum > target){
            return;
        }

        if(sum == target){
            set.add(new ArrayList<>(list));
            return;
        }

        //taken
        list.add(nums[idx]);
        recur(nums, target, idx, sum+nums[idx], list);
        list.remove(list.size()-1);

        //notTaken
        recur(nums, target, idx+1, sum, list);
    }
}
