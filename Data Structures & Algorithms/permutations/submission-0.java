class Solution {
    List<List<Integer>> permutations;
    public List<List<Integer>> permute(int[] nums) {
        permutations = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        getPermutes(nums, 0, new ArrayList<>(), used);
        return permutations;
    }

    private void getPermutes(int[] nums, int index, List<Integer> list, boolean[] used){
        if(index == nums.length){
            permutations.add(new ArrayList<>(list));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(used[i] == true){
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            getPermutes(nums, index+1, list, used);
            list.remove(list.size()-1);
            used[i] = false;
        }
    }
}
