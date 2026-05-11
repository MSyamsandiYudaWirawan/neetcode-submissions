class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Integer>> row = new ArrayList<>();
        List<Set<Integer>> col = new ArrayList<>();
        List<Set<Integer>> square = new ArrayList<>();

        for(int i=0; i<9; i++){
            row.add(new HashSet<>());
            col.add(new HashSet<>());
            square.add(new HashSet<>());
        }

        for(int r=0; r<9; r++){
            for(int c=0; c<9; c++){
                char car = board[r][c];
                if(car == '.'){
                    continue;
                }
                int n = car - '0';
                int indexSquare = (r/3)*3 + c/3;
                if(row.get(r).contains(n) ||
                col.get(c).contains(n) ||
                square.get(indexSquare).contains(n)){
                    return false;
                }
                row.get(r).add(n);
                col.get(c).add(n);
                square.get(indexSquare).add(n);
            }
        }
        return true;
    }
}
