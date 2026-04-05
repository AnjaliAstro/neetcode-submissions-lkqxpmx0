class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Pair<Integer, Integer>> charIntervals = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            //start
            if(!charIntervals.containsKey(ch)){
                charIntervals.put(ch, new Pair<>(i, i));
            }
            else{
                Pair pair = charIntervals.get(ch);
                Pair pair2 = new Pair<>(pair.getKey(), i);
                charIntervals.put(ch, pair2);
            }
        }

        //merge intervals concept
        int[][] intervals = new int[charIntervals.size()][2];
        int i=0;
        for(Pair<Integer, Integer> pair: charIntervals.values()){
                intervals[i][0] = pair.getKey();
                intervals[i][1] = pair.getValue();
                i++;
        }

        //merge Intervals
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);

        int s1 = intervals[0][0];
        int e1 = intervals[0][1];
        List<int[]> merged = new ArrayList<>();

        for(int[] interval:intervals){
            int s2 = interval[0];
            int e2 = interval[1];

            if(s2 <= e1){
                e1 = Math.max(e1, e2);
            }
            else{
                merged.add(new int[]{s1, e1});
                s1 = s2;
                e1 = e2;
            }
        }
        merged.add(new int[]{s1, e1});

        List<Integer> ans = new ArrayList<>();
        for(int[] ele:merged){
            ans.add(ele[1]-ele[0]+1);
        }
        return ans;
    }
}

// xyxxy zbzbb i s l
// all possibilities - naah
// seems like merge intervals