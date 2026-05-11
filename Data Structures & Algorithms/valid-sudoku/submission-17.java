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
        for(int row=0; row<9; row++){
            for(int col=0; col<9; col++){
                char c = board[row][col];
                if(c == '.'){
                    continue;
                }
                int n = c - '0';
                int boxIdx = (row/3)*3 + (col/3);
                if(rows.get(row).contains(n) || 
                cols.get(col).contains(n) ||
                boxs.get(boxIdx).contains(n)){
                    return false;
                }
                rows.get(row).add(n);
                cols.get(col).add(n);
                boxs.get(boxIdx).add(n);
            }
        }
         return true;
    }
}
