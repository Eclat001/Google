package GoogleOA;

import java.util.Stack;

/* Implement a basic calculator to evaluate a simple expression string. The expression string
 * may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative 
 * integers and empty spaces . You may assume that the given expression is always valid.
 * Some examples:
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 * Note: Do not use the eval built-in library function.
 * */

public class basicCal {
	//Time O(n) Space O(n)
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack stack = new Stack();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                int num = 0;
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                push(stack, num);
                i--;
            }
            else if (c == '(' || c == '+' || c == '-') {
                stack.push(c);
            }
            else if (c == ')') {
                Integer num = (Integer)stack.pop();
                stack.pop();
                push(stack, num);
            }
            i++;
        }
        return (Integer)stack.pop();
    }
    private void push(Stack stack, int num) {
        if (stack.isEmpty()) {
            stack.push(num);
        }
        else {
            Character op = (Character)stack.peek();
            if (op == '(') {
                stack.push(num);
            }
            else {
                op = (Character)stack.pop();
                Integer left = (Integer)stack.pop();
                if (op == '+') {
                    stack.push(left + num);
                }
                else {
                    stack.push(left - num);
                }
            }
        }
    }
}
