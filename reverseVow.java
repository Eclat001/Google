package GoogleOA;

/* Write a function that takes a string as input and reverse only the vowels of a string.
 * Example 1: Given s = "hello", return "holle".
 * Example 2: Given s = "leetcode", return "leotcede".
 * */

public class reverseVow {
	public String reverseVowels(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        String vowels = "aeiouAEIOU";
        int l = 0;
        int r = s.length() - 1;
        char[] c = s.toCharArray();
        while (l < r) {
            while (l < r && vowels.indexOf(c[l]) == -1) {
                l++;
            }
            while (l < r && vowels.indexOf(c[r]) == -1) {
                r--;
            }
            char temp = c[l];
            c[l++] = c[r];
            c[r--] = temp;
        }
        return new String(c);
    }
}
