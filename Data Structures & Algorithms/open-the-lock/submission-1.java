class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(List.of(deadends));
        Set<String> visited = new HashSet<>();

        if (dead.contains("0000")) {
            return -1;
        }
        if (target.equals("0000")) {
            return 0;
        }

        Set<String> front = new HashSet<>();
        Set<String> back = new HashSet<>();

        front.add("0000");
        back.add(target);
        visited.add("0000");
        visited.add(target);

        int moves = 0;

        while (!front.isEmpty() && !back.isEmpty()) {
            if (front.size() > back.size()) {
                Set<String> temp = new HashSet<>();
                temp = front;
                front = back;
                back = temp;
            }
            moves++;
            Set<String> nextFront = new HashSet<>();

            for (String cur : front) {
                for (String nei : getNeighbor(cur)) {
                    if (back.contains(nei)) {
                        return moves;
                    }
                    if (dead.contains(nei) || visited.contains(nei)) {
                        continue;
                    }
                    visited.add(nei);
                    nextFront.add(nei);
                }
            }
            front = nextFront;
        }
        return -1;
    }

    private List<String> getNeighbor(String state) {
        List<String> res = new ArrayList<>();

        char[] chars = state.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char ori = chars[i];

            chars[i] = (char) ((ori - '0' + 1) % 10 + '0');
            res.add(new String(chars));

            chars[i] = (char) ((ori - '0' + 9) % 10 + '0');
            res.add(new String(chars));

            chars[i] = ori;
        }
        return res;
    }
}