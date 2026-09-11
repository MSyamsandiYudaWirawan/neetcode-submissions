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
        record Event(int time, int delta){}

        List<Event> events  = new ArrayList<>();

        for(Interval it:intervals){
            events.add(new Event(it.start,1));
            events.add(new Event(it.end,-1));
        }
        // compare time first if same compare delta(release first);
        events.sort((a,b) -> a.time == b.time ? a.delta - b.delta : a.time - b.time);

        int onGoing = 0;
        int maxRoom = 0;
        
        for(Event e:events){
            onGoing += e.delta;
            maxRoom = Math.max(maxRoom,onGoing);
        }
        return maxRoom;

    }
}
