package GoogleOA;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import Structure.NestedInteger;

/* Given a nested list of integers, implement an iterator to flatten it.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * Example 1: Given the list [[1,1],2,[1,1]], By calling next repeatedly until hasNext returns false, the order
 * of elements returned by next should be: [1,1,2,1,1].
 * Example 2: Given the list [1,[4,[6]]], By calling next repeatedly until hasNext returns false, the order of 
 * elements returned by next should be: [1,4,6].
 * */

public class NestedIterator implements Iterator<Integer> {
	Stack<NestedInteger> stack = new Stack<NestedInteger>();

    public NestedIterator(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger cur = stack.peek();
            if (cur.isInteger()) {
                return true;
            }
            stack.pop();
            for (int i = cur.getList().size() - 1; i >= 0; i--) {
                stack.push(cur.getList().get(i));
            }
        }
        return false;
    }

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
