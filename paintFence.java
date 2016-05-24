package GoogleOA;

/* There is a fence with n posts, each post can be painted with one of the k colors. You have to paint all the 
 * posts such that no more than two adjacent fence posts have the same color.
 * Return the total number of ways you can paint the fence.
 * Notice: n and k are non-negative integers.
 * Example
Given n=3, k=2 return 6
      post 1,   post 2, post 3
way1    0         0       1 
way2    0         1       0
way3    0         1       1
way4    1         0       0
way5    1         0       1
way6    1         1       0
 * */

public class paintFence {
	/**
     * @param n non-negative integer, n posts
     * @param k non-negative integer, k colors
     * @return an integer, the total number of ways
     */
	//Time O(n) Space O(1)
    public static int numWays(int n, int k) {
        // Write your code here
        //第三根柱子要么根第一个柱子不是一个颜色，要么跟第二根柱子不是一个颜色。
        //如果不是同一个颜色，计算可能性的时候就要去掉之前的颜色，也就是k-1种可能性。
        //假设dp[1]是第一根柱子及之前涂色的可能性数量，dp[2]是第二根柱子及之前涂色的可能性数量，则dp[3]=(k-1)*dp[1] + (k-1)*dp[2]。
       //base: 第一根涂色的方式有k中，第二根涂色的方式则是k*k，因为第二根柱子可以和第一根一样。
       if (n == 0) {
           return 0;
       }
       else if (n == 1) {
           return k;
       }
       else if (n == 2) {
           return k * k;
       }
       int[] dp = {k, k * k, 0};
       for (int i = 2; i < n; i++) {
           dp[2] = (k - 1) * dp[0] + (k - 1) * dp[1];
           dp[0] = dp[1];
           dp[1] = dp[2];
       }
       return dp[2];
    }
    public static void main(String... args) {
    	int n = 3;
    	int k = 2;
    	System.out.println(paintFence.numWays(n, k));
    }
}
