class Solution {
    Pair[] directions = {new Pair(0, 1), new Pair(0, -1), new Pair(1, 0), new Pair(-1, 0)};
    int ROWS;
    int COLS;
    private record Pair(int r, int c) {}

    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;
        Queue<Pair> q = new ArrayDeque();

        for (int r = 0; r < ROWS; r++) {
            if (board[r][0] == 'O') {
                board[r][0] = '#';
                q.add(new Pair(r, 0));
            }

            if (board[r][COLS - 1] == 'O') {
                q.add(new Pair(r, COLS - 1));
                board[r][COLS - 1] = '#';
            }
        }
        for (int c = 0; c < COLS; c++) {
            if (board[0][c] == 'O') {
                q.add(new Pair(0, c));
                board[0][c] = '#';
            }
            if (board[ROWS - 1][c] == 'O') {
                q.add(new Pair(ROWS - 1, c));
                board[ROWS - 1][c] = '#';
            }
        }

        bfsMark(board, q);

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == '#') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void bfsMark(char[][] board, Queue<Pair> q) {
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (Pair dir : directions) {
                int nr = cur.r + dir.r;
                int nc = cur.c + dir.c;
                if (nr >= 0 && nc >= 0 && nr < ROWS && nc < COLS && board[nr][nc] == 'O') {
                    q.add(new Pair(nr, nc));
                    board[nr][nc] = '#';
                }
            }
        }
    }
}
