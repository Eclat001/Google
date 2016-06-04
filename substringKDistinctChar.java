package GoogleOA;

import java.util.HashMap;
import java.util.Map;

/* Given a string, find the length of the longest substring T that contains at most k distinct characters.
 * For example, Given s = “eceba” and k = 2, T is "ece" which its length is 3.
 * */

public class substringKDistinctChar {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int l = 0, r = 0, max = 0;
        while (r < s.length()) {
            if (map.size() <= k) {
                char c = s.charAt(r);
                map.put(c, r);
                r++;
            }
            if (map.size() > k) {
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
}
