package GoogleOA;

import java.util.Arrays;
import java.util.Comparator;

/* You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can 
 * fit into another if and only if both the width and height of one envelope is greater than the width and 
 * height of the other envelope.
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 * Example: Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes you can Russian doll 
 * is 3 ([2,3] => [5,4] => [6,7]).
 * */

public class russianDoll {
	//Sort the array. Ascend on width and descend on height if width are same. -- [3, 4] cannot contains 
	//[3, 3], so we need to put [3, 4] before [3, 3] when sorting otherwise it will be counted as an increasing
	//number if the order is [3, 3], [3, 4]
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelopes[0].length != 2) {
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                }
                else {
                    return a[0] - b[0];
                }
            }
        });
        //Longest increasing subsequence
        int[] dp = new int[envelopes.length];
        int res = 0;
        for (int i = 0; i < envelopes.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = dp[i] > dp[j] + 1 ? dp[i] : dp[j] + 1;
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
