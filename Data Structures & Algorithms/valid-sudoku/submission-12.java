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
        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                char car = board[r][c];
                if(car == '.'){
                    continue;
                }
                
                int n = car -'0';
                int indexSquare = (r/3)*3 + (c/3);
                if(rows.get(r).contains(n) ||
                cols.get(c).contains(n)||
                squares.get(indexSquare).contains(n)){
                    return false;
                }
                rows.get(r).add(n);
                cols.get(c).add(n);
                squares.get(indexSquare).add(n);
            }
        }
        return true;
    }
}
