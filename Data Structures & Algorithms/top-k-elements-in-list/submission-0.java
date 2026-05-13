class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //nlogn
        Arrays.sort(nums);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[1]-b[1]));
        for(int i=0; i<nums.length; i++){
            int freq = 0;
            while(i<nums.length-1 && nums[i] == nums[i+1]){
                freq++;
                i++;
            }
            pq.add(new int[]{nums[i], freq});

            if(pq.size() > k){
                pq.poll();
            }
        }

        int index = 0;
        int[] res = new int[pq.size()];
        while(!pq.isEmpty()){
            res[index] = pq.poll()[0];
            index++;
        }
        return res;
    }
}

//1-1
//2-2
//3-3
