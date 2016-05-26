package GoogleOA;

import Structure.TreeNode;

/* Given a binary tree, find the length of the longest consecutive sequence path.
 * The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-
 * child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
 * For example,
   1
    \
     3
    / \
   2   4
        \
         5                 Longest consecutive sequence path is 3-4-5, so return 3.
   2
    \
     3
    / 
   2    
  / 
 1                         Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 * */

public class BTLongestConse {
	public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(dfs(root.left, 1, root.val), dfs(root.right, 1, root.val));
    }
    public int dfs(TreeNode node, int count, int val) {
        if (node == null) {
            return count;
        }
        count = (node.val - val == 1) ? count + 1 : 1;
        int left = dfs(node.left, count, node.val);
        int right = dfs(node.right, count, node.val);
        return Math.max(count, Math.max(left, right));
    }
}
