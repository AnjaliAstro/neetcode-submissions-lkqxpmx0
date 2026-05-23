class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int minInt = Integer.MAX_VALUE;
        int maxInt = Integer.MIN_VALUE;
        int maxFreq = 0;
        Map<Integer, Integer>freqMap = new HashMap<>();

        for(int i=0; i<hand.length; i++){
            freqMap.put(hand[i], freqMap.getOrDefault(hand[i], 0)+1);
            maxFreq = Math.max(maxFreq, freqMap.get(hand[i]));
            minInt = Math.min(minInt, hand[i]);
            maxInt = Math.max(maxInt, hand[i]);
        }

        for(int i=minInt; i<=maxInt-groupSize+1; i++){
            int start = i;
            int startFreq = freqMap.getOrDefault(start, 0);

            if(startFreq == 0){
                continue;
            }

            //reduce alll subsequent integer frequencies with it
            while(start < i+groupSize){
                freqMap.put(start, freqMap.getOrDefault(start, 0)-startFreq);
                if(freqMap.get(start) < 0){
                    System.out.println("i" + i+ "start"+start+""+freqMap.get(start));
                    return false;
                }
                start++;
            }
        }

        for(int i = maxInt - groupSize + 2; i<=maxInt; i++){
            if(freqMap.get(i) > 0){
                return false;
            }
        }
        return true;
    }
}

//1-1
//2-2
//3-2
//4-2
//5-1

//1-1
//2-1
//3-2
//4-1
//5-1
//6-1
//7-1


//get a freqMap and the max freq will be the min groups to be formed
//then start iterating with the minimum integer and then keep grouping in the groups
// after one group start with the next minimum unless all the frequencies become zero
//I think its greedy