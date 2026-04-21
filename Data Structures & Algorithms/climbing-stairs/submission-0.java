class Solution {
    public int climbStairs(int n) {
        int[] perStep = new int[n+1];
        perStep[0] = 0; //(0)

        perStep[1] = 1; //(1)
        if(n==1){
            return 1;
        }

        if(n==2){
            return 2;
        }
        perStep[2] = 2; // (11)(2)

        for(int i=3; i<n+1; i++){
            perStep[i] = perStep[i-1]+perStep[i-2];
        }
        return perStep[n];
    }
}
