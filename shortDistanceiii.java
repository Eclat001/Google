package GoogleOA;

/* This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in
 * the list.
 * word1 and word2 may be the same and they represent two individual words in the list.
 * For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * Given word1 = �makes�, word2 = �coding�, return 1.
 * Given word1 = "makes", word2 = "makes", return 3.
 * Note: You may assume word1 and word2 are both in the list.
 * */

public class shortDistanceiii {
	public static int shortestWordDistance(String[] words, String word1, String word2) {
        int p1 = -1;
        int p2 = -1;
        int min = Integer.MAX_VALUE;
        boolean same = word1.equals(word2);
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                if (same) {
                    p2 = p1;
                    p1 = i;
                }
                else {
                    p1 = i;
                }
            }
            else if (words[i].equals(word2)) {
                p2 = i;
            }
            if (p1 != -1 && p2 != -1) {
                min = Math.min(min, Math.abs(p1 - p2));
            }
        }
        return min;
    }
	public static void main(String... args) {
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		String w1 = "makes";
		String w2 = "makes";
		String w3 = "makes";
		String w4 = "coding";
		System.out.println(shortDistanceiii.shortestWordDistance(words, w1, w2));
		System.out.println(shortDistanceiii.shortestWordDistance(words, w3, w4));
	}
}
