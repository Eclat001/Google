package GoogleOA;

/* Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array 
 * nums. You are asked to burst all the balloons. If the you burst balloon i you will get 
 * nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, 
 * the left and right then becomes adjacent.
 * Find the maximum coins you can collect by bursting the balloons wisely.
 * Note: 
 * (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * (2) 0 ² n ² 500, 0 ² nums[i] ² 100
 * Example:
 * Given [3, 1, 5, 8]   Return 167
    nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
   coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 * */

public class burstBallons {
	//For the first we have nums[i-1]*nums[i]*nums[i+1], for the last we have nums[-1]*nums[i]*nums[n]
    //dp[l][r] = max(dp[l][r], nums[l] * nums[m] * nums[r] + dp[l][m] + dp[m][r])
    //Time O(n^3)
    public static int maxCoins(int[] nums) {
        int[] num = new int[nums.length + 2];
        int n = 1;
        for (int i : nums) {
            if (i > 0) {
                num[n++] = i;
            }
        }
        num[0] = num[n++] = 1;
        int[][] dp = new int[n][n];
        for (int i = 2; i < n; i++) {
            for (int l = 0; l < n - i; l++) {
                int r = l + i;
                for (int m = l + 1; m < r; m++) {
                    dp[l][r] = Math.max(dp[l][r], num[l] * num[m] * num[r] + dp[l][m] + dp[m][r]);
                }
            }
        }
        return dp[0][n - 1];
    }
    public static void main(String... args) {
    	int[] nums = {3, 1, 5, 8};
    	System.out.println(burstBallons.maxCoins(nums));
    }
}
