package GoogleOA;

import java.util.Stack;

/* Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine 
 * if the input string is valid. The brackets must close in the correct order, "()" and 
 * "()[]{}" are all valid but "(]" and "([)]" are not.
 * */

public class validParentheses {
	//Time O(n) SpaceO(n)
    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            else {
                if (!stack.isEmpty() && isValid(stack.peek(), c)) {
                    stack.pop();
                }
                else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    private static boolean isValid(char a, char b) {
        if ((a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}')) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
    	String s1 = "([)]";
    	String s2 = "()[]{}";
    	String s3 = "";
    	System.out.println(validParentheses.isValid(s1));
    	System.out.println(validParentheses.isValid(s2));
    	System.out.println(validParentheses.isValid(s3));
    }
}
