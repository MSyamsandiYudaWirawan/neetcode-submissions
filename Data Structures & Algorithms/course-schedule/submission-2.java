class Solution {
    Map<Integer, Set<Integer>> preMap = new HashMap<>();
    Map<Integer, Set<Integer>> nexMap = new HashMap<>();
    Set<Integer> taken = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Initialize all courses
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new HashSet<>());
            nexMap.put(i, new HashSet<>());
        }

        // Map each course to its prerequisites and its dependent courses
        for (int[] pre : prerequisites) {
            preMap.get(pre[0]).add(pre[1]);
            nexMap.get(pre[1]).add(pre[0]);
        }

        Queue<Integer> q = new ArrayDeque<>();

        // Start with courses that have no prerequisites
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

            // Mark the current course as completed
            taken.add(cur);

            // The current course is now completed, so
            // remove it from the prerequisites of dependent courses
            for (Integer nex : nexMap.get(cur)) {
                preMap.get(nex).remove(cur);

                // If all prerequisites are completed, the course is ready
                if (preMap.get(nex).isEmpty()) {
                    q.add(nex);
                }
            }
        }

        // If we completed every course, there is no cycle
        return taken.size() == numCourses;
    }
}