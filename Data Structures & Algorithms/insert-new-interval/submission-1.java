class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int i=0;

        List<int[]> res = new ArrayList<>();
        //check if new AFTER intervals
        while(i<n && intervals[i][1] < newInterval[0]){
            res.add(intervals[i]);
            i++;
        } 
        //check if new INSIDE intervals
        while(i<n && intervals[i][0] <= newInterval[1]){
            //expand the new
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            // check other interval with new expanded
            i++;
        }
        res.add(newInterval);

        // handle the rest
        while(i<n){
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[res.size()][]);
    }
}
