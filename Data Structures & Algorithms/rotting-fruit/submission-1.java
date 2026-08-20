class Solution {
    Pair[] directions = {new Pair(0, 1), new Pair(0, -1), new Pair(1, 0), new Pair(-1, 0)};
    int ROWS;
    int COLS;
    int res = 0;
    private record Pair(int r, int c) {}

    public int orangesRotting(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;

        Queue<Pair> q = new ArrayDeque();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 2) {
                    q.add(new Pair(r, c));
                }
            }
        }
        int time = bfs(grid, q);

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1) {
                    return -1;
                }
            }
        }

        return time;
    }
    private int bfs(int[][] grid, Queue<Pair> q) {
        int time = 0;
        while (!q.isEmpty()) {
            int rotSize = q.size();
            boolean rottedAny = false;
            for (int i = 0; i < rotSize; i++) {
                Pair rot = q.poll();

                for (Pair dir : directions) {
                    int nr = rot.r + dir.r;
                    int nc = rot.c + dir.c;

                    if (nr >= 0 && nc >= 0 && nr < ROWS && nc < COLS && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        rottedAny = true;
                        q.add(new Pair(nr, nc));
                    }
                }
            }
            if (rottedAny) time++;
        }
        return time;
    }
}
