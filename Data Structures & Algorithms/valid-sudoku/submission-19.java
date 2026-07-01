class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Integer>> rows = new ArrayList<>();
        List<Set<Integer>> cols = new ArrayList<>();
        List<Set<Integer>> boxs = new ArrayList<>();

        for(int i=0; i<9; i++){
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            boxs.add(new HashSet<>());
        }

        for(int r=0; r<9; r++){
            for(int c=0; c<9; c++){
                char b = board[r][c];
                if(b == '.'){
                    continue;
                }
                int n = b - 'a';
                int boxIdx = (r/3)*3 + (c/3);

                if(rows.get(r).contains(n) || 
                cols.get(c).contains(n) ||
                boxs.get(boxIdx).contains(n)){
                    return false;
                }
                rows.get(r).add(n);
                cols.get(c).add(n);
                boxs.get(boxIdx).add(n);
            }
        }
        return true;
    }
}
