class Solution {
    int rows;
    int cols;
    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int r, int c, int idx) {
        if (idx == word.length()) {
            return true;
        }
        if (r < 0 || r >= rows || c < 0 || c >= cols) {
            return false;
        }
        if (board[r][c] == '#' || board[r][c] != word.charAt(idx)) {
            return false;
        }
        // if same char explore deeper 
        char temp = board[r][c];
        // mark
        board[r][c] = '#';
        boolean res = dfs(board, word, r + 1, c, idx + 1) || 
        dfs(board, word, r - 1, c, idx + 1) || 
        dfs(board, word, r, c + 1, idx + 1) || 
        dfs(board, word, r, c - 1, idx + 1);
        // unmark
        board[r][c] = temp;

        return res;
    }
}
