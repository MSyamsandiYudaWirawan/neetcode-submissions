class MinStack {
    private Stack<Integer> s;
    private Stack<Integer> min_s;

    public MinStack() {
        s = new Stack<>();
        min_s = new Stack<>();
    }
    
    public void push(int val) {
        s.push(val);
        if(min_s.isEmpty()){
            min_s.push(val);
        }
        else{
            min_s.push(Math.min(val,min_s.peek()));
        }
    }
    
    public void pop() {
        s.pop();
        min_s.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min_s.peek();
    }
}
