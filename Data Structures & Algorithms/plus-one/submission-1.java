class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int len = digits.length;
        for(int i=len-1; i>=0; i--){
            if(carry != 0){
                int num = digits[i]+carry;
                carry = num/10;
                digits[i] = num%10;
            }
        }

        if(carry != 0){
            int[] result = new int[len+1];
            result[0] = carry;
            System.arraycopy(digits, 0, result, 1, len);
            return result;
        }
        return digits;
    }
}
