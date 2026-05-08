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
        }
        long power = Math.abs((long)n);

        calculate(x, power);

        if(isPowerNeg){
            return 1/result;
        }
        return result;
    }

    private void calculate(double x, long power){
        while(power >= 1){
            if(power%2 != 0){
                result *= x;
            }
           x *= x;
           power = power/2;
        }
    }
}

//Always cast to a long before taking the absolute value to avoid this undefined behavior.

//now, I can optimise it further
//see we can make it half the loop
//if n is odd - we need to run the loop - half time + x
// if n is even - we need to run the loop - half time

// 2^3
// 2*2*2

// n<0 n>0
// x<0 x>0