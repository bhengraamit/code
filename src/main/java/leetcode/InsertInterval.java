package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amit.bhengra on 17/09/18.
 *
 * https://leetcode.com/problems/insert-interval/description/
 */
public class InsertInterval {

    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> retInterval = new ArrayList<>();
        if(intervals == null || intervals.size()==0){
            retInterval.add(newInterval);
            return retInterval;
        }
        if(retInterval == null)
            return intervals;

        String type = null;
        for(int i=0; i<intervals.size(); i++){

            type = checkIntervalType(intervals.get(i), newInterval);
            if(type.equals("after")){
                retInterval.add(intervals.get(i));
                continue;
            }
            if(type.equals("before")){
                retInterval.add(newInterval);
                retInterval.add(intervals.get(i));
                newInterval = null;
                continue;
            }
            if(type.equals("overlap")){
                newInterval = merge(intervals.get(i),newInterval);
            }

        }

        if(type.equals("overlap") || type.equals("after")){
            if(newInterval!=null)
                retInterval.add(newInterval);
        }
        // if(type.equals("before"))
        //    retInterval.add(intervals.get(intervals.size()-1));

        return retInterval;

    }

    public String checkIntervalType(Interval interval1, Interval interval2){
        if(interval2 == null)
            return "after";


        if(interval2.end < interval1.start)
            return "before";

        else if(interval2.start > interval1.end)
            return "after";

        return "overlap";
    }

    public Interval merge(Interval interval1, Interval interval2){
        Interval newInterval = new Interval();
        int start = interval1.start < interval2.start ? interval1.start : interval2.start;
        int end = interval1.end < interval2.end ? interval2.end : interval1.end;
        newInterval.start = start;
        newInterval.end = end;
        return newInterval;
    }
}
