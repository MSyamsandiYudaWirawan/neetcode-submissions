class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int res=0;
        for(String token:tokens){
            if(!isOperation(token)){
                stack.push(Integer.parseInt(token));
            }else{
                if(token.equals("+")){
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    res = num2 + num1;
                }
                else if(token.equals("-")){
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    res = num2 - num1;
                }
                else if(token.equals("*")){
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    res = num2 * num1;
                }
                else if(token.equals("/")){
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    res = num2 / num1;
                }
                stack.push(res);
            }
        }
        return stack.pop();
        
    }
    private boolean isOperation(String s){
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

}
