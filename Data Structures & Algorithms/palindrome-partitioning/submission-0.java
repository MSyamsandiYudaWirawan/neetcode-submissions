class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        List<String> cur = new ArrayList<>();
        dfs(s, cur, 0);
        return res;
    }
    private void dfs(String s, List<String> cur, int idx) {
        if (idx >= s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            String sub = s.substring(idx, i + 1);
            if (!isPalindrom(sub)) {
                continue;
            }
            cur.add(sub);
            dfs(s, cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
    private boolean isPalindrom(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
