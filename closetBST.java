package GoogleOA;

import Structure.TreeNode;

/* Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the 
 * target.
 * Note:
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 * */

public class closetBST {
	public int closestValue(TreeNode root, double target) {
        int closet = root.val;
        double min = Double.MAX_VALUE;
        while (root != null) {
            if (Math.abs(root.val - target) < min) {
                min = Math.abs(root.val - target);
                closet = root.val;
            }
            if (target < root.val) {
                root = root.left;
            }
            else if (target > root.val) {
                root = root.right;
            }
            else {
                return root.val;
            }
        }
        return closet;
    }
}
