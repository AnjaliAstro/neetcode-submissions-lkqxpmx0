class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        Set<Character> unique = new HashSet<>();
        while(right < s.length()){
            if(unique.contains(s.charAt(right))){
                while(unique.contains(s.charAt(right))){
                    unique.remove(s.charAt(left));
                    left++;
                }
            }
            unique.add(s.charAt(right));
            right++;
            maxLen = Math.max(maxLen, right-left);
        }
        return maxLen;
    }
}
