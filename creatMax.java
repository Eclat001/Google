package GoogleOA;

/* Given two arrays of length m and n with digits 0-9 representing two numbers. Create the maximum number of 
 * length k <= m + n from digits of the two. The relative order of the digits from the same array must be 
 * preserved. Return an array of the k digits. You should try to optimize your time and space complexity.
 * Example 1: nums1 = [3, 4, 6, 5] nums2 = [9, 1, 2, 5, 8, 3] k = 5 return [9, 8, 6, 5, 3]
 * Example 2: nums1 = [6, 7] nums2 = [6, 0, 4] k = 5 return [6, 7, 6, 0, 4]
 * Example 3: nums1 = [3, 9] nums2 = [8, 9] k = 3 return [9, 8, 9]
 * */

public class creatMax {
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int fromNums1 = Math.min(nums1.length, k);
        int[] res = new int[k];
        for (int i = Math.max(k - nums2.length, 0); i <= fromNums1; i++) {
            int[] res1 = new int[i];
            int[] res2 = new int[k - i];
            int[] rr = new int[k];
            res1 = candidate(nums1, i);
            res2 = candidate(nums2, k - i);
            int pos1 = 0;
            int pos2 = 0;
            int pos = 0;
            while (res1.length > 0 && res2.length > 0 && pos1 < res1.length && pos2 < res2.length) {
                if (compare(res1, pos1, res2, pos2)) {
                    rr[pos++] = res1[pos1++];
                }
                else {
                    rr[pos++] = res2[pos2++];
                }
            }
            while (pos1 < res1.length) {
                rr[pos++] = res1[pos1++];
            }
            while (pos2 < res2.length) {
                rr[pos++] = res2[pos2++];
            }
            if (compare(rr, 0, res, 0)) {
                res = rr;
            }
        }
        return res;
    }
    public int[] candidate(int[] nums, int k) {
        int[] res = new int[k];
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            while (len > 0 && len + nums.length - i > k && res[len - 1] < nums[i]) {
                len--;
            }
            if (len < k) {
                res[len++] = nums[i];
            }
        }
        return res;
    }
    public boolean compare(int[] nums1, int pos1, int[] nums2, int pos2) {
        for (; pos1 < nums1.length && pos2 < nums2.length; pos1++, pos2++) {
            if (nums1[pos1] > nums2[pos2]) {
                return true;
            }
            if (nums1[pos1] < nums2[pos2]) {
                return false;
            }
        }
        return pos1 != nums1.length;
    }
}
