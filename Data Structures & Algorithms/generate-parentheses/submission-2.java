class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtracking(0,0,n,res,sb);
        return res;
        
    }
    private void backtracking(int open, int close, int n, 
    List<String> res, StringBuilder sb){
        if(open == close && open == n){
            res.add(sb.toString());
        }
        if(open < n){
            sb.append("(");
            backtracking(open+1,close,n,res,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close < open){
            sb.append(")");
            backtracking(open,close+1,n,res,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
