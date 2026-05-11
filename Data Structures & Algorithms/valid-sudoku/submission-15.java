class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<HashSet<Integer>> rows = new ArrayList<>();
        List<HashSet<Integer>> cols = new ArrayList<>();
        List<HashSet<Integer>> boxs = new ArrayList<>();

        for(int i=0; i<9; i++){
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            boxs.add(new HashSet<>());
        } 

        for(int row = 0; row<9; row++){
            for(int col = 0; col<9; col++){
                char c = board[row][col];
                if(c == '.'){
                    continue;
                }
                int num = c - '0';
                int boxIndex = (row/3)*3 + (col/3);
                if(rows.get(row).contains(num) || cols.get(col).contains(num) || boxs.get(boxIndex).contains(num)){
                    return false;
                }
                rows.get(row).add(num);
                cols.get(col).add(num);
                boxs.get(boxIndex).add(num);
            }
        }
        return true;
    }
}
