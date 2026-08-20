class Solution {
    Pair[] directions = {new Pair(0, 1), new Pair(0, -1), new Pair(1, 0), new Pair(-1, 0)};
    int ROWS;
    int COLS;
    int res = 0;
    int INF = 2147483647;
    private record Pair(int r, int c) {}

    public void islandsAndTreasure(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        List<Pair> treasures = new ArrayList<>();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 0) {
                    treasures.add(new Pair(r, c));
                }
            }
        }
        bfs(grid, treasures);
    }
    private void bfs(int[][] grid, List<Pair> treasures) {
        Queue<Pair> q = new ArrayDeque();
        q.addAll(treasures);
        int distance = 1;
        while (!q.isEmpty()) {
            int size = q.size();

            // process per trasure
            for (int i = 0; i < size; i++) {
                Pair t = q.poll();

                for (Pair dir : directions) {
                    int nr = t.r + dir.r;
                    int nc = t.c + dir.c;
                    if (nr >= 0 && nc >= 0 && nr < ROWS && nc < COLS && grid[nr][nc] == INF) {
                        grid[nr][nc] = distance;
                        q.add(new Pair(nr,nc));
                    }
                }
            }
            distance++;
        }
    }
}
