class Solution {
    private record Pair(int r, int c) {}
    private Pair[] direction = {new Pair(0, 1), new Pair(0, -1), new Pair(1, 0), new Pair(-1, 0)};
    private int ROWS;
    private int COLS;

    public int numIslands(char[][] grid) {
        int island = 0;

        ROWS = grid.length;
        COLS = grid[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == '1') {
                    bfs(grid, r, c);
                    island++;
                }
            }
        }

        return island;
    }

    private void bfs(char[][] grid, int r, int c) {
        Queue<Pair> q = new ArrayDeque<>(100);
        grid[r][c] = '0';
        q.add(new Pair(r, c));

        while (!q.isEmpty()) {
            Pair p = q.poll();

            for (Pair dir : direction) {
                int nr = p.r + dir.r;
                int nc = p.c + dir.c;

                if (nr >= 0 && nc >= 0 && nr < ROWS && nc < COLS && grid[nr][nc] == '1') {
                    q.add(new Pair(nr, nc));
                    grid[nr][nc] = '0';
                }
            }
        }
    }
}
