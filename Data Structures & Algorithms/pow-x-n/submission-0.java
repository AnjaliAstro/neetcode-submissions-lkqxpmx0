class Solution {
    //first ask ques if x is float/int and if n is float/int or neg/pos
    double result = 1;
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }

        if(x == 0){
            return 0;
        }

        boolean isPowerNeg = false;
        if(n < 0){
            isPowerNeg = true;
            n *= -1;
        }
        
        calculate(x, n);

        if(isPowerNeg){
            return 1/result;
        }
        return result;
    }

    private void calculate(double x, double n){
        while(n > 0){
           result *= x;
           n--;
        }
    }
}
// 2^3
// 2*2*2

// n<0 n>0
// x<0 x>0