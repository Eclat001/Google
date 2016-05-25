package GoogleOA;

/* A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
 * */

public class stroboNum {
	public static boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) {
            return true;
        }
        int l = 0;
        int r = num.length() - 1;
        while (l < r && l < num.length() && r >= 0) {
            if ((num.charAt(l) == '0' && num.charAt(r) == '0') || (num.charAt(l) == '1' && num.charAt(r) == '1') 
             || (num.charAt(l) == '8' && num.charAt(r) == '8') || (num.charAt(l) == '6' && num.charAt(r) == '9') 
             || (num.charAt(l) == '9' && num.charAt(r) == '6')) {
                 l++;
                 r--;
             }
             else {
                 return false;
             }
        }
        if (l == r) {
            return num.charAt(l) == '0' || num.charAt(l) == '1' || num.charAt(l) == '8';
        }
        return true;
    }
	public static void main(String... args) {
		String n1 = "69";
		String n2 = "66";
		String n3 = "818";
		String n4 = "25";
		System.out.println(stroboNum.isStrobogrammatic(n1));
		System.out.println(stroboNum.isStrobogrammatic(n2));
		System.out.println(stroboNum.isStrobogrammatic(n3));
		System.out.println(stroboNum.isStrobogrammatic(n4));
	}
}
