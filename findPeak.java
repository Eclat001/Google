package GoogleOA;

/* A peak element is an element that is greater than its neighbors. Given an input array 
 * where num[i] ­ num[i+1], find a peak element and return its index. The array may contain 
 * multiple peaks, in that case return the index to any one of the peaks is fine. You may 
 * imagine that num[-1] = num[n] = -°. For example, in array [1, 2, 3, 1], 3 is a peak 
 * element and your function should return the index number 2.
 * Note: Your solution should be in logarithmic complexity.
 * */

public class findPeak {
	public static int findPeakElement(int[] nums) {
        //Time O(logn) Space O(logn)
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        return peak(nums, 0, nums.length - 1);
    }
    public static int peak(int[] nums, int l, int r) {
        int m = l + (r - l) / 2;
        if ((m == 0 || nums[m - 1] < nums[m]) && (m == nums.length - 1 || nums[m] > nums[m + 1])) {
            return m;
        }
        else if (m > 0 && nums[m - 1] > nums[m]) {
            return peak(nums, l, m - 1);
        }
        else {
            return peak(nums, m + 1, r);
        }
    }
    public static void main(String[] args) {
    	int nums[] = {1, 2, 3, 1};
    	System.out.println(findPeak.findPeakElement(nums));
    }
}
