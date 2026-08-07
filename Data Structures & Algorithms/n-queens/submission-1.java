class Solution {
    Set<Integer> cols = new HashSet<>();
    Set<Integer> posD = new HashSet<>();
    Set<Integer> negD = new HashSet<>();
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        List<String> cur = new ArrayList<>();

        backtrack(n,cur,0);

        return res;
    }
    private void backtrack(int n, List<String> cur, int r){
        if(r == n){
            res.add(new ArrayList<>(cur));
        }

        for(int c=0; c<n; c++){
            if(cols.contains(c) || posD.contains(r+c) || negD.contains(r-c)){
                continue;
            }
            cols.add(c);
            posD.add(r+c);
            negD.add(r-c);

            char[] row = new char[n];
            Arrays.fill(row,'.');
            row[c] = 'Q';
            cur.add(new String(row));

            backtrack(n,cur,r+1);

            cur.remove(cur.size()-1);

            cols.remove(c);
            posD.remove(r+c);
            negD.remove(r-c);

        }
    }
}
