class Solution {
    Map<Integer, List<Integer>> neiMap = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    private record Pair(int cur, int par) {}
    public boolean validTree(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            neiMap.put(i, new ArrayList<>());
        }
        for (int[] nei : edges) {
            neiMap.get(nei[0]).add(nei[1]);
            neiMap.get(nei[1]).add(nei[0]);
        }
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0, -1));
        visited.add(0);

        while (!q.isEmpty()) {
            Pair p = q.poll();
            for (Integer nei : neiMap.get(p.cur)) {
                // check if it already visited and not the cur parent
                if(nei == p.par){
                    continue;
                }
                if(visited.contains(nei)){
                    return false;
                }
                visited.add(nei);
                //parent neighbore is cur it self
                q.add(new Pair(nei,p.cur));
            }
        }
        return visited.size() == n;
    }
}
