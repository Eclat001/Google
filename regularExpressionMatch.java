package GoogleOA;

/* Implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 * */

public class regularExpressionMatch {
	//1.p[j+1]不是'*',如果当前s的i和p的j上的字符一样(如果有p在j上的字符是'.',也是相同),且res[i][j]==true,则res[i+1][j+1]为true
    //2.p[j+1]是'*',但是p[j]!='.'.那么只要以下条件有一个满足即可对res[i+1][j+1]赋值为true： 
        //1)res[i+1][j]为真（'*'只取前面字符一次）; 
        //2)res[i+1][j-1]为真（'*'前面字符一次都不取，也就是忽略这两个字符）; 
        //3)res[i][j+1] && s[i]==s[i-1] && s[i-1]==p[j-1](这种情况是相当于i从0到s.length()扫过来，如果p[j+1]对应的字符是‘*’那就意味着接下来的串就可以依次匹配下来，如果下面的字符一直重复，并且就是‘*’前面的那个字符）
    //3.p[j+1]是'*'且p[j]=='.'。因为".*"可以匹配任意字符串，所以在前面的res[i+1][j-1]或者res[i+1][j]中只要有i+1是true，那么剩下的res[i+1][j+1],res[i+2][j+1],...,res[s.length()][j+1]就都是true了。 
     
     //动态规划的时间复杂度是O(n^2),空间复杂度也是O(n^2)
    public static boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }
        if (p.length() == 0) {
            return false;
        }
        boolean[][] res = new boolean[s.length() + 1][p.length() + 1];
        res[0][0] = true;
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) == '*') {
                if (j == 0) {
                    continue;
                }
                if (j > 0 && res[0][j - 1]) {
                    res[0][j + 1] = true;
                }
                if (p.charAt(j - 1) != '.') {
                    for (int i = 0; i < s.length(); i++) {
                        if (res[i + 1][j] || (j > 0 && res[i + 1][j - 1]) || (i > 0 && j > 0 && res[i][j + 1] && s.charAt(i - 1) == s.charAt(i) && s.charAt(i - 1) == p.charAt(j - 1))) {
                            res[i + 1][j + 1] = true;
                        }
                    }
                }
                else {
                    int i = 0;
                    while (j > 0 && i < s.length() && !res[i + 1][j] && !res[i + 1][j - 1]) {
                        i++;
                    }
                    for (; i < s.length(); i++) {
                        res[i + 1][j + 1] = true;
                    }
                }
            }
            else {
                for (int i = 0; i < s.length(); i++) {
                    if ((s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') && res[i][j]) {
                        res[i + 1][j + 1] = true;
                    }
                }
            }
        }
        return res[s.length()][p.length()];
    }
    public static void main(String[] args) {
    	String s1 = "aa";
    	String p11 = "a";
    	String p12 = "*";
    	String p13 = ".";
    	String p14 = ".*";
    	String p15 = "a*";
    	System.out.println(regularExpressionMatch.isMatch(s1, p11));
    	System.out.println(regularExpressionMatch.isMatch(s1, p12));
    	System.out.println(regularExpressionMatch.isMatch(s1, p13));
    	System.out.println(regularExpressionMatch.isMatch(s1, p14));
    	System.out.println(regularExpressionMatch.isMatch(s1, p15));
    }
}
