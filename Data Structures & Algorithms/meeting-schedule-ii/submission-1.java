/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int res = 0;
        int n = intervals.size();
        record Pair(int time, int val) {}
        List<Pair> list= new ArrayList<>(n);

        for(Interval i:intervals){
            list.add(new Pair(i.start,1));
            list.add(new Pair(i.end,-1));
        }

        Collections.sort(list, (a, b) -> a.time != b.time ? Integer.compare(a.time, b.time) : Integer.compare(a.val, b.val));

        int count = 0;

        for(Pair p:list){
            count += p.val;
            res = Math.max(res,count);
        }
        return res;
    }
}
