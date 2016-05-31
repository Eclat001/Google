package GoogleOA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is 
 * then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height 
 * trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root 
 * labels.
 * Format
 * The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of 
 * undirected edges (each edge is a pair of labels). 
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the 
 * same as [1, 0] and thus will not appear together in edges.
 * Example 1:
 * Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]
        0
        |
        1
       / \
      2   3                           return [1]
 * Example 2:
 * Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
     0  1  2
      \ | /
        3
        |
        4
        |
        5                                          return [3, 4]
 * Hint: How many MHTs can a graph have at most?
 * Note:
 * (1) According to the definition of tree on Wikipedia: �a tree is an undirected graph in which any two 
 * vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a 
 * tree.�
 * (2) The height of a rooted tree is the number of edges on the longest downward path between the root and a 
 * leaf.
 * */

public class minimumHeightTree {
	//The time complexity and space complexity are both O(n).
    //Note that for a tree we always have V = n, E = n-1.
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<Integer>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        List<Integer> leaves = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newleaves = new ArrayList<Integer>();
            for (int i : leaves) {
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if (adj.get(j).size() == 1) {
                    newleaves.add(j);
                }
            }
            leaves = newleaves;
        }
        return leaves;
    }
    public static void main(String... args) {
    	int n = 6;
    	int[][] edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
    	System.out.println(minimumHeightTree.findMinHeightTrees(n, edges));
    }
}