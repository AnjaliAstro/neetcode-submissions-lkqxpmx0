class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        return findInterLeave(s1, s2, s3, 0, 0, 0);
    }

    private boolean findInterLeave(String s1, String s2, String s3, int i, int j, int k){
        if(k == s3.length()){
            return true;
        }

        boolean result = false;
        if(i < s1.length() && s3.charAt(k) == s1.charAt(i)){
            result = findInterLeave(s1, s2, s3, i+1, j, k+1);
        }

        if(!result && j < s2.length() && s3.charAt(k) == s2.charAt(j)){
            result = findInterLeave(s1, s2, s3, i, j+1, k+1);
        }
        return result;
    }
}

// s3 match with i and j of s1 and s2
//till the moment s1 or s2 is matching 
// then match the t for it and if not then return
// if matched then match further with s 
//alternatively