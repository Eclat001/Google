package GoogleOA;

/* Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and 
 * return the shortest palindrome you can find by performing this transformation.
 * For example:
 * Given "aacecaaa", return "aaacecaaa".
 * Given "abcd", return "dcbabcd"
 * */

public class shortPalin {
	public static String shortestPalindrome(String s) {
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {    //找到后缀不能够回文匹配的第一个的位置
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
        }
        if (j == s.length()) {    //本身是回文
            return s;
        }
        String suffix = s.substring(j);    //后缀不能够匹配的字符串
        String prefix = new StringBuilder(suffix).reverse().toString();    //前面补充prefix让他和suffix回文匹配
        String mid = shortestPalindrome(s.substring(0, j));    //递归调用找[0,j]要最少可以补充多少个字符让他回文
        String res = prefix + mid + suffix;
        return res;
    }
	public static void main(String... args) {
		String s1 = "abcd";
		System.out.println(shortPalin.shortestPalindrome(s1));
		String s2 = "aacedcaaa";
		System.out.println(shortPalin.shortestPalindrome(s2));
	}

}
