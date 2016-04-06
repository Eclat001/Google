package GoogleOA;

import java.util.Stack;

/* Design a stack that supports push, pop, top, and retrieving the minimum element in 
 * constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */

public class minStack {
	//use one more stack to keep the coming smaller input.
	//return 0 when the suppose-return does not exsit.
	//Time O(n) Space O(n)
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minstack = new Stack<Integer>();
    
    public void push(int x) {
        stack.push(x);
        if (minstack.isEmpty() || minstack.peek() >= x) {
            minstack.push(x);
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        int val = stack.pop();
        if (!minstack.isEmpty() && minstack.peek() == val) {
            minstack.pop();
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            return 0;
        }
        else {
            return stack.peek();
        }
    }

    public int getMin() {
        if (!minstack.isEmpty()) {
            return minstack.peek();
        }
        else {
            return 0;
        }
    }
}
