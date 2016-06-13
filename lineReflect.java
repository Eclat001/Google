package GoogleOA;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given set of 
 * points.
 * Example 1: Given points = [[1,1],[-1,1]], return true.
 * Example 2: Given points = [[1,1],[-1,-1]], return false.
 * Follow up: Could you do better than O(n2)?
 * Hint: 
 * Find the smallest and largest x-value for all points.
 * If there is a line then it should be at y = (minX + maxX) / 2.
 * For each point, make sure that it has a reflected point in the opposite side.
 * */

public class lineReflect {
	public boolean isReflected(int[][] points) {
        if (points == null) {
            return false;
        }
        Set<Integer> pointSet = new HashSet<Integer>();
        int minx = Integer.MAX_VALUE;
        int maxx = Integer.MIN_VALUE;
        for (int[] point : points) {
            minx = Math.min(minx, point[0]);
            maxx = Math.max(maxx, point[0]);
            pointSet.add(Arrays.hashCode(point));
        }
        for (int[] point : points) {
            if (!pointSet.contains(Arrays.hashCode(new int[]{maxx - point[0] + minx, point[1]}))) {
                return false;
            }
        }
        return true;
    }
}
