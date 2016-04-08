package GoogleOA;

/* Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair
 * of nodes), write a function to check whether these edges make up a valid tree.
 * Example
 * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 * Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case 
 * a valid tree?
 * According to the definition of tree on Wikipedia: Òa tree is an undirected graph in which 
 * any two vertices are connected by exactly one path. In other words, any connected graph 
 * without simple cycles is a tree.Ó
 * Note: you can assume that no duplicate edges will appear in edges. Since all edges are 
 * undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 * */

public class graphValidTree {
	/**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    private static int[] father;
     
    public static boolean validTree(int n, int[][] edges) {
        // Write your code here
        //Union-find
        //Check 2 things: 1. whether there is loop 2. whether the number of connected components is 1
        if (n - 1 != edges.length) {
            return false;
        }
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;    // initially, each node's parent is itself.
        }
        for (int i = 0; i < edges.length; i++) {
            if (find(edges[i][0]) == find(edges[i][1])) {
                return false;
            }
            union(edges[i][0], edges[i][1]);
        }
        return true;
    }
    static int find(int node) {
        if (father[node] == node) {
            return node;
        }
        father[node] = find(father[node]); // find root with path compression
        return father[node];
    }
    static void union(int node1, int node2) {
        father[find(node1)] = find(node2);
    }
    public static void main(String[] args) {
    	int[][] edges1 = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
    	int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
    	int n = 5;
    	System.out.println(graphValidTree.validTree(n, edges1));
    	System.out.println(graphValidTree.validTree(n, edges2));
    	
    }
}
