package GoogleOA;

import java.util.ArrayList;
import java.util.List;

/* A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed 
 * from a distance. Now suppose you are given the locations and height of all the buildings as shown on a 
 * cityscape photo, write a program to output the skyline formed by these buildings collectively.
 * The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and 
 * Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. 
 * It is guaranteed that 0 ² Li, Ri ² INT_MAX, 0 < Hi ² INT_MAX, and Ri - Li > 0. You may assume all buildings are
 * perfect rectangles grounded on an absolutely flat surface at height 0.
 * For instance, the dimensions of all buildings are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], 
 * [19 24 8] ]. The output is a list of "key points" in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that 
 * uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last 
 * key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always
 * has zero height. Also, the ground in between any two adjacent buildings should be considered part of the 
 * skyline contour.
 * For instance, the skyline should be represented as:[[2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0]].
 * Notes:
 * The number of buildings in any input list is guaranteed to be in the range [0, 10000].
 * The input list is already sorted in ascending order by the left x position Li.
 * The output list must be sorted by the x position.
 * There must be no consecutive horizontal lines of equal height in the output skyline. For instance, 
 * [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged 
 * into one in the final output as such: [...[2 3], [4 5], [12 7], ...]
 * */

public class skyline {
	public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<int[]>();
        if (buildings == null || buildings.length == 0) {
            return res;
        }
        res = divide(buildings, 0, buildings.length - 1);
        for (int i = 0; i < res.size(); i++) {
            if (i > 0 && res.get(i - 1)[1] == res.get(i)[1]) {
                res.remove(i);
                i--;
            }
        }
        return res;
    }
    public List<int[]> divide(int[][] buildings, int l, int r) {         //recursively divide
        if (l == r) {
            List<int[]> res = new ArrayList<int[]>();
            res.add(new int[] {buildings[l][0], buildings[l][2]});
            res.add(new int[] {buildings[l][1], 0});
            return res;
        }
        int m = (l + r) / 2;
        List<int[]> list1 = divide(buildings, l, m);
        List<int[]> list2 = divide(buildings, m + 1, r);
        List<int[]> res = merge(list1, list2);
        return res;
    }
    public List<int[]> merge(List<int[]> l1, List<int[]> l2) {
        List<int[]> res = new ArrayList<int[]>();
        int i = 0, j = 0, h1 = 0, h2 = 0;
        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i)[0] < l2.get(j)[0]) {
                h1 = l1.get(i)[1];
                res.add(new int[] {l1.get(i)[0], Math.max(h1, h2)});
                i++;
            }
            else if (l1.get(i)[0] > l2.get(j)[0]) {
                h2 = l2.get(j)[1];
                res.add(new int[] {l2.get(j)[0], Math.max(h1, h2)});
                j++;
            }
            else {
                h1 = l1.get(i)[1];
                h2 = l2.get(j)[1];
                res.add(new int[] {l1.get(i)[0], Math.max(h1, h2)});
                i++;
                j++;
            }
        }
        while (i < l1.size()) {
            res.add(new int[] {l1.get(i)[0], l1.get(i)[1]});
            i++;
        }
        while (j < l2.size()) {
            res.add(new int[] {l2.get(j)[0], l2.get(j)[1]});
            j++;
        }
        return res;
    }
}
