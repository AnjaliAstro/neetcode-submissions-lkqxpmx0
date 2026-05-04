class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int high = 0; 
        int n = piles.length;
        for(int i=0; i<n; i++){
            high = Math.max(high, piles[i]);
        }

        int k = 0;
        int low = 1;
        while(low < high){
            k = (low+high)/2;

            if(canEat(piles, n, k, h)){
                high = k;
            }
            else{
                low = k+1;
            }
        }
        return low;
    }

    private boolean canEat(int[] piles, int n, int k, int h){
        int time = 0;

        for(int i=0; i<n; i++){
            time = time +  (piles[i]+k-1)/k;
        }

        if(time <= h){
            return true;
        }
        return false;
    }
}

// k bananas per hour
