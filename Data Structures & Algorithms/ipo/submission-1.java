class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        record Data(int p, int c) {}
        List<Data> datas = new ArrayList<>();

        for (int i = 0; i < capital.length; i++) {
            datas.add(new Data(profits[i], capital[i]));
        }
        // 1. Sort by CAPITAL ascending (cheapest first)
        datas.sort((a, b) -> a.c - b.c);

        // 2. Single Max-Heap for profits of affordable projects
        PriorityQueue<Integer> maxProfitPQ = new PriorityQueue<>((a, b) -> b - a);

        int res = w;
        int idx = 0; // Pointer that only moves forward

        while (k > 0) {
            // Slide pointer forward to unlock all newly affordable projects
            while (idx < datas.size() && res >= datas.get(idx).c) {
                maxProfitPQ.offer(datas.get(idx).p);
                idx++;
            }

            // Nothing affordable in the pool
            if (maxProfitPQ.isEmpty()) {
                break;
            }

            // Pick the best profit from everything unlocked so far
            res += maxProfitPQ.poll();
            k--;
        }

        return res;
    }
}