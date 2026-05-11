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

        for(int r=0; r<9; r++){
            for(int c=0; c<9; c++){
                char character = board[r][c];
                if(character == '.'){
                    continue;
                }
                int num = character-'0';
                int squareIndex = (r/3)*3 + (c/3);
                if(rows.get(r).contains(num) || cols.get(c).contains(num) || squares.get(squareIndex).contains(num)){
                    return false;
                }
                rows.get(r).add(num);
                cols.get(c).add(num);
                squares.get(squareIndex).add(num);
            }
        }
        return true;
    }
}
