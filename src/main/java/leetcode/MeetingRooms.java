package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by amit.bhengra on 11/09/18.
 *
 * https://leetcode.com/problems/meeting-rooms/description/
 *
 */
public class MeetingRooms {

    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null || intervals.length <=1)
            return true;
        Arrays.sort(intervals,new Comparator<Interval>(){
            public int compare(Interval o1, Interval o2){
                return Integer.compare(o1.start,o2.start);
            }
        });
        int i = 0;
        while(i < intervals.length - 1){
            if(intervals[i].end > intervals[i+1].start)
                return false;
            i++;
        }
        return true;
    }
}
