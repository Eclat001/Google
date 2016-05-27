package GoogleOA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation 
 * which turns the water at position (row, col) into a land. Given a list of positions to operate, count the 
 * number of islands after each addLand operation. An island is surrounded by water and is formed by 
 * connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all 
 * surrounded by water.
 * Example: Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
 * Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).
0 0 0
0 0 0
0 0 0
Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.
1 0 0
0 0 0   Number of islands = 1
0 0 0
Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.
1 1 0
0 0 0   Number of islands = 1
0 0 0
Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.
1 1 0
0 0 1   Number of islands = 2
0 0 0
Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.
1 1 0
0 0 1   Number of islands = 3
0 1 0
 * We return the result as an array: [1, 1, 2, 3]
 * Challenge: Can you do it in time complexity O(k log mn), where k is the length of the positions?
 * */

public class islandNumberii {
	static int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public static List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<Integer>();
        if (m <= 0 || n <= 0) {
            return res;
        }
        int count = 0;
        int[] roots = new int[m * n];    //one island = one tree
        Arrays.fill(roots, -1);
        for (int[] p : positions) {
            int root = p[0] * n + p[1];    //assume new point is isolated island
            roots[root] = root;    //add new island
            count++;
            for (int[] dir : dirs) {
                int x = p[0] + dir[0];
                int y = p[1] + dir[1];
                int nei = x * n + y;
                if (x < 0 || x >= m || y < 0 || y >= n || roots[nei] == -1) {
                    continue;
                }
                int rootNei = findIsland(roots, nei);
                if (root != rootNei) {    // if neighbor is in another island
                    roots[root] = rootNei;    // union two islands 
                    root = rootNei;    // current tree root = joined tree root
                    count--;               
                }
            }
            res.add(count);
        }
        return res;
    }
    public static int findIsland(int[] roots, int id) {
        while (id != roots[id]) {
            id = roots[id];
        }
        return id;
    }
    public static void main(String... args) {
    	int m = 3; 
    	int n = 3;
    	int[][] pos = {{0,0}, {0,1}, {1,2}, {2,1}};
    	System.out.println(islandNumberii.numIslands2(m, n, pos));
    }
}
