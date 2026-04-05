class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxFreq = 0;
        for(char ch:tasks){
            freq[ch-'A']++;
            maxFreq = Math.max(maxFreq, freq[ch-'A']);
        }

        int countOfMaxFreq = 0;
        for(int i=0; i<26; i++){
            if(freq[i] == maxFreq){
                countOfMaxFreq++;
            }
        }

        return Math.max(tasks.length, (maxFreq-1)*(n+1) + countOfMaxFreq);
    }
}
