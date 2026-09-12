class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] inter1 = res.get(res.size() - 1);
            int[] inter2 = intervals[i];

            if(inter1[1] >= inter2[0]){
                
                inter1[1] = Math.max(inter1[1],inter2[1]);
            }else{
                res.add(inter2);
            }
        }
        return res.toArray(new int[res.size()-1][]);
    }
}
