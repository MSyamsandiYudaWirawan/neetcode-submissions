class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord))
            return 0;
        Queue<String> q = new ArrayDeque<>();
        Map<String, List<String>> nei = new HashMap<>();
        int res = 0;
        for (String word : wordList) {
            for (int j = 0; j < word.length(); j++) {
                String pattern = word.substring(0, j) + "*" + word.substring(j + 1);

                if (!nei.containsKey(pattern)) {
                    nei.put(pattern, new ArrayList<>());
                }
                nei.get(pattern).add(word);
            }
        }

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
                    String pattern = node.substring(0, j) + "*" + node.substring(j + 1);
                    if (!nei.containsKey(pattern)) {
                        continue;
                    }
                    for(String neiWord:nei.get(pattern)){
                        if(words.contains(neiWord)){
                            q.add(neiWord);
                            words.remove(neiWord);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
