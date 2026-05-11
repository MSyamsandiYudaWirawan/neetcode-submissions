class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        int res = 0;
        for(String token:tokens){
            if(!isOperation(token)){
                s.push(Integer.parseInt(token));
            }
            else {
                if(token.equals("+")){
                    int num2 = s.pop();
                    int num1 = s.pop();
                    res = num1 + num2;
                }
                else if(token.equals("-")){
                    int num2 = s.pop();
                    int num1 = s.pop();
                    res = num1 - num2;
                }
                else if(token.equals("*")){
                    int num2 = s.pop();
                    int num1 = s.pop();
                    res = num1 * num2;
                }
                else if(token.equals("/")){
                    int num2 = s.pop();
                    int num1 = s.pop();
                    res = num1 / num2;
                }
                s.push(res);
            }
        }
        return s.pop();
    }
    private boolean isOperation(String token){
        return token.equals("+") || 
        token.equals("-") || 
        token.equals("*") || 
        token.equals("/");   
    }
}
