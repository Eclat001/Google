package GoogleOA;

import java.util.Arrays;
import java.util.List;

/* You are given an integer array nums and you have to return a new counts array. The counts array has the 
 * property where counts[i] is the number of smaller elements to the right of nums[i].
 * Example: Given nums = [5, 2, 6, 1]
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 * Return the array [2, 1, 1, 0].
 * */

public class countSmallNum {
	//worst case O(n^2) : n, n-1,..., 1
	static class Node {
        Node left, right;
        int val, count, dup = 1;
        public Node(int v, int c) {
            val = v;
            count = c;
        }
    }
    public static List<Integer> countSmaller(int[] nums) {
        Integer[] res = new Integer[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(nums[i], root, res, i, 0);
        }
        return Arrays.asList(res);
    }
    private static Node insert(int num, Node node, Integer[] res, int i, int preCount) {
        if (node == null) {
            node = new Node(num, 0);
            res[i] = preCount;
        }
        else if (node.val == num) {
            node.dup++;
            res[i] = preCount + node.count;
        }
        else if (node.val > num) {
            node.count++;
            node.left = insert(num, node.left, res, i, preCount);
        }
        else {
            node.right = insert(num, node.right, res, i, preCount + node.dup + node.count);
        }
        return node;
    }
    public static void main(String... args) {
    	int[] n1 = {3, 2, 2, 6, 1};
    	System.out.println(countSmallNum.countSmaller(n1));
    }
}
