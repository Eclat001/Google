package GoogleOA;

/* According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton 
 * devised by the British mathematician John Horton Conway in 1970." Given a board with m by n cells, each cell 
 * has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical,
 * diagonal) using the following four rules (taken from the above Wikipedia article):
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state.
 * Follow up: 
 * Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update so
 * me cells first and then use their updated values to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the board is infinite, which would 
 * cause problems when the active area encroaches the border of the array. How would you address these problems?
 * */

public class gameOfLife {
	public static void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int[] di = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dj = {-1, 0, 1, -1, 1, -1, 0, 1};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int neig = 0;
                for (int k = 0; k < 8; k++) {
                    int x = i + di[k];
                    int y = j + dj[k];
                    neig += neighors(board, x, y);
                }
                if (board[i][j] + neig == 3 || neig == 3) {
                    board[i][j] |= 2;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] >>= 1;
            }
        }
        return;
    }
    public static int neighors(int[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return 0;
        }
        return board[x][y] & 1;
    }
    public static void main(String... args) {
    	int[][] m = {{1, 0, 1}, {1, 1, 0}, {0, 0, 0}, {0, 1, 0}};
    	for (int i = 0; i < m.length; i++) {
    		for (int j = 0; j < m[0].length; j++) {
    			System.out.print(m[i][j]);
    		}
    		System.out.print('\n');
    	}   	
    	gameOfLife(m);
    	for (int i = 0; i < m.length; i++) {
    		for (int j = 0; j < m[0].length; j++) {
    			System.out.print(m[i][j]);
    		}
    		System.out.print('\n');
    	} 
    }
}
