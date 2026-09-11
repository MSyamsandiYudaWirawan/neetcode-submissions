class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        record Query(int val, int idx) {}
        record Inter(int len, int end) {}
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        Query[] qs = new Query[queries.length];
        for (int i = 0; i < queries.length; i++) {
            qs[i] = new Query(queries[i], i);
        }
        Arrays.sort(qs, (a, b) -> a.val - b.val);

        PriorityQueue<Inter> heap = new PriorityQueue<>((a, b) -> a.len - b.len);
        int i = 0;
        int[] res = new int[queries.length];
        for (Query q : qs) {
            int val = q.val;
            int idx = q.idx;

            while (i < intervals.length && intervals[i][0] <= val) {
                heap.add(new Inter(intervals[i][1] - intervals[i][0] + 1, intervals[i][1]));
                i++;
            }
            while (!heap.isEmpty() && heap.peek().end < val) {
                heap.poll();
            }
            res[idx] = heap.isEmpty() ? -1 : heap.peek().len;
        }
        return res;
    }
}
