class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        recurr(nums, 0, new ArrayList<>());
        return result;
    }

    private void recurr(int[] nums, int idx, List<Integer> list){
        if(idx >= nums.length){
            result.add(new ArrayList<>(list));
            return;
        }

        //takem
        list.add(nums[idx]);
        recurr(nums, idx+1, list);
        list.remove(list.size()-1);

        //notTaken
        recurr(nums, idx+1, list);
    }
}
