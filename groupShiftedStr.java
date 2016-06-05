package GoogleOA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We 
 * can keep "shifting" which forms the sequence: "abc" -> "bcd" -> ... -> "xyz"
 * Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same 
 * shifting sequence.
 * For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
 * A solution is:
[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
 * */

public class groupShiftedStr {
	public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strings) {
            int offset = s.charAt(0) - 'a';
            StringBuilder key = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = (char)(s.charAt(i) - offset);
                if (c < 'a') {
                    c += 26;
                }
                key.append(c);
            }
            if (!map.containsKey(key.toString())) {
                map.put(key.toString(), new ArrayList<String>());
            }
            map.get(key.toString()).add(s);
        }
        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            Collections.sort(list);
            res.add(list);
        }
        return res;
    }
}
