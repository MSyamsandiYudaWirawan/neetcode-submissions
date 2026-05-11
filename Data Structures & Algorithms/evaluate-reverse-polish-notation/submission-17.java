class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token:tokens){
            if(!isOperation(token)){
                stack.push(Integer.parseInt(token));
            }else{
                int res = 0;
                if(token.equals("+")){
                    int num2 = stack.pop(); 
                    int num1 = stack.pop();
                    res = num1 + num2;
                }else if(token.equals("-")){
                    int num2 = stack.pop(); 
                    int num1 = stack.pop();
                    res = num1 - num2;
                }
                else if(token.equals("*")){
                    int num2 = stack.pop(); 
                    int num1 = stack.pop();
                    res = num1 * num2;
                }
                else if(token.equals("/")){
                    int num2 = stack.pop(); 
                    int num1 = stack.pop();
                    res = num1 / num2;
                }
                stack.push(res);
            }
        }
        return stack.peek();
    }
    private boolean isOperation(String s){
        return (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));
    }
}
