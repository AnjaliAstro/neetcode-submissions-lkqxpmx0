class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> mergedIntervals = new ArrayList<>();
        boolean ifInserted = false;

        for(int[] interval:intervals){
            //interval happens when s2<e1 && s2>s1
            // or when s1<e2 && s1>s2

            if((newInterval[0]<=interval[1] && newInterval[0]>=interval[0])||
                (interval[0]<=newInterval[1] && interval[0]>=newInterval[0])){
                    newInterval[0] = Math.min(newInterval[0], interval[0]);
                    newInterval[1] = Math.max(newInterval[1], interval[1]);
                    ifInserted = true;
                }
            else{
                mergedIntervals.add(interval);
            }
        }


        int insertPos = 0;
        for (int i = 0; i < mergedIntervals.size(); i++) {
            if (mergedIntervals.get(i)[0] < newInterval[0]) insertPos = i + 1;
            else break;
        }
        mergedIntervals.add(insertPos, newInterval);


        int[][] mergedArray = new int[mergedIntervals.size()][2];
        int index = 0;
        for(int[] interval:mergedIntervals){
            mergedArray[index] = interval;
            index++;
        }

        return mergedArray;
    }
}


//one way - O(n)
// 1,3 2,5 = 1,5 4,6 = 1,6

//other ways - O(nlogn)
// 1,1
// 2,1
// 3, -1
// 4, 1
// 5, -1
// 6, -1


//1,1
//2,-1
//3,1
//5,-1
//6,1
//7,-1
//9,1
//10,-1
