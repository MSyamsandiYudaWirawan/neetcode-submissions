class Solution {
    Pair[] directions = {new Pair(0, 1), new Pair(0, -1), new Pair(1, 0), new Pair(-1, 0)};
    int ROWS;
    int COLS;
    int res = 0;
    private record Pair(int r, int c) {}

    public int maxAreaOfIsland(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1) {
                    // res = Math.max(res, dfs(grid, r, c));
                    res = Math.max(res, bfs(grid, r, c));
                }
            }
        }
        return res;
    }
    private int bfs(int[][] grid, int r, int c) {
        Queue<Pair> q = new ArrayDeque();
        q.add(new Pair(r, c));
        grid[r][c] = 0;
        int sum = 1;

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            for (Pair dir : directions) {
                int nr = cur.r + dir.r;
                int nc = cur.c + dir.c;
                if (nr >= 0 && nc >= 0 && nr < ROWS && nc < COLS && grid[nr][nc] == 1) {
                    sum++;
                    grid[nr][nc] = 0;
                    q.add(new Pair(nr, nc));
                }
            }
        }
        return sum;
    }
    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS || grid[r][c] == 0) {
            return 0;
        }
        grid[r][c] = 0;
        int sum = 1;
        for (Pair dir : directions) {
            int nr = r + dir.r;
            int nc = c + dir.c;
            sum += dfs(grid, nr, nc);
        }
        return sum;
    }
}
