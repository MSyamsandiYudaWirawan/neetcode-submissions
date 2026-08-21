class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> nei = new ArrayList<>();
        boolean[] visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            nei.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            nei.get(e[0]).add(e[1]);
            nei.get(e[1]).add(e[0]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (visit[i] == false) {
                bfs(nei, visit, i);
                res++;
            }
        }
        return res;
    }
    private void bfs(List<List<Integer>> neighbors, boolean[] visit, int i) {
        Queue<Integer> q = new ArrayDeque();
        q.add(i);
        visit[i] = true;

        while (!q.isEmpty()) {
            Integer cur = q.poll();
            for (Integer nei : neighbors.get(cur)) {
                if (visit[nei] == false) {
                    q.add(nei);
                    visit[nei] = true;
                }
            }
        }
    }
}
