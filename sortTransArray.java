package GoogleOA;

/* Given a sorted array of integers nums and integer values a, b and c. Apply a function of the form 
 * f(x) = ax2 + bx + c to each element x in the array. The returned array must be in sorted order.
 * Expected time complexity: O(n)
 * Example:
 * nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5, Result: [3, 9, 15, 33]
 * nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5, Result: [-23, -5, 1, 7]
 * */

public class sortTransArray {
	//ax2+bx+c = a(x + b/2a)2 + c - b2/4a.The derivative is f'(x) = 2ax+b, which gets 0 at x=-b/2a
    //1.a>0, two ends in original array are bigger than center. 2.a<0, center is bigger than two ends.
    public static int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] res = new int[n];
        int i = 0, j = n - 1;
        int index = a >= 0 ? n - 1 : 0;
        while (i <= j) {
            if (a >= 0) {
                res[index--] = quad(nums[i], a, b, c) >= quad(nums[j], a, b, c) ? quad(nums[i++], a, b, c) : quad(nums[j--], a, b, c);
            }
            else {
                res[index++] = quad(nums[i], a, b, c) >= quad(nums[j], a, b, c) ? quad(nums[j--], a, b, c) : quad(nums[i++], a, b, c);
            }
        }
        return res;
    }
    private static int quad(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
    public static void main(String... args) {
    	int[] nums1 = {2, 3, 4, 5};
    	int a1 = 1, b1 = 2, c1 = 1;
    	int[] ans = sortTransArray.sortTransformedArray(nums1, a1, b1, c1);
    	for (int i = 0; i < ans.length; i++) {
    		System.out.println(ans[i]);
    	}
    }
}
