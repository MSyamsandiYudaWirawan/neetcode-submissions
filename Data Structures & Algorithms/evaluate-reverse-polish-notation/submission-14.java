class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token:tokens){
            if(!isOperator(token)){
                stack.push(Integer.parseInt(token));
            } else {
                int val = 0;
                if(token.equals("+")){
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    val = num2 + num1;
                } else if(token.equals("-")){
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    val = num2 - num1;
                }else if(token.equals("*")){
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    val = num2 * num1; 
                }else if(token.equals("/")){
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    val = num2 / num1;
                }
                stack.push(val);
            }
        }
        return stack.peek();
    }

    private boolean isOperator(String s){
        return (s.equals("+")) || (s.equals("-")) || (s.equals("*")) || (s.equals("/"));
    }
}