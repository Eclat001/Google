package GoogleOA;

import java.util.HashMap;
import java.util.Map;

/* Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
 * For example, Given s = “eceba”, T is "ece" which its length is 3.
 * */

public class substringTwoDistinctChar {
	public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int l = 0;
        int r = 0;
        int max = 0;
        while (r < s.length()) {
            if (map.size() <= 2) {
                char c = s.charAt(r);
                map.put(c, r);
                r++;
            }
            if (map.size() > 2) {
                int leftMost = s.length();
                for (int i : map.values()) {
                    leftMost = Math.min(i, leftMost);
                }
                char c = s.charAt(leftMost);
                map.remove(c);
                l = leftMost + 1;
            }
            max = Math.max(max, r - l);
        }
        return max;
    }
	public static void main(String... args) {
		String s = "eceba";
		System.out.println(substringTwoDistinctChar.lengthOfLongestSubstringTwoDistinct(s));
	}
}
