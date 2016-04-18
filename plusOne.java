package GoogleOA;

import java.util.Arrays;

/* Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 * */

public class plusOne {
	//Time O(n)，n is the length of the array;
    //Space, generally O(1), but if all digits are 9, the worst case is O(n), a new array to return result
    public static int[] PlusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
            if (carry == 0) {
                return digits;
            }
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
    public static void main(String[] args) {
    	int[] n1 = {};
    	int[] n2 = {0};
    	int[] n3 = {1, 3, 2};
    	int[] n4 = {9, 9, 9, 9};
    	System.out.println(Arrays.toString(n3));
    	System.out.println(Arrays.toString(plusOne.PlusOne(n1)));
    	System.out.println(Arrays.toString(plusOne.PlusOne(n2)));
    	System.out.println(Arrays.toString(plusOne.PlusOne(n3)));
    	System.out.println(Arrays.toString(plusOne.PlusOne(n4)));
    }
}
