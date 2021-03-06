package GoogleOA;

import java.util.ArrayList;
import java.util.List;

/* Given a set of non-overlapping intervals, insert a new interval into the intervals (merge
 *  if necessary). 
 *  You may assume that the intervals were initially sorted according to their start times.
 *  Example 1:
 *  Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 *  Example 2:
 *  Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 *  This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * */

public class insertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || newInterval == null) {
            return intervals;
        }
        List<Interval> res = new ArrayList<Interval>();
        int position = 0;
        for (Interval i : intervals) {
            if (newInterval.end < i.start) {
                res.add(i);
            }
            else if (newInterval.start > i.end) {
                res.add(i);
                position++;
            }
            else {
                newInterval.start = Math.min(newInterval.start, i.start);
                newInterval.end = Math.max(newInterval.end, i.end);
            }
        }
        res.add(position, newInterval);
        return res;
    }
}
