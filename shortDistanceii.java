package GoogleOA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words 
 * and your method will be called repeatedly many times with different parameters. How would you optimize it?
 * Design a class which receives a list of words in the constructor, and implements a method that takes two 
 * words word1 and word2 and return the shortest distance between these two words in the list.
 * For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * Given word1 = “coding”, word2 = “practice”, return 3.
 * Given word1 = "makes", word2 = "coding", return 1.
 * Note: You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 * */

public class shortDistanceii {
	
	private Map<String, List<Integer>> map;

    public shortDistanceii(String[] words) {
        map = new HashMap<String, List<Integer>>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.get(words[i]).add(i);
            }
            else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(words[i], list);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        while (i < l1.size() && j < l2.size()) {
            int p1 = l1.get(i);
            int p2 = l2.get(j);
            if (p1 < p2) {
                min = Math.min(min, p2 - p1);
                i++;
            }
            else {
                min = Math.min(min, p1 - p2);
                j++;
            }
        }
        return min;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");
