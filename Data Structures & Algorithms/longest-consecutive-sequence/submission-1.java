class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }

        int maxSeq = 0;
        int index = 0;

        while(!set.isEmpty() && index < nums.length){
            if(!set.contains(nums[index])){
                index++;
                continue; // ✅ skip already processed numbers!
            }

            int num1 = nums[index];
            int num2 = nums[index];
            int count = 1;
            while(set.contains(num1+1)){
                count++;
                num1 = num1 + 1;
                set.remove(num1);
            }

            while(set.contains(num2-1)){
                count++;
                num2 = num2 - 1;
                set.remove(num2);
            }

            maxSeq = Math.max(maxSeq, count);
            index++;
        }
        return maxSeq;
    }
}
