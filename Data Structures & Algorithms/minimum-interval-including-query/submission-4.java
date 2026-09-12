class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        record Inter(int len, int right) {}
        record Query(int idx, int val) {}

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<Query> qs = new ArrayList<>();
        PriorityQueue<Inter> pq = new PriorityQueue<>((a, b) -> a.len - b.len);

        for (int i = 0; i < queries.length; i++) {
            qs.add(new Query(i, queries[i]));
        }
        qs.sort((a, b) -> a.val - b.val);

        int i = 0;
        int[] res = new int[queries.length];

        for (Query q : qs) {

            while (i < intervals.length && intervals[i][0] <= q.val) {
                pq.add(new Inter(intervals[i][1] - intervals[i][0] + 1, intervals[i][1]));
                i++;
            }
            while (!pq.isEmpty() && pq.peek().right < q.val) {
                pq.poll();
            }
            res[q.idx] = !pq.isEmpty() ? pq.peek().len : -1;
        }
        return res;
    }
}
