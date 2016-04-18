package GoogleOA;

/* Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has
 * the following properties:
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * For example, Consider the following matrix:
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * Given target = 20, return false.
 * */

public class search2DMatrix {
	//search from left-bottome, similiar as BST, if extend left and bottome boundary, return false   
    //Time O(m + n)
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        if (col == 0) {
            return false;
        }
        int i = row - 1;
        int j = 0;
        while (i >= 0 && j < col) {
            if (target == matrix[i][j]) {
                return true;
            }
            else if (target > matrix[i][j]) {
                j++;
            }
            else {
                i--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
    	int[][] m = {{1,   4,  7, 11, 15},
    	             {2,   5,  8, 12, 19},
    	             {3,   6,  9, 16, 22},
    	             {10, 13, 14, 17, 24},
    	             {18, 21, 23, 26, 30}};
    	int n1 = 5;
    	int n2 = 20;
    	System.out.println(search2DMatrix.searchMatrix(m, n1));
    	System.out.println(search2DMatrix.searchMatrix(m, n2));
    }
}
