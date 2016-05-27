package GoogleOA;

import java.util.Arrays;

/* Given an array of n integers nums and a target, find the number of index triplets i, j, k with 
 * 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 * For example, given nums = [-2, 0, 1, 3], and target = 2.
 * Return 2. Because there are two triplets which sums are less than 2: [-2, 0, 1] [-2, 0, 3]
 * Follow up: Could you solve it in O(n2) runtime?
 * */

public class threeSumSmaller {
	public static int sumSmaller(int[] nums, int target) {
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] < target) {
                    res += r - l;
                    l++;
                }
                else {
                    r--;
                }
            }
        }
        return res;
    }
	public static void main(String... args) {
		int[] nums= {-2, 0, 1, 3};
		int target = 2;
		System.out.println(threeSumSmaller.sumSmaller(nums, target));
	}
}
