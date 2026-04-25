class Solution {
    int[] memo;
    public int numDecodings(String s) {
        int decodeWays = 0;
        int n = s.length();
        memo = new int[n];
        Arrays.fill(memo, -1);
        decodeWays = partition(s, 0);
        return decodeWays;
    }

    private int partition(String s, int index){
        if(index == s.length()){
            return 1;
        }

        if(index > s.length()){
            return 0;
        }

        if(memo[index] != -1){
            return memo[index];
        }

        int ways = 0;
        String oneDigit = s.substring(index, index+1);
        if(isValid(oneDigit)){
            ways += partition(s, index+1);
        }
        if(index + 2 <= s.length()){
            String doubleDigit = s.substring(index, index+2);
            if(isValid(doubleDigit)){
                ways += partition(s, index+2);
            }
        }

        memo[index] = ways;
        return ways;
    }

    private boolean isValid(String str){
        if(str.isEmpty() || str.charAt(0) == '0' || Integer.parseInt(str) > 26){
            return false;
        }
        return true;
    }
}

//will create partition between every Character and will check