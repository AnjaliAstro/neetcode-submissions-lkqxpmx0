class MinStack {
    Stack<Integer> mainStack;
    Stack<Integer> minStack;
    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        mainStack.push(val);
        if(!minStack.isEmpty()){
            int minEle = Math.min(mainStack.peek(), minStack.peek());
            minStack.push(val);
            minStack.push(minEle);
        }
        else{
            minStack.push(val);
            minStack.push(val);
        }
    }
    
    public void pop() {
        mainStack.pop();
        minStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
