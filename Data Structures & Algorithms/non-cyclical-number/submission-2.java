class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = sumOfSquares(n);

        while(fast != 1 && slow != fast){
            slow = sumOfSquares(slow);       // one step
            fast = sumOfSquares(sumOfSquares(fast)); // two steps
        }
        return fast == 1;
    }

    private int sumOfSquares(int n){
        int sum = 0;
        while(n > 0){
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}
