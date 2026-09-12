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
        record Inter(int time, int val) {}

        List<Inter> list = new ArrayList<>();
        for (Interval it : intervals) {
            list.add(new Inter(it.start, 1));
            list.add(new Inter(it.end, -1));
        }
        // sort time asc if same then val asc (release room first)
        list.sort((a,b) -> a.time == b.time ? a.val - b.val : a.time - b.time);

        int res = 0;
        int room = 0;

        for (Inter it : list) {
            room += it.val;
            res = Math.max(res, room);
        }
        return res;
    }
}
