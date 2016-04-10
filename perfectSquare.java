package GoogleOA;

/* Given a positive integer n, find the least number of perfect square numbers (for example, 
 * 1, 4, 9, 16, ...) which sum to n. For example, given n = 12, return 3 because 
 * 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 * */

public class perfectSquare {
	public static int numSquares(int n) {
        //Time O(n*sqrt(n)) Space O(n)
        int[] res = new int[n + 1];
        for (int i = 1; i * i <= n; i++) {
            res[i * i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; i + j * j <= n; j++) {
                if (res[i + j * j] == 0 || res[i + j * j] > res[i] + 1) {
                    res[i + j * j] = res[i] + 1;
                }
            }
        }
        return res[n];
    }
	/* 数论（Number Theory）时间复杂度：O(sqrt n)
	 * 四平方和定理(Lagrange's Four-Square Theorem)：所有自然数至多只要用四个数的平方和就可以表示
	 * */
	public static void main(String[] args) {
		int n1 = 12;
		int n2 = 13; 
		int n3 = 63;
		System.out.println(perfectSquare.numSquares(n1));
		System.out.println(perfectSquare.numSquares(n2));
		System.out.println(perfectSquare.numSquares(n3));
	}
}
