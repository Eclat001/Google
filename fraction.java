package GoogleOA;

import java.util.HashMap;

/* Given two integers representing the numerator and denominator of a fraction, return the 
 * fraction in string format. If the fractional part is repeating, enclose the repeating part
 * in parentheses.
 * For example,
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 * Hint:
 * 1. No scary math, just apply elementary math knowledge. Still remember how to perform a long 
 * division?
 * 2. Try a long division on 4/9, the repeating part is obvious. Now try 4/333. Do you see a 
 * pattern?
 * 3. Be wary of edge cases! List out as many test cases as you can think of and test your 
 * code thoroughly.
 * */

public class fraction {
	//The time complexity is generally O(denominator), but should be much smaller in fact. The fraction 1 / n may have a loop sequence of at most n - 1 in length, but usually far shorter. Space complexity is the same scale.
    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        if (denominator == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) {
            sb.append("-");
        } 
        //change to long first, then abs; otherwise would overflow
        long num = numerator, den = denominator;
        num = Math.abs(num);
        den = Math.abs(den); //change both to positive, in case overflow, turn int to long
        
        long res = num / den;             //integer part
        sb.append(res);
        
        long rem = num % den;
        if (rem == 0) {
            return sb.toString();
        }
        
        sb.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        while (rem != 0) {
            if (map.containsKey(rem)) {
                sb.insert(map.get(rem), "(");
                sb.append(")");
                return sb.toString();
            }
            else {
                map.put(rem, sb.length());
                res = rem * 10 / den;
                sb.append(res);
                rem = rem * 10 % den;
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
    	int num1 = 2;
    	int num2 = 3;
    	int num3 = -1;
    	int num4 = -2147483648;
    	System.out.println(fraction.fractionToDecimal(num1, num2));
    	System.out.println(fraction.fractionToDecimal(num3, num4));
    	
    }
}
