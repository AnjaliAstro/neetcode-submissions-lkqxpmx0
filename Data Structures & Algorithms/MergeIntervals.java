class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        List<int[]> merged = new ArrayList<>();
        int s1 = intervals[0][0];
        int e1 = intervals[0][1];

        for(int[] interval:intervals){
            int s2 = interval[0];
            int e2 = interval[1];

            if(s2<=e1){
                //merge
                e1 = Math.max(e1,e2);
            }
            else{
                int[] merge = new int[]{s1, e1};
                merged.add(merge);
                s1 = s2;
                e1 = e2;
            }
        }
        merged.add(new int[]{s1,e1});
        
        int[][] ans = new int[merged.size()][2];
        for(int i=0; i<merged.size(); i++){
            ans[i] = merged.get(i);
        }
        return ans;
    }
}