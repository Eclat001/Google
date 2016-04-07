package GoogleOA;

/* There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the 
 * median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * */

public class findMedian {
	//Extend the problem to be kth smallest number of two sorted array. In this case, k = (m + n) / 2
    //eliminate k/2 elements everytime
    //Time O(logk), Space O(k) -- recursive stack
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 1) {
            return help(nums1, 0, nums2, 0, len / 2 + 1);
        }
        else {
            return (help(nums1, 0, nums2, 0, len / 2) + help(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
        }
    }
    private static int help(int[] nums1, int l1, int[] nums2, int l2, int k) {
        if (l1 >= nums1.length) {
            return nums2[l2 + k - 1];
        }
        if (l2 >= nums2.length) {
            return nums1[l1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[l1], nums2[l2]);
        }
        int key1 = l1 + k / 2 - 1 < nums1.length ? nums1[l1 + k / 2 - 1] : Integer.MAX_VALUE;
        int key2 = l2 + k / 2 - 1 < nums2.length ? nums2[l2 + k / 2 - 1] : Integer.MAX_VALUE;
        if (key1 < key2) {
            return help(nums1, l1 + k / 2, nums2, l2, k - k / 2);
        }
        else {
            return help(nums1, l1, nums2, l2 + k / 2, k - k / 2);
        }
    }
    public static void main(String[] args) {
    	int[] a = {1, 3, 4, 6, 10};
    	int[] b = {5, 6, 8, 9, 24, 35, 56};
    	System.out.print(findMedian.findMedianSortedArrays(a, b));
    }
}
