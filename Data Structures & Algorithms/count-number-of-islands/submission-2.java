class Solution {
    private Pair[] directions = {
        new Pair(0, 1),
        new Pair(0, -1),
        new Pair(1, 0),
        new Pair(-1, 0),
    };
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
        q.add(new Pair(r, c));
        grid[r][c] = '0';

        while (!q.isEmpty()) {
            Pair p = q.poll();

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
    private record Pair(int r, int c) {}
}
