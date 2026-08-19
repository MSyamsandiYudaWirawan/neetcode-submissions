class Solution {
    Pair[] directions = {new Pair(0, 1), new Pair(0, -1), new Pair(1, 0), new Pair(-1, 0)};
    int ROWS;
    int COLS;
    private record Pair(int r, int c) {}

    public int numIslands(char[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;

        int res = 0;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == '1') {
                    // dfs(grid, r, c);
                    bfs(grid, r, c);
                    res++;
                }
            }
        }
        return res;
    }
    private void bfs(char[][] grid, int r, int c) {
        Queue<Pair> q = new ArrayDeque();
        q.add(new Pair(r, c));
        grid[r][c] = '0';
        

        while (!q.isEmpty()) {
            Pair p = q.poll();
            // grid[p.r][p.c] = '0';

            for (Pair dir : directions) {
                int nr = p.r + dir.r;
                int nc = p.c + dir.c;
                if (nr >= 0 && nc >= 0 && nr < ROWS && nc < COLS && grid[nr][nc] == '1') {
                    grid[nr][nc] = '0';
                    q.add(new Pair(nr, nc));
                }
            }
        }
    }
    private void dfs(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        for (Pair dir : directions) {
            int nr = r + dir.r;
            int nc = c + dir.c;
            dfs(grid, nr, nc);
        }
    }
}
