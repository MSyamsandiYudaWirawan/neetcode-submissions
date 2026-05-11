class Solution {
    public boolean isValidSudoku(char[][] board) {
        ArrayList<Set<Integer>> rows = new ArrayList<>();
        ArrayList<Set<Integer>> cols = new ArrayList<>();
        ArrayList<Set<Integer>> boxs = new ArrayList<>();

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
                int boxIndex = (row/3)*3 + (col/3);
                if(rows.get(row).contains(n) || cols.get(col).contains(n) ||
                 boxs.get(boxIndex).contains(n)){
                    return false;
                 }
                 rows.get(row).add(n);
                 cols.get(col).add(n);
                 boxs.get(boxIndex).add(n);
            }
        }
        return true;
    }
}
