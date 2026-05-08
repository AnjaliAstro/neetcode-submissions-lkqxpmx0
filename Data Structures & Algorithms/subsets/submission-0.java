class Solution {
    Set<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new HashSet<>();
        recurr(nums, 0, new ArrayList<>());
        return new ArrayList<>(result);
    }

    private void recurr(int[] nums, int idx, List<Integer> list){
        result.add(new ArrayList<>(list));

        if(idx >= nums.length){
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
