class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));

        if (dead.contains("0000")) {
            return -1;
        }
        if (target.equals("0000")) {
            return 0;
        }
        Queue<String> queue = new ArrayDeque();
        Set<String> visited = new HashSet<>();

        queue.add("0000");
        visited.add("0000");

        int moves = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            moves++;

            for (int i = 0; i < levelSize; i++) {
                String state = queue.poll();

                for(String nei:getNeighbor(state)){
                    if(dead.contains(nei) || visited.contains(nei)){
                        continue;
                    }
                    if(nei.equals(target)){
                        return moves;
                    }

                    visited.add(nei);
                    queue.add(nei);
                }
            }
        }
        return -1;
    }

    private List<String> getNeighbor(String state) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = state.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char original = chars[i];

            chars[i] = (char) ((original - '0' + 1) % 10 + '0');
            neighbors.add(new String(chars));
            
            // Turn wheel down (-1)
            chars[i] = (char) ((original - '0' + 9) % 10 + '0'); 
            neighbors.add(new String(chars));

            chars[i] = original;
        }
        return neighbors;
    }
}