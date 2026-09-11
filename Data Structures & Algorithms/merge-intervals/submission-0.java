class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            // get last from res;
            int[] it1 = res.get(res.size() - 1);
            int[] it2 = intervals[i];

            if (it1[1] >= it2[0]) {
                it1[1] = Math.max(it1[1], it2[1]);
            }else{
                res.add(it2);
            }
        }
        return res.toArray(new int [res.size()][]);
    }
}
