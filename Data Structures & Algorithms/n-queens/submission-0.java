class Solution {
    Set<Integer> col = new HashSet<>();
    Set<Integer> posD = new HashSet<>();
    Set<Integer> negD = new HashSet<>();
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        List<String> cur = new ArrayList<>();
        backtrack(n, 0, cur);
        return res;
    }

    private void backtrack(int n, int r, List<String> cur) {
        if (n == r) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int c = 0; c < n; c++) {
            if (col.contains(c) || posD.contains(r + c) || negD.contains(r - c)) {
                continue;
            }
            col.add(c);
            posD.add(r + c);
            negD.add(r - c);

            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[c] = 'Q';
            cur.add(new String(row));
            
            backtrack(n, r + 1, cur);
            
            cur.remove(cur.size() - 1);
            col.remove(c);
            posD.remove(r + c);
            negD.remove(r - c);
        }
    }
}
