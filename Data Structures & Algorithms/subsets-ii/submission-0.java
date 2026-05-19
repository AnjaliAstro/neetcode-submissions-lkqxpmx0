class Solution {
    List<List<Integer>> subsets;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        subsets = new ArrayList<>();
        Arrays.sort(nums);
        getSubsets(nums, 0, new ArrayList<>());
        return subsets;
    }

    private void getSubsets(int[] nums, int index, List<Integer> list){
        if(index >= nums.length){
            subsets.add(new ArrayList<>(list));
            return;
        }

        //taken
        list.add(nums[index]);
        getSubsets(nums, index+1, list);
        list.remove(list.size()-1);

        while(index+1 < nums.length && nums[index] == nums[index+1]){
            index++;
        }

        //not-taken
        getSubsets(nums, index+1, list);
    }
}
