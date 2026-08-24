class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        // Build pattern map: "*it" -> [hit, hot...]
        Map<String, List<String>> map = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                map.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        Queue<String> qb = new ArrayDeque<>();
        Queue<String> qe = new ArrayDeque<>();
        Map<String, Integer> distBegin = new HashMap<>();
        Map<String, Integer> distEnd = new HashMap<>();

        qb.add(beginWord);
        qe.add(endWord);
        distBegin.put(beginWord, 1); // count words, not edges
        distEnd.put(endWord, 1);

        while (!qb.isEmpty() && !qe.isEmpty()) {
            // Always expand the smaller frontier first
            if (qb.size() <= qe.size()) {
                int res = expand(qb, distBegin, distEnd, map);
                if (res != -1) return res;
            } else {
                int res = expand(qe, distEnd, distBegin, map);
                if (res != -1) return res;
            }
        }

        return 0;
    }

    private int expand(Queue<String> queue, Map<String, Integer> dist,
                       Map<String, Integer> otherDist, Map<String, List<String>> map) {
        String word = queue.poll();
        int d = dist.get(word);

        for (int i = 0; i < word.length(); i++) {
            String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
            if (!map.containsKey(pattern)) continue;

            for (String next : map.get(pattern)) {
                if (dist.containsKey(next)) continue; // already visited by this side

                if (otherDist.containsKey(next)) {
                    // Found meeting point. 
                    // d = distance of 'word' from this side
                    // otherDist.get(next) = distance of 'next' from other side
                    // Total words = d + otherDist.get(next)
                    return d + otherDist.get(next);
                }

                dist.put(next, d + 1);
                queue.add(next);
            }
        }
        return -1;
    }
}