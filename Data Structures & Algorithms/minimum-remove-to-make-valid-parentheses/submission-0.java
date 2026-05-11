class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        for(int i=0; i<sb.length(); i++){
            if(sb.charAt(i) == '('){
                stack.push(i);
            }
            else if(sb.charAt(i) == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
                else{
                    sb.setCharAt(i,'\0');
                }
            }
        }
        while(!stack.isEmpty()){
            sb.setCharAt(stack.pop(), '\0');
        }

        StringBuilder res = new StringBuilder();
        for(int i=0; i< sb.length(); i++){
            if(sb.charAt(i) !='\0'){
                res.append(sb.charAt(i));
            }
        }
        return res.toString();
    }

}