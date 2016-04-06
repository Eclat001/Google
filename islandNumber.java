package GoogleOA;

/* Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally 
 * or vertically. You may assume all four edges of the grid are all surrounded by water.
 * Example 1:
 * 11110
 * 11010
 * 11000
 * 00000            Answer: 1
 * Example 2:
 * 11000
 * 11000
 * 00100
 * 00011            Answer: 3
 * */

public class islandNumber {
	//find land, then expand until water, mark all the lands visited.
    //Time O(mn) Space O(logmn)
    private static int m;
	private static int n;
    public static int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }
        m = grid.length;
        if (m == 0) {
            return 0;
        }
        n = grid[0].length;
        if (n == 0) {
            return 0;
        }
        int rst = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != '1') {
                    continue;
                }
                else {
                    rst++;
                    help(grid, i, j);
                }
            }
        }
        return rst;
    }
    private static void help(char[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = '2';
            help(grid, i - 1, j);
            help(grid, i + 1, j);
            help(grid, i, j - 1);
            help(grid, i, j + 1);
        }
        return;
    }
    public static void main(String[] args) {
    	char[][] matrix = {{'1', '1', '1', '0', '0'},
    	                   {'1', '1', '0', '0', '0'},
    	                   {'0', '0', '1', '0', '0'},
    	                   {'0', '0', '0', '1', '1'}};
    	System.out.println(islandNumber.numIslands(matrix));
    }
}
