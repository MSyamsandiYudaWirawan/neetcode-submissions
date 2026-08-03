class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        dfs(n, 0, 0, sb);
        return res;
    }
    private void dfs(int n, int open, int close, StringBuilder sb) {
        if (sb.length() == 2 * n) {
            res.add(sb.toString());
            return;
        }
        if(open<n){
            sb.append("(");
            dfs(n,open+1,close,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(open > close){
            sb.append(")");
            dfs(n,open,close+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
