package GoogleOA;

import java.util.ArrayList;
import java.util.List;

/* Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary 
 * operators (not unary) +, -, or * between the digits so they evaluate to the target value.
 * Examples: 
 * "123", 6 -> ["1+2+3", "1*2*3"] 
 * "232", 8 -> ["2*3+2", "2+3*2"]
 * "105", 5 -> ["1*0+5","10-5"]
 * "00", 0 -> ["0+0", "0-0", "0*0"]
 * "3456237490", 9191 -> []
 * */

public class expressionAddOp {
	public static List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();
        if (num == null || num.length() == 0) {
            return res;
        }
        binaryOp(num, target, res, "", 0, 0, 0);
        return res;
    }
    private static void binaryOp(String num, int target, List<String> res, String path, int pos, int sum, int pre) {
        if (pos == num.length()) {
            if (sum == target) {
                res.add(path);
                return;
            }
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') {
                break;
            }
            long curLong = Long.valueOf(num.substring(pos, i + 1));
            if (curLong > Integer.MAX_VALUE || -curLong < Integer.MIN_VALUE) {
                break;
            }
            int cur = (int)(curLong);
            if (pos == 0) {
                binaryOp(num, target, res, path + cur, i + 1, cur, cur);
            }
            else {
                binaryOp(num, target, res, path + "+" + cur, i + 1, sum + cur, cur);
                binaryOp(num, target, res, path + "-" + cur, i + 1, sum - cur, -cur);
                binaryOp(num, target, res, path + "*" + cur, i + 1, sum - pre + pre * cur, pre * cur);
            }
        }
    }
    public static void main(String... args) {
    	String s1 = "123";
    	int n1 = 6;
    	System.out.println(expressionAddOp.addOperators(s1, n1));
    	String s2 = "105";
    	int n2 = 5;
    	System.out.println(expressionAddOp.addOperators(s2, n2));
    	String s3 = "00";
    	int n3 = 0;
    	System.out.println(expressionAddOp.addOperators(s3, n3));
    }
}
