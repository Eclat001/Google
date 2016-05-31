package GoogleOA;

import java.util.LinkedList;
import java.util.Queue;

/* You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. 
 * You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
 * Each 0 marks an empty land which you can pass by freely.
 * Each 1 marks a building which you cannot pass through.
 * Each 2 marks an obstacle which you cannot pass through.
 * For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):
1 - 0 - 2 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
 * The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. 
 * So return 7.
 * Note: There will be at least one building. If it is not possible to build such house according to the above 
 * rules, return -1.
 * */

public class shortDistanceBuilding {
	public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        final int[] shift = new int[] {0, 1, 0, -1, 0};
        int m = grid.length;
        int n = grid[0].length;
        int[][] distance = new int[m][n];
        int[][] reach = new int[m][n];
        int building = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    building++;
                    Queue<int[]> queue = new LinkedList<int[]>();
                    queue.offer(new int[] {i, j});
                    boolean[][] visited = new boolean[m][n];
                    int level = 1;
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int q = 0; q < size; q++) {
                            int[] cur = queue.poll();
                            for (int k = 0; k < 4; k++) {
                                int row = cur[0] + shift[k];
                                int col = cur[1] + shift[k + 1];
                                if (row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 0 && !visited[row][col]) {
                                    //The shortest distance from [row][col] to thic building is 'level'
                                    distance[row][col] += level;
                                    reach[row][col]++;
                                    visited[row][col] = true;
                                    queue.offer(new int[] {row, col});
                                }
                            }
                        }
                        level++;
                    }
                }
            }
        }
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && reach[i][j] == building) {
                    shortest = Math.min(shortest, distance[i][j]);
                }
            }
        }
        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }
}
