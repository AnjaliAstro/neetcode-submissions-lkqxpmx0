class Solution {
    public int[][] merge(int[][] intervals) {
        //nlogn
        List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals, (a,b)->(a[0]-b[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i=1; i<intervals.length; i++){
            int[] curr = intervals[i];
            int start2 = curr[0];
            int end2 = curr[1];
            
            if(start2<=end){
                end = Math.max(end, end2);
            }
            else{
                merged.add(new int[]{start, end});
                start = start2;
                end = end2;
            }
        }

        merged.add(new int[]{start, end});

        int[][] mergedArray = new int[merged.size()][2];
        for(int i=0; i<merged.size(); i++){
            mergedArray[i][0] = merged.get(i)[0];
            mergedArray[i][1] = merged.get(i)[1];
        }
        return mergedArray;
    }
}
