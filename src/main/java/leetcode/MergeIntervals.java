package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by amit.bhengra on 09/09/18.
 *
 *
 * https://leetcode.com/problems/merge-intervals/description/
 */
public class MergeIntervals {

    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() <= 1)
            return intervals;

        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval o1,Interval o2){
                return Integer.compare(o1.start,o2.start);
            }
        });
        List<Interval> mergedIntervals = new ArrayList<>();
        int i = 1;
        Interval prevInterval = intervals.get(0);
        for(;i<intervals.size();i++){
            Interval currInterval = intervals.get(i);
            boolean overlap = ifOverlap(prevInterval,currInterval);
            if(overlap){
                Interval newInterval = merge(prevInterval,currInterval);
                prevInterval = newInterval;
                if(i+1==intervals.size())
                    mergedIntervals.add(newInterval);
            }else{
                mergedIntervals.add(prevInterval);
                if(i+1==intervals.size())
                    mergedIntervals.add(currInterval);
                prevInterval = currInterval;
            }
        }
        return mergedIntervals;
    }

    public boolean ifOverlap(Interval prevInterval, Interval currInterval){
        if(currInterval.start >= prevInterval.start && currInterval.start <= prevInterval.end)
            return true;
        return false;
    }

    public Interval merge(Interval prevInterval, Interval currInterval){
        Interval newInterval = new Interval();
        int end = prevInterval.end > currInterval.end ? prevInterval.end : currInterval.end;
        newInterval.start = prevInterval.start;
        newInterval.end = end;
        return newInterval;
    }
}
