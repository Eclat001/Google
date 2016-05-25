package GoogleOA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * Find all strobogrammatic numbers that are of length = n.
 * For example, Given n = 2, return ["11","69","88","96"].
 * Hint: Try to use recursion and notice that it should recurse with n - 2 instead of n - 1.
 * */

public class stroboNumii {
	public static List<String> findStrobogrammatic(int n) {
        List<String> one = Arrays.asList("0", "1", "8");
        List<String> res = Arrays.asList("");
        if (n % 2 == 1) {
            res = one;
        }
        for (int i = n % 2; i < n; i += 2) {
            List<String> newres = new ArrayList<String>();
            for (String s : res) {
                if (i != n - 2) {
                    newres.add("0" + s + "0");
                }
                newres.add("1" + s + "1");
                newres.add("6" + s + "9");
                newres.add("8" + s + "8");
                newres.add("9" + s + "6");
            }
            res = newres;
        }
        return res;
    }
	public static void main(String... args) {
		List<String> l1 = stroboNumii.findStrobogrammatic(1);
		for (int i = 0; i < l1.size(); i++) {
			System.out.println(l1.get(i));
		}
		List<String> l2 = stroboNumii.findStrobogrammatic(2);
		for (int i = 0; i < l2.size(); i++) {
			System.out.println(l2.get(i));
		}
		List<String> l3 = stroboNumii.findStrobogrammatic(3);
		for (int i = 0; i < l3.size(); i++) {
			System.out.println(l3.get(i));
		}
	}
}
