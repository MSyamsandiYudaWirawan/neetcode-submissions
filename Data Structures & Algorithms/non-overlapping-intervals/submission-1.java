class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int res = 0;
        int[] inter1 = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] inter2 = intervals[i];

            if (inter1[1] > inter2[0]) {
                res++;
                inter1[1] = Math.min(inter1[1], inter2[1]);
            } else {
                inter1 = inter2;
            }
        }
        return res;
    }
}
