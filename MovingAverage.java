package GoogleOA;

import java.util.LinkedList;
import java.util.Queue;

/* Given a stream of integers and a window size, calculate the moving average of all integers in the sliding 
 * window.
 * For example,
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 * */

public class MovingAverage {
	private double preSum = 0.0;
    private int maxSize = 0;
    private Queue<Integer> curWin;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        curWin = new LinkedList<Integer>();
        maxSize = size;
    }
    
    public double next(int val) {
        if (curWin.size() == maxSize) {
            preSum -= curWin.poll();
        }
        preSum += val;
        curWin.offer(val);
        return preSum / curWin.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */