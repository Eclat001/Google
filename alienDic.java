package GoogleOA;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/* There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to
 * you. You receive a list of words from the dictionary, where words are sorted lexicographically by the rules 
 * of this new language. Derive the order of letters in this language.
 * For example,
 * Given the following words in dictionary,
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]                                        The correct order is: "wertf".
 * Note:
 * You may assume all letters are in lowercase.
 * If the order is invalid, return an empty string.
 * There may be multiple valid order of letters, return any one of them is fine.
 * */

public class alienDic {
	
	public class Node {
        public int degree;
        public ArrayList<Integer> neighbour = new ArrayList<Integer>();
        Node() {
            degree = 0;
        }
    }
	
    public String alienOrder(String[] words) {
        Node[] node = new Node[26];
        boolean[] happen = new boolean[26];
        for (int i = 0; i < 26; i++) {
            node[i] = new Node();
        }
        //Build the Graph
        for (int i = 0; i < words.length; i++) {
            int start = 0;
            int end = 0;
            for (int j = 0; j < words[i].length(); j++) {
                happen[words[i].charAt(j) - 'a'] = true;
            }
            if (i != words.length - 1) {
                for (int j = 0; j < Math.min(words[i].length(), words[i + 1].length()); j++) {
                    if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                        start = words[i].charAt(j) - 'a';
                        end = words[i + 1].charAt(j) - 'a';
                        break;
                    }
                }
            }
            if (start != end) {
                node[start].neighbour.add(end);
                node[end].degree++;
            }
        }
        //Topological Sort
        Queue<Integer> queue = new LinkedList<Integer>();
        String res = "";
        for (int i = 0; i < 26; i++) {
            if (node[i].degree == 0 && happen[i]) {
                queue.offer(i);
                res = res + (char)(i + 'a');
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i : node[cur].neighbour) {
                node[i].degree--;
                if (node[i].degree == 0) {
                    queue.offer(i);
                    res = res + (char)(i + 'a');
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            if (node[i].degree != 0) {
                return "";
            }
        }
        return res;
    }
}
