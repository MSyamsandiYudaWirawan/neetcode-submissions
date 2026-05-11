class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> stackMin;

    public MinStack() {
        stack = new Stack<>();
        stackMin = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(stackMin.isEmpty()){
            stackMin.push(val);
        }
        else{
            int min = Math.min(val,stackMin.peek());
            stackMin.push(min);
        }
    }
    
    public void pop() {
        stack.pop();
        stackMin.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return stackMin.peek();
    }
}
