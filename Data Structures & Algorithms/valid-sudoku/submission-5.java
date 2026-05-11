class Solution {
    public boolean isValidSudoku(char[][] board) {

    List<Set<Integer>> rows = new ArrayList<>();
    List<Set<Integer>> cols = new ArrayList<>();
    List<Set<Integer>> squares = new ArrayList<>();

    for(int i=0; i<9; i++){
        rows.add(new HashSet<>());
        cols.add(new HashSet<>());
        squares.add(new HashSet<>());
    }

    for(int row=0; row<9; row++){
        for(int col=0; col<9; col++){
            char c = board[row][col];
            if(c == '.'){
                continue;
            }
            int num = c-'0';
            int squareIndex = (row/3)*3 + (col/3);

            if(rows.get(row).contains(num) ||
                cols.get(col).contains(num) ||
                squares.get(squareIndex).contains(num)){
                    return false;
                }
            rows.get(row).add(num);
            cols.get(col).add(num);
            squares.get(squareIndex).add(num);
        }
    }
    return true;

    }
}
