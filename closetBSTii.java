package GoogleOA;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import Structure.TreeNode;

/* Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the 
 * target.
 * Note:
 * Given target value is a floating point.
 * You may assume k is always valid, that is: k ² total nodes.
 * You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 * Follow up: 
 * Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
 * Hint:
 * Consider implement these two helper functions:
 *     getPredecessor(N), which returns the next smaller node to N.
 *     getSuccessor(N), which returns the next larger node to N.
 * Try to assume that each node has a parent pointer, it makes the problem much easier.
 * Without parent pointer we need to keep track of the path from the root to the current node using a stack.
 * You would need two stacks to track the path in finding predecessor and successor node separately.
 * */

public class closetBSTii {
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new LinkedList<Integer>();
        Stack<TreeNode> suc = new Stack<TreeNode>();
        Stack<TreeNode> pre = new Stack<TreeNode>();
        initialize(root, target, suc, true);
        initialize(root, target, pre, false);
        //if there is a treenode val equals to target, pop it once first to avoid add it to list twice
        if (!suc.isEmpty() && !pre.isEmpty() && suc.peek().val == pre.peek().val) {
            getPredecessor(pre);
        }
        while (k-- > 0) {
            if (suc.isEmpty()) {
                res.add(getPredecessor(pre));
            }
            else if (pre.isEmpty()) {
                res.add(getSuccessor(suc));
            }
            else {
                double pre_diff = Math.abs(pre.peek().val - target);
                double suc_diff = Math.abs(suc.peek().val - target);
                if (pre_diff < suc_diff) {
                    res.add(getPredecessor(pre));
                }
                else {
                    res.add(getSuccessor(suc));
                }
            }
        }
        return res;
    }
    private void initialize(TreeNode root, double target, Stack<TreeNode> stack, boolean isSuccessor) {    //log(n)
        while (root != null) {
            if (root.val == target) {
                stack.add(root);
                break;
            }
            else if (root.val > target) {
                if (isSuccessor) {
                    stack.push(root);
                }
                    root = root.left;
            }
            else {
                if (!isSuccessor) {
                    stack.push(root);
                }
                root = root.right;
            }
        }
    }
    private int getPredecessor(Stack<TreeNode> stack) {
        TreeNode node = stack.pop();
        int res = node.val;
        node = node.left;
        while (node != null) {
            stack.push(node);
            node = node.right;
        }
        return res;
    }
    private int getSuccessor(Stack<TreeNode> stack) {
        TreeNode node = stack.pop();
        int res = node.val;
        node = node.right;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        return res;
    }
}
