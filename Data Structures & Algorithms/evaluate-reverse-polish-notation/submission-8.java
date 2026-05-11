class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for(String token:tokens){
            if(!isOperator(token)){
                stack.push(Integer.parseInt(token));
            }
            else{
                if(token.equals("+")){
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    res = num1 + num2;
                }
                else if(token.equals("-")){
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    res = num1 - num2;
                }
                if(token.equals("*")){
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    res = num1 * num2;
                }
                if(token.equals("/")){
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    res = num1 / num2;
                }
                stack.push(res);
            }
        }
        return stack.pop();
        
    }
    private boolean isOperator(String token){
        return token.equals("+") ||
        token.equals("-") ||
        token.equals("*") ||
        token.equals("/");
    }
}
