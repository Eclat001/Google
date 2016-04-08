package GoogleOA;

import java.util.ArrayList;
import java.util.List;

/* Given n pairs of parentheses, write a function to generate all combinations of well-formed 
 * parentheses. For example, given n = 3, a solution set is: 
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * */

public class generateParentheses {
	public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n <= 0) {
            return res;
        }
        help(res, "", n, n);
        return res;
    }
    private static void help(List<String> res, String s, int l, int r) {
        if (l > r || l < 0 || r < 0) {
            return;
        }
        if (l == 0 && r == 0) {
            res.add(s);
            return;
        }
        //传进去的是一个"item+"(""的String，在java中生成一个新的String，然后传入到下一               层函数，这里并没有改变item，所以不需要remove~ 如果是改变item，然后传进去，那                                  么出来的时候就需要把最后一个括号去掉哈~ 一般来说还是还原现场更好，因为那样一                                     直是在一个变量上操作，空间上效率高很多
        help(res, s + "(", l - 1, r);
        help(res, s + ")", l , r - 1);
    }
    public static void main(String[] args) {
    	int n1 = 1;
    	int n2 = 2;
    	int n3 = 3;
    	System.out.println(generateParentheses.generateParenthesis(n1));
    	System.out.println(generateParentheses.generateParenthesis(n2));
    	System.out.println(generateParentheses.generateParenthesis(n3));
    }
}
