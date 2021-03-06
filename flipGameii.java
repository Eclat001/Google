package GoogleOA;

import java.util.HashMap;
import java.util.Map;

/* You are playing the following Flip Game with your friend: Given a string that contains only these two 
 * characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends 
 * when a person can no longer make a move and therefore the other person will be the winner.
 * Write a function to determine if the starting player can guarantee a win.
 * For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle 
 * "++" to become "+--+".
 * Follow up: Derive your algorithm's runtime complexity.
 * */

public class flipGameii {
	//If we use HashMap to memorize both win string & lose string, we can further reduce time
    public static boolean canWin(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        return canWin(s, map);
    }
    public static boolean canWin(String s, Map<String, Boolean> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.startsWith("++", i)) {
                String tem = s.substring(0, i) + "--" + s.substring(i + 2);
                if (!canWin(tem, map)) {
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }
    public static void main(String... args) {
    	String s = "++++--+";
		System.out.println(flipGameii.canWin(s));
    }
}
