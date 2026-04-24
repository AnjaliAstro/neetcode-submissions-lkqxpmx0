class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for(String ch:tokens){
            if(isOperator(ch)){
                int second = Integer.parseInt(stack.pop());
                int first = Integer.parseInt(stack.pop());
                int result = 0;
                if(ch.equals("+")){
                    result = first+second;
                }
                else if(ch.equals("-")){
                    result = first-second;
                }
                else if(ch.equals("*")){
                    result = first*second;
                }
                else{
                    result = first/second;
                }

                String inputCh = String.valueOf(result);
                stack.push(inputCh);
            }
            else{
                stack.push(ch);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private boolean isOperator(String ch){
        if(ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/")){
            return true;
        }
        return false;
    }
}
