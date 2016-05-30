package GoogleOA;

import java.util.HashMap;
import java.util.Map;

/* Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear 
 * once and only once. You must make sure your result is the smallest in lexicographical order among all 
 * possible results.
 * Example:
 * Given "bcabc"  Return "abc"
 * Given "cbacdcbc"  Return "acdb"
 * */

public class removeDupChar {
	public static String removeDuplicateLetters(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        Map<Character, Integer> last = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            last.put(s.charAt(i), i);
        }
        char[] res = new char[last.size()];
        int start = 0;
        int end = findMinLastPos(last);
        for (int i = 0; i < res.length; i++) {
            char minChar = 'z' + 1;
            for (int k = start; k <= end; k++) {
                if (last.containsKey(s.charAt(k)) && s.charAt(k) < minChar) {
                    minChar = s.charAt(k);
                    start = k + 1;
                }
            }
            res[i] = minChar;
            if (i == res.length - 1) {
                break;
            }
            last.remove(minChar);
            if (s.charAt(end) == minChar) {
                end = findMinLastPos(last);
            }
        }
        return new String(res);
    }
    public static int findMinLastPos(Map<Character, Integer> map) {
        if (map == null || map.size() == 0) {
            return -1;
        }
        int minLast = Integer.MAX_VALUE;
        for (int lastPos : map.values()) {
            minLast = Math.min(minLast, lastPos);
        }
        return minLast;
    }
    public static void main(String... args) {
    	String s1 = "bcab";
    	String s2 = "cbacdcbc";
    	System.out.println(removeDupChar.removeDuplicateLetters(s1));
    	System.out.println(removeDupChar.removeDuplicateLetters(s2));
    }
}
