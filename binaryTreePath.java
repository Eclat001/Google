package GoogleOA;

import java.util.ArrayList;
import java.util.List;

import Structure.TreeNode;

/* Given a binary tree, return all root-to-leaf paths. For example, given the following 
 * binary tree:       1
                    /   \
                   2     3
                    \
                     5                 All root-to-leaf paths are: ["1->2->5", "1->3"]
 * */

public class binaryTreePath {
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> rst = new ArrayList<String>();
        if (root == null) {
            return rst;
        }
        List<TreeNode> path = new ArrayList<TreeNode>();
        Paths(root, path, rst);
        return rst;
    }
    public void Paths(TreeNode node, List<TreeNode> path, List<String> rst) {
        path.add(node);
        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                sb.append(path.get(i).val).append("->");
            }
            rst.add(sb.substring(0, sb.length() - 2));
            return;
        }
        if (node.left != null) {
            Paths(node.left, path, rst);
            path.remove(path.size() - 1);
        }
        if (node.right != null) {
            Paths(node.right, path, rst);
            path.remove(path.size() - 1);
        }
    }
}
