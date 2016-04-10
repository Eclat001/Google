package GoogleOA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* Given a collection of intervals, merge all overlapping intervals.
 * For example, Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
 * */

public class mergeInterval {
	public List<Interval> merge(List<Interval> intervals) {
		//Time O(nlogn)
        if (intervals == null || intervals.size() == 0) {
            return intervals;
        }
        List<Interval> res = new ArrayList<Interval>();
        Comparator<Interval> compare = new Comparator<Interval>(){
            //override
            public int compare(Interval a, Interval b) {
                if (a.start == b.start) {
                    return a.end - b.end;
                }
                return a.start - b.start;
            }
        };
        Collections.sort(intervals, compare);
        res.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            if (res.get(res.size() - 1).end < intervals.get(i).start) {
                res.add(intervals.get(i));
            }
            else {
                res.get(res.size() - 1).end = Math.max(res.get(res.size() - 1).end, intervals.get(i).end);
            }
        }
        return res;
    }
}
