class Solution {
    int[] par;
    int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        par = new int[n];
        rank = new int[n];

        for (int i = 1; i < n; i++) {
            par[i] = i;
            rank[i] = 0;
        }
        int[] res = new int[] {};

        for (int[] e : edges) {
            if (!union(e[0], e[1])) {
                res = e;
            }
        }
        return res;
    }
    private int find(int n) {
        int p = par[n];
        while (p != par[p]) {
            par[p] = par[par[p]];
            p = par[p];
        }
        return p;
    }
    private boolean union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);

        if (p1 == p2) {
            return false;
        }

        if (rank[p1] > rank[p2]) {
            par[p2] = p1;
        } else if (rank[p1] < rank[p2]) {
            par[p1] = p2;
        } else {
            par[p2] = p1;
            rank[p1]++;
        }
        return true;
    }
}
