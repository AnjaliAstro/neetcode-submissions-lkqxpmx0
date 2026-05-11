class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        if(n1 > n2){
            return false;
        }

        int[] freqS1 = new int[26];
        for(int i=0; i<s1.length(); i++){
            char ch = s1.charAt(i);
            freqS1[ch-'a']++;
        }

        int[] windowFreq = new int[26];
        for(int i = 0; i < n1; i++){
            windowFreq[s2.charAt(i)-'a']++;
        }

        int left = 0;
        for(int right = n1; right < n2; right++){
            // compare arrays
            if(Arrays.equals(windowFreq, freqS1)) return true;
            
            // add new right char
            windowFreq[s2.charAt(right)-'a']++;
            
            // remove left char
            windowFreq[s2.charAt(left)-'a']--;
            left++;
        }

        // check last window!
        return Arrays.equals(windowFreq, freqS1);
    }
}

//1st approach - size of s1<= size of s2 -> all permutations of s1 and finde indexOf in s2
// TC - (permutation of s1) find in s2

//find the first occurence of the first char of s1 and expand both sides:- with the same length and see if it has same amount of characters and nothing else
// if it is then move to another index

//its much simpler -> its the window sliding -> so kinda 2nd approach just slide the window instead of expanding here and there