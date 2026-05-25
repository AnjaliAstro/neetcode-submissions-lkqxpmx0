class Solution {
    int palinCounts = 0;
    public int countSubstrings(String s) {
        for(int i=0; i<s.length(); i++){
            int odd = isPalin(s, i, i);
            int even = isPalin(s, i, i+1);
            palinCounts += odd + even;
        }
        return palinCounts;
    }

    private int isPalin(String s, int left, int right){
        int count = 0;
        while(left>=0 && right<s.length() && left <= right){
            if(s.charAt(left) != s.charAt(right)){
                break;
            }
            left--;
            right++;
            count++;
        }
        return count;
    }
}
//aab
//a
