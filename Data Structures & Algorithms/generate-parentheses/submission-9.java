class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        dfs(n, sb, 0, 0);
        return res;
    }
    private void dfs(int n, StringBuilder sb, int open, int close) {
        if (sb.length() == 2 * n) {
            res.add(sb.toString());
            return;
        }
        if (open < n) {
            sb.append("(");
            dfs(n, sb, open + 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(")");
            dfs(n, sb, open, close + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
