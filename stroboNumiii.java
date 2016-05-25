package GoogleOA;

/* A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.
 * For example,
 * Given low = "50", high = "100", return 3. Because 69, 88, and 96 are three strobogrammatic numbers.
 * Note: Because the range might be a large number, the low and high numbers are represented as string.
 * */

public class stroboNumiii {
	static char[][] pairs = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    static int count = 0;
    public static int strobogrammaticInRange(String low, String high) {
        for (int len = low.length(); len <= high.length(); len++) {
            dfs(low, high, new char[len], 0, len - 1);
        }
        return count;
    }
    public static void dfs(String low, String high, char[] c, int l, int r) {
        if (l > r) {
            String s = new String(c);
            if ((s.length() == low.length() && s.compareTo(low) < 0) 
             || (s.length() == high.length() && s.compareTo(high) > 0)) {
                return;
            }
            count++;
            return;
        }
        for (char[] p : pairs) {
            c[l] = p[0];
            c[r] = p[1];
            if (c.length != 1 && c[0] == '0') {
                continue;
            }
            if (l < r || ((l == r) && (p[0] == p[1]))) {
                dfs(low, high, c, l + 1, r - 1);
            }
        }
    }
    public static void main(String... args) {
    	String low = "50";
    	String high = "100";
    	System.out.println(stroboNumiii.strobogrammaticInRange(low, high));
    }
}
