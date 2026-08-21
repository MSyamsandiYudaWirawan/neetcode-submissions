class Solution {
    private int[] par;
    private int[] rank;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        initialize(n);
        Map<String, Integer> map = new HashMap<>();

        // build union
        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);

                if (map.containsKey(email)) {
                    union(i, map.get(email));
                } else {
                    map.put(email, i);
                }
            }
        }

        Map<Integer, List<String>> emailGroup = new HashMap<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String email = entry.getKey();
            int idx = entry.getValue();
            int leader = find(idx);
            emailGroup.putIfAbsent(leader, new ArrayList<>());
            emailGroup.get(leader).add(email);
        }
        // Build result
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : emailGroup.entrySet()) {
            int accId = entry.getKey();
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            List<String> merged = new ArrayList<>();
            merged.add(accounts.get(accId).get(0)); // Add account name
            merged.addAll(emails);
            res.add(merged);
        }
        return res;
    }
    private void initialize(int n) {
        par = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            par[i] = i;
            rank[i] = 0;
        }
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