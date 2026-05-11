class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int n = temperatures.length;
        int[] nextGreater = new int[n];
        for(int i=n-1; i>=0; i--){
            int currEle = temperatures[i];
            if(stack.isEmpty()){
                nextGreater[i] = 0;
                stack.push(new int[]{currEle, i});
            }
            else{
                while(!stack.isEmpty() && currEle >= stack.peek()[0]){
                    stack.pop();
                }

                if(stack.isEmpty()){
                    nextGreater[i] = 0;
                    stack.push(new int[]{currEle, i});
                }
                else{
                    int[] prevEle = stack.peek();
                    nextGreater[i] = prevEle[1] - i;
                    stack.push(new int[]{currEle, i});
                }
            }
        }
        return nextGreater;
    }
}
