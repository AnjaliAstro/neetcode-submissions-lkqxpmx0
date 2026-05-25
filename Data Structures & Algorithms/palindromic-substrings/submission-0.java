class Solution {
    int palinCounts = 0;
    public int countSubstrings(String s) {
        getPalinCounts(s, 0);
        return palinCounts;
    }

    private void getPalinCounts(String s, int index){
        if(index >= s.length()){
            return;
        }

        for(int i=index; i<s.length(); i++){
            if(isPalin(s.substring(index, i+1))){
                palinCounts++;
            }
        }
        getPalinCounts(s, index+1);
    }

    private boolean isPalin(String s){
        int left = 0;
        int right = s.length()-1;

        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
