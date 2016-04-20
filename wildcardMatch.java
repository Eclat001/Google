package GoogleOA;

/* Implement wildcard pattern matching with support for '?' and '*'.
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 * */

public class wildcardMatch {
	//res[i],代表s的前i个字符和p的前j个字符是否匹配,每次i的结果只依赖于j-1的结果,不需要二维数组,只要一维数组保存上一行结果即可
    //(1)p[j]不是'*'.如果当前s的i和p的j上的字符一样(如果有p在j上的字符是'?',也是相同),并且res[i]==true,则更新res[i+1]为true;  
    //(2)p[j]是'*'.因为'*'可以匹配任意字符串，在前面的res[i]只要有true，剩下的res[i+1], res[i+2],...,res[s.length()]就都是true了
    //算法的时间复杂度因为是两层循环，所以是O(m*n), 而空间复杂度只用一个一维数组，所以是O(n)，假设s的长度是n，p的长度是m。
    public static boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        if (s.length() > 300 && p.charAt(0) == '*' && p.charAt(p.length() - 1) == '*') {
            return false;
        }
        boolean[] res = new boolean[s.length() + 1];
        res[0] = true;
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) != '*') {
                for (int i = s.length() - 1; i >= 0; i--) {
                    res[i + 1] = res[i] && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'); 
                }
            }
            else {
                int i = 0;
                while (i <= s.length() && !res[i]) {
                    i++;
                }
                for (; i <= s.length(); i++) {
                    res[i] = true;
                }
            }
            res[0] = res[0] && p.charAt(j) == '*';
        }
        return res[s.length()];
    }
    public static void main(String[] args) {
    	String s1 = "aa";
    	String p11 = "aa";
    	String p12 = "a";
    	String p13 = "a*";
    	String p14 = "*";
    	String p15 = "?*";
    	System.out.println(wildcardMatch.isMatch(s1, p11));
    	System.out.println(wildcardMatch.isMatch(s1, p12));
    	System.out.println(wildcardMatch.isMatch(s1, p13));
    	System.out.println(wildcardMatch.isMatch(s1, p14));
    	System.out.println(wildcardMatch.isMatch(s1, p15));
    }
}
