class Solution {
    // INT_MAX is 2147483647
    // INT_MIN is -2147483648
    public int reverse(int x) {
        int res = 0;
        boolean isNeg = false;
        if(x < 0){
            isNeg = true;
        }

        while(Math.abs(x) > 0){
            int rem = x%10;

            if(isNeg){
                if(res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE/10 && rem < -8)){
                    return 0;
                }
            }
            else{
                if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && rem > 7)){
                    return 0;
                }
            }
            
            res = res*10 + rem;
            x = x/10;
        }
        return res;
    }
}
