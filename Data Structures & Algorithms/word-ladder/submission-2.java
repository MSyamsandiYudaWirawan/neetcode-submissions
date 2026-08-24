class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) return 0;
        Queue<String> q = new ArrayDeque<>();
        int res = 0;

        q.add(beginWord);
        words.remove(beginWord);

        while (!q.isEmpty()) {
            res++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String node = q.poll();

                if (node.equals(endWord)) {
                    return res;
                }

                for (int j = 0; j < node.length(); j++) {
                    char[] arr = node.toCharArray();

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == node.charAt(j)) {
                            continue;
                        }
                        arr[j] = c;
                        String nei = new String(arr);
                        if (words.contains(nei)) {
                            q.add(nei);
                            words.remove(nei);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
