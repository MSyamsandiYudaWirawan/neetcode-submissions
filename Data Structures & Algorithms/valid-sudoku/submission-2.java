class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Integer>> listSetRows = new ArrayList<>();
        List<Set<Integer>> listSetCols = new ArrayList<>();
        List<Set<Integer>> listSetSquares = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            listSetRows.add(new HashSet<>());
            listSetCols.add(new HashSet<>());
            listSetSquares.add(new HashSet<>());
        }

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char cell = board[row][col];

                if (cell == '.') continue; 
                
                int num = cell - '0'; 
                
                int squareIndex = (row / 3) * 3 + (col / 3); 
                
                  if (listSetRows.get(row).contains(num) ||
                    listSetCols.get(col).contains(num) ||
                    listSetSquares.get(squareIndex).contains(num)) {
                    return false; 
                }


                listSetRows.get(row).add(num);
                listSetCols.get(col).add(num);
                listSetSquares.get(squareIndex).add(num);
            }
        }

        return true;
    }
}
