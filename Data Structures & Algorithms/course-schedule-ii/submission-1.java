class Solution {
    Map<Integer, Set<Integer>> preMap = new HashMap<>();
    Map<Integer, Set<Integer>> nexMap = new HashMap<>();
    Set<Integer> taken = new LinkedHashSet<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new LinkedHashSet<>());
            nexMap.put(i, new LinkedHashSet<>());
        }
        for (int[] pre : prerequisites) {
            preMap.get(pre[0]).add(pre[1]);
            nexMap.get(pre[1]).add(pre[0]);
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (preMap.get(i).isEmpty()) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            Integer cur = q.poll();
            if (taken.contains(cur)) {
                continue;
            }
            taken.add(cur);
            for (Integer nex : nexMap.get(cur)) {
                preMap.get(nex).remove(cur);
                if (preMap.get(nex).isEmpty()) {
                    q.add(nex);
                }
            }
        }
        if (taken.size() != numCourses) {
            return new int[]{};
        }

        int[] res = new int[taken.size()];
        int i = 0;
        for (Integer course : taken) {
            res[i] = course;
            i++;
        }
        return res;
    }
}
