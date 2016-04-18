package GoogleOA;

import java.util.Stack;

import Structure.TreeNode;

/* Given a binary search tree, write a function kthSmallest to find the kth smallest element
 * in it.
 * Note: 
 * You may assume k is always valid, 1 ² k ² BST's total elements.
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth
 * smallest frequently? How would you optimize the kthSmallest routine?
 * Hint:
 * Try to utilize the property of a BST.
 * What if you could modify the BST node's structure?
 * The optimal runtime complexity is O(height of BST).
 * */

//If we can change the BST node structure, We can add a new Integer to mark the number of 
//element in the left sub-tree.
//when the node is not null:
//if k == node.leftNum + 1, return node
//if k > node.leftNum + 1, make k -= node.leftNum + 1, and then node = node.right
//otherwise, node = node.left

public class kthSmallInBST {
	public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (stack.peek().left != null) {
            stack.push(stack.peek().left);
        }
        while (k > 0) {
            TreeNode node = stack.pop();
            k--;
            if (k == 0) {
                return node.val;
            }
            if (node.right != null) {
                stack.push(node.right);
                while (stack.peek().left != null) {
                    stack.push(stack.peek().left);
                }
            }
        }
        return -1;
    }
}
