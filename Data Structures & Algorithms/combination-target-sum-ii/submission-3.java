class Solution {
    List<List<Integer>> combinations;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        combinations = new ArrayList<>();
        Arrays.sort(candidates);
        getCombinations(candidates, target, 0, 0, new ArrayList<>());
        return combinations;
    }

    private void getCombinations(int[] candidates, int target, int sum, int index, List<Integer> list){
        if(sum == target){
            combinations.add(new ArrayList<>(list));
            return;
        }

        for(int i=index; i<candidates.length; i++){
            if(sum + candidates[i] > target){
                break;
            }

            if(i>index && candidates[i] == candidates[i-1]){
                continue;
            }

            list.add(candidates[i]);
            getCombinations(candidates, target, sum+candidates[i], i+1, list);
            list.remove(list.size()-1);
        }
    }
}

// [ 2 3 2 3 ]
// 5
// [2 3]