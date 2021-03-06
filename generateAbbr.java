package GoogleOA;

import java.util.ArrayList;
import java.util.List;

/* Write a function to generate the generalized abbreviations of a word.
 * Example:
 * Given word = "word", return the following list (order does not matter):
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", 
 * "w3", "4"]
 * */

public class generateAbbr {
	public static List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String>();
        int len = word.length();
        res.add(len == 0 ? "" : String.valueOf(len));
        for (int i = 0; i < len; i++) {
            for (String right : generateAbbreviations(word.substring(i + 1))) {
                String leftNum = i > 0 ? String.valueOf(i) : "";
                res.add(leftNum + word.substring(i, i + 1) + right);
            }
        }
        return res;
    }
	public static void main(String... args) {
		String s = "word";
		System.out.println(generateAbbr.generateAbbreviations(s));				
	}
}
