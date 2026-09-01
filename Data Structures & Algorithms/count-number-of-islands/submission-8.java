class Solution {
    int ROWS;
    int COLS;
    Pair[] directions = {new Pair(0, 1), new Pair(0, -1), new Pair(1, 0), new Pair(-1, 0)};
    private record Pair(int r, int c) {}

    public int numIslands(char[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        int res = 0;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == '1') {
                    bfs(grid, r, c);
                    res++;
                }
            }
        }
        return res;
    }
    private void bfs(char[][] grid, int r, int c) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(r, c));

        while (!q.isEmpty()) {
            Pair p = q.poll();

            int size = q.size();

            for (Pair dir : directions) {
                int nr = p.r + dir.r;
                int nc = p.c + dir.c;

                if (nr >= 0 && nc >= 0 && nr < ROWS && nc < COLS && grid[nr][nc] == '1') {
                    grid[nr][nc] = 0;
                    q.add(new Pair(nr, nc));
                }
            }
        }
    }
}
