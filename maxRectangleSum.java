package GoogleOA;

import java.util.TreeSet;

/* Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the matrix such that 
 * its sum is no larger than k.
 * Example:
 * Given matrix = [
  [1,  0, 1],
  [0, -2, 3]
]                      k = 2
 * The answer is 2. Because the sum of rectangle [[0, 1], [-2, 3]] is 2 and 2 is the max number no larger than 
 * k (k = 2).
 * Note:
 * The rectangle inside the matrix must have an area > 0.
 * What if the number of rows is much larger than the number of columns?
 * */

public class maxRectangleSum {
	//time complexity is O[min(m,n)^2 * max(m,n) * log(max(m,n))], space O(max(m, n))
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int res = Integer.MIN_VALUE;
        //outer loop should use smaller axis, now assume we have more rows than cols, therefore outer loop will base on cols
        for (int left = 0; left < n; left++) {
            int[] sums = new int[m];
            for (int right = left; right < n; right++) {
                for (int i = 0; i < m; i++) {
                    sums[i] += matrix[i][right];
                }
                TreeSet<Integer> set = new TreeSet<Integer>();
                //add 0 to cover the single row case
                set.add(0);
                int curSum = 0;
                for (int sum : sums) {
                    curSum += sum;
                    //we use sum subtraction (curSum - sumPre) to get the subarray with sum <= k, curSum-sumPre<=k
                    //therefore we need to look for the smallest sumPre >= currSum - k
                    Integer num = set.ceiling(curSum - k);
                    if (num != null) {
                        res = Math.max(res, curSum - num);
                        set.add(curSum);
                    }
                }
            }
        }
        return res;
    }
}
