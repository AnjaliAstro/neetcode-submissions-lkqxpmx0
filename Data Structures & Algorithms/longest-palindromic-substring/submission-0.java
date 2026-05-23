class Solution {
    String longest = "";
    public String longestPalindrome(String s) {
        for(int i=0; i<s.length(); i++){
            String oddPalin = getLongestPalindrome(s, i, i);
            String evenPalin = getLongestPalindrome(s, i, i+1);

            if(longest.length() < oddPalin.length()){
                longest = oddPalin;
            }

            if(longest.length() < evenPalin.length()){
                longest = evenPalin;
            }
        }
        return longest;
    }

    private String getLongestPalindrome(String s, int left, int right){
        while(left>= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }
}
