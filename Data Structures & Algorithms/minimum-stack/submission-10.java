class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }
    
    public void push(int val) {
        this.stack.push(val);
        if(!minStack.isEmpty()){
            int top = this.minStack.peek();
            this.minStack.push(Math.min(val,top));
        }else{
            this.minStack.push(val);
        }
    }
    
    public void pop() {
        this.stack.pop();
        this.minStack.pop();
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        return this.minStack.peek();
    }
}
