package GoogleOA;

import java.util.ArrayList;
import java.util.List;

/* Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing 
 * ranges.
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 * */

public class missingRanges {
	public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        int next = lower;   //The next number need to find
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > upper) {
                break;
            }
            if (nums[i] < next) {
                continue;
            }
            if (nums[i] == next) {
                next++;
                continue;
            }
            res.add(getRange(next, nums[i] - 1));
            next = nums[i] + 1;
        }
        if (next <= upper) {    //final check
            res.add(getRange(next, upper));
        }
        return res;
    }
    private static String getRange(int l, int r) {
        return (l == r) ? String.valueOf(l) : String.format("%d->%d", l, r);
    }
    public static void main(String... args) {
    	int[] a = {0, 1, 3, 50, 75};
    	int l = 0;
    	int r = 90;
    	System.out.println(missingRanges.findMissingRanges(a, l, r));
    }
}
