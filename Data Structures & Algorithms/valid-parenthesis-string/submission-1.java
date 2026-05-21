class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> openIndex = new Stack<>();
        Stack<Integer> starIndex = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                openIndex.push(i);
            }
            else if(ch == '*'){
                starIndex.push(i);
            }
            else{
                if(!openIndex.isEmpty()){
                    openIndex.pop();
                }
                else if(!starIndex.isEmpty()){
                    starIndex.pop();
                }
                else{
                    return false;
                }
            }
        }

        while(!openIndex.isEmpty() && !starIndex.isEmpty()){
            if(openIndex.peek() < starIndex.peek()){
                openIndex.pop();
                starIndex.pop();
            }
            else{
                break;
            }
        }
        return openIndex.isEmpty();
    }
}
