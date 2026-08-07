class Solution {
    Set<Integer> cols = new HashSet<>();
    Set<Integer> posD = new HashSet<>();
    Set<Integer> negD = new HashSet<>();
    int res = 0;

    public int totalNQueens(int n) {
        List<String> cur = new ArrayList<>();

        backtrack(n,0);

        return res;
    }
    private void backtrack(int n, int r){
        if(r == n){
            res++;
        }

        for(int c=0; c<n; c++){
            if(cols.contains(c) || posD.contains(r+c) || negD.contains(r-c)){
                continue;
            }
            cols.add(c);
            posD.add(r+c);
            negD.add(r-c);

            backtrack(n,r+1);

            cols.remove(c);
            posD.remove(r+c);
            negD.remove(r-c);

        }
    }
}
