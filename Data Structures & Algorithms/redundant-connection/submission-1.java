class Solution {
    Map<Integer, Integer> par = new HashMap<>();
    Map<Integer, Integer> rank = new HashMap<>();

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        for (int i = 0; i < n; i++) {
            par.put(i, i);
            rank.put(i, 1);
        }

        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) {
                return new int[] {edge[0], edge[1]};
            }
        }
        return new int[] {};
    }
    private int find(int n) {
        int p = par.get(n);
        while (p != par.get(p)) {
            par.put(p, par.get(par.get(p)));
            p = par.get(p);
        }
        return p;
    }
    private boolean union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);

        if (p1 == p2) {
            return false;
        }
        if (rank.get(p1) > rank.get(p2)) {
            // merge p2 to root p1
            par.put(p2, p1);
            // update rank p1 = p1 + p2
            rank.put(p1, rank.get(p1) + rank.get(p2));
        } else {
            // same operation jsut reverse
            par.put(p1, p2);
            rank.put(p2, rank.get(p1) + rank.get(p2));
        }
        return true;
    }
}
