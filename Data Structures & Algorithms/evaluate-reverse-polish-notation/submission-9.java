class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>(); 
        for(String s:tokens){
            if(!isOperator(s)){
                stack.push(Integer.parseInt(s));
            }else{
                int res=0;
                if(s.equals("+")){
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    res = num1 + num2;
                }
                else if(s.equals("-")){
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    res = num1 - num2;
                }
                else if(s.equals("*")){
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    res = num1 * num2;
                }
                else if(s.equals("/")){
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    res = num1 / num2;
                }else{
                    //err
                }
                stack.push(res);
            }
        }
        return stack.peek();
    }
    private boolean isOperator(String s){
        return (s.equals("+")) || (s.equals("-")) || (s.equals("*")) || (s.equals("/"));
    }
}
