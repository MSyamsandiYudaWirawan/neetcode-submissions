class Solution {
    Pair[] directions = {new Pair(0, 1), new Pair(0, -1), new Pair(1, 0), new Pair(-1, 0)};
    int ROWS;
    int COLS;
    int res = 0;
    private record Pair(int r, int c) {}
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        ROWS = heights.length;
        COLS = heights[0].length;
        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];
        Queue<Pair> qpac = new ArrayDeque();
        Queue<Pair> qatl = new ArrayDeque();

        for (int c = 0; c < COLS; c++) {
            qpac.add(new Pair(0, c));
            pac[0][c] = true;
            qatl.add(new Pair(ROWS - 1, c));
            atl[ROWS - 1][c] = true;
        }

        for (int r = 0; r < ROWS; r++) {
            qpac.add(new Pair(r, 0));
            pac[r][0] = true;
            qatl.add(new Pair(r, COLS - 1));
            atl[r][COLS - 1] = true;
        }
        bfs(heights, qpac, pac);
        bfs(heights, qatl, atl);

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pac[r][c] && atl[r][c]) {
                    res.add(List.of(r, c));
                }
            }
        }
        return res;
    }
    private void bfs(int[][] heights, Queue<Pair> q, boolean[][] ocean) {
        while (!q.isEmpty()) {
            Pair cur = q.poll();

            for (Pair dir : directions) {
                int nr = cur.r + dir.r;
                int nc = cur.c + dir.c;


                if (nr >= 0 && nc >= 0 && nr < ROWS && nc < COLS
                    && heights[cur.r][cur.c] <= heights[nr][nc] && !ocean[nr][nc]) {
                    ocean[nr][nc] = true;
                    q.add(new Pair(nr, nc));
                }
            }
        }
    }
}
