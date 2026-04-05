class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> charFreq = new HashMap<>();
        int maxFreq = 0;
        for(char ch:tasks){
            charFreq.put(ch, charFreq.getOrDefault(ch, 0)+1);
            maxFreq = Math.max(maxFreq, charFreq.get(ch));
        }

        PriorityQueue<Integer> frequency = new PriorityQueue<>((a,b)->(b-a));
        for(char ch:charFreq.keySet()){
            frequency.add(charFreq.get(ch));
        }

        Queue<int[]> cooldown = new LinkedList<>(); //freq, nextAvailableAt

        int time = 0;
        while(true){
            if(frequency.isEmpty() && cooldown.isEmpty()){
                return time;
            }

            time++;
            if(!cooldown.isEmpty() && cooldown.peek()[1] == time){
                frequency.add(cooldown.poll()[0]);
            }

            if(!frequency.isEmpty()){
                int freq = frequency.poll();
                freq--;
                if(freq > 0) 
                    cooldown.add(new int[]{freq, time + n + 1}); 
            }
        }
    }
}

// A = 3
// B = 1
// C = 1

// A B C - A - - - A

// X = 2
// Y = 2

// n = 2

// X Y - X Y 

//intuition is max frequency first and with distinct min gap and then address the next