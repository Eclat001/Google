package GoogleOA;

/* Given an integer, write a function to determine if it is a power of two.
 * 
 * Given an integer, write a function to determine if it is a power of three.
 * Follow up: Could you do it without using any loop / recursion?
 * 
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * Example: Given num = 16, return true. Given num = 5, return false.
 * Follow up: Could you solve it without loops/recursion?
 * */

public class power {
	public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
	
	public static boolean isPowerOfThree(int n) {
        int maxPow3 = (int)Math.pow(3, (int)(Math.log(Integer.MAX_VALUE) / Math.log(3)));
        return n > 0 && maxPow3 % n == 0;
    }
	
	public static boolean isPowerOfFour(int num) {
        //F = 0x55555555 = 01010101010101010101010101010101
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
    }
	
	public static void main(String... args) {
		int n1 = 1;
		int n2 = 2;
		System.out.println(power.isPowerOfTwo(n1));
		System.out.println(power.isPowerOfThree(n1));
		System.out.println(power.isPowerOfFour(n1));
		System.out.println(power.isPowerOfTwo(n2));
		System.out.println(power.isPowerOfThree(n2));
		System.out.println(power.isPowerOfFour(n2));
	}
}
