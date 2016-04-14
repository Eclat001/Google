package GoogleOA;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* Given a string s and a dictionary of words dict, add spaces in s to construct a sentence 
 * where each word is a valid dictionary word. Return all such possible sentences.
 * For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand", "dog"].
 * A solution is ["cats and dog", "cat sand dog"].
 * */

public class wordBreakII {
	public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() == 0) {
            return res;
        }
        //针对不能break的，但是又很长，出现大量的记录和回溯的case
        int maxLength = 0;
        for (String temp : wordDict) {
            maxLength = Math.max(temp.length(), maxLength);
        }
        //seg[i]是表示到字符串s的第i个元素为止能不能用字典中的词来表示
        boolean[] seg = new boolean[s.length() + 1];
        seg[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= maxLength && j <= i; j++) {
                if (!seg[i - j]) {
                    continue;
                }
                String word = s.substring(i - j, i);
                if (wordDict.contains(word)) {
                    seg[i] = true;
                    break;
                }
            }
        }
        if (!seg[s.length()]) {
            return res;
        }
        help(s, wordDict, res, 0, "");
        return res;
    }
    private void help(String s, Set<String> wordDict, List<String> res, int pos, String item) {
        if (pos == s.length()) {
            res.add(item);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = pos; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (wordDict.contains(sb.toString())) {
                String newitem = item.length() > 0 ? (item + " " + sb.toString()) : sb.toString();
                help(s, wordDict, res, i + 1, newitem);
            }
        }
    }
}
