package GoogleOA;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

/* Median is the middle value in an ordered integer list. If the size of the list is even, 
 * there is no middle value. So the median is the mean of the two middle value.
 * Examples:    [2,3,4] , the median is 3        [2,3], the median is (2 + 3) / 2 = 2.5
 * Design a data structure that supports the following two operations:
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 * For example:
 * add(1)
 * add(2)
 * findMedian() -> 1.5
 * add(3) 
 * findMedian() -> 2
 * */

//two heaps (or priority queues):
//Max-heap small has the smaller half of the numbers.
//Min-heap large has the larger half of the numbers.
//This direct access to the one or two middle values (they're the tops of the heaps), 
//so getting the median takes O(1) time. And adding a number takes O(log n) time.

class medianFromDataStream {
PriorityQueue<Integer> small = new PriorityQueue<Integer>();
@SuppressWarnings("unchecked")
PriorityQueue<Integer> large = new PriorityQueue<Integer>((Collection<? extends Integer>) Collections.reverseOrder());
// Adds a number into the data structure.
public void addNum(int num) {
  large.add(num);
  small.add(large.poll());
  if (large.size() < small.size()) {
      large.add(small.poll());
  }
}

// Returns the median of current data stream
public double findMedian() {
  return large.size() > small.size() ? large.peek() : (large.peek() / 2.0 + small.peek() / 2.0);
}
};

//Your MedianFinder object will be instantiated and called as such:
//MedianFinder mf = new MedianFinder();
//mf.addNum(1);
//mf.findMedian();