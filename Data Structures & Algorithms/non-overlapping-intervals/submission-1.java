class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //Greedy
        //whatever ends up first is better and will have less overlap
        Arrays.sort(intervals, (a,b)->(a[1]-b[1]));

        int minOverlap = 0;
        int[] prevInterval  = new int[]{-50005, -50005};
        for(int[] interval:intervals){
            // if((interval[0] < prevInterval[1] && interval[0] > prevInterval[0]) || (prevInterval[1] < interval[1] && prevInterval[1] > interval[0])){
            //     minOverlap++;
            // }
            if(prevInterval[1] > interval[0]){
                minOverlap++;
            }
            else{
                prevInterval = interval;
            }
        }
        return minOverlap;
    }
}
//1 1
//1 1
//2 -1
//2 1
//4 -1
//4 -1