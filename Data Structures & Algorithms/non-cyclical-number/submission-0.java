class Solution {
    public boolean isHappy(int n) {
        boolean res = true;
        Set<Integer> set = new HashSet<>();

        while(n >= 1){
            int sum = 0;
            int temp = n;
            
            while(temp > 0){
                sum = sum + (temp%10)*(temp%10);
                temp = temp/10;
            }
            sum = sum + (temp*temp);

            if(sum == 1){
                return true;
            }
            if(set.contains(sum)){
                return false;
            }
            set.add(sum);
            n = sum;
        }
        return res;
    }
}
