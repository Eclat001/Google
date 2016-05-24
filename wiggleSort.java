package GoogleOA;

/* Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * Notice: Please complete the problem in-place.
 * Example: Given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
 * */

public class wiggleSort {
	/**
     * @param nums a list of integer
     * @return void
     */
    public static void wiggleSort(int[] nums) {
        // Write your code here
        //greedy
        if (nums == null || nums.length < 2) {
            return;
        }
        for (int i = 1; i < nums.length; i++) {
            if ((i % 2 == 0 && (nums[i] > nums[i - 1])) || (i % 2 == 1 && (nums[i] < nums[i - 1]))) {
                int temp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
            }
        }
        return;
    }
    public static void main(String... args) {
    	int[] nums = {3, 5, 2, 1, 6, 4};
    	wiggleSort.wiggleSort(nums);
    	for (int i = 0; i < nums.length; i++) {
    		System.out.print(nums[i]);
    	}
    }
}
