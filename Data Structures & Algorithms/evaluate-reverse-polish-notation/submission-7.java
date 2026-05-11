class Solution {
    public int evalRPN(String[] tokens) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for(String token:tokens){
            if(!isOperation(token)){
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
        return stack.pop();
    }
    private boolean isOperation(String token){
        return token.equals("+") ||
        token.equals("-") ||
        token.equals("*") ||
        token.equals("/");
    }
}
