package GoogleOA;

/* Given an Android 3x3 key lock screen and two integers m and n, where 1 ² m ² n ² 9, count the total number 
 * of unlock patterns of the Android lock screen, which consist of minimum of m keys and maximum n keys.
 * Rules for a valid pattern:
 * Each pattern must connect at least m keys and at most n keys.
 * All the keys must be distinct.
 * If the line connecting two consecutive keys in the pattern passes through any other keys, the other keys 
 * must have previously selected in the pattern. No jumps through non selected key is allowed.
 * The order of keys used matters.
 * Explanation:
| 1 | 2 | 3 |
| 4 | 5 | 6 |
| 7 | 8 | 9 |
 * Invalid move: 4 - 1 - 3 - 6 
 * Line 1 - 3 passes through key 2 which had not been selected in the pattern.
 * Invalid move: 4 - 1 - 9 - 2
 * Line 1 - 9 passes through key 5 which had not been selected in the pattern.
 * Valid move: 2 - 4 - 1 - 3 - 6
 * Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern
 * Valid move: 6 - 5 - 4 - 1 - 9 - 2
 * Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.
 * Example: Given m = 1, n = 1, return 9.
 * */

public class androidUnlockPattern {
	//The optimization idea is that 1,3,7,9 are symmetric, 2,4,6,8 are also symmetric. Hence we only calculate one among each group and multiply by 4.
    public static int numberOfPatterns(int m, int n) {
        int[][] jump = new int[10][10];
        jump[1][3] = jump[3][1] = 2;
        jump[1][7] = jump[7][1] = 4;
        jump[3][9] = jump[9][3] = 6;
        jump[7][9] = jump[9][7] = 8;
        jump[1][9] = jump[9][1] = jump[3][7] = jump[7][3] = jump[2][8] = jump[8][2] = jump[4][6] = jump[6][4] = 5;
        boolean[] vis = new boolean[10];
        int res = 0;
        for (int i = m; i <= n; i++) {
            res += DFS(vis, jump, 1, i - 1) * 4;    //1, 3, 7, 9 are symmetric
            res += DFS(vis, jump, 2, i - 1) * 4;    //2, 4, 6, 8 are symmetric
            res += DFS(vis, jump, 5, i - 1);
        }
        return res;
    }
    public static int DFS(boolean[] vis, int[][] jump, int cur, int remain) {
        if (remain < 0) {
            return 0;
        }
        if (remain == 0) {
            return 1;
        }
        vis[cur] = true;
        int res = 0;
        for (int i = 1; i <= 9; i++) {
            //If vis[i] is not visited and (two numbers are adjacent or jump number is already visited)
            if (!vis[i] && (jump[i][cur] == 0 || vis[jump[i][cur]])) {
                res += DFS(vis, jump, i, remain - 1);
            }
        }
        vis[cur] = false;    //backtracking
        return res;
    }
    public static void main(String... args) {
    	int m = 6;
    	int n = 6;
    	System.out.println(androidUnlockPattern.numberOfPatterns(m, n));
    }
}
