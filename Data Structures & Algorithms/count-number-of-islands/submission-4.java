class Solution {
    int ROWS;
    int COLS;
    Pair[] directions = {new Pair(0, 1), new Pair(0, -1), new Pair(1, 0), new Pair(-1, 0)};
    private record Pair(int r, int c) {}
    public int numIslands(char[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;

        int island = 0;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == '1') {
                    dfs(grid, new Pair(r, c));
                    island++;
                }
            }
        }
        return island;
    }
    private void dfs(char[][] grid, Pair p) {
        if (p.r < 0 || p.c < 0 || p.r >= ROWS || p.c >= COLS || grid[p.r][p.c] == '0') {
            return;
        }
        grid[p.r][p.c] = '0';
        for (Pair dir : directions) {
            int nr = p.r + dir.r;
            int nc = p.c + dir.c;
            dfs(grid, new Pair(nr, nc));
        }
    }
}
