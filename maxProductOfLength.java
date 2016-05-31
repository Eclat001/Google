package GoogleOA;

import java.util.Arrays;
import java.util.Comparator;

/* Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words 
 * do not share common letters. You may assume that each word will contain only lower case letters. If no such 
 * two words exist, return 0.
 * Example 1: Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"] Return 16
 * The two words can be "abcw", "xtfn".
 * Example 2: Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"] Return 4
 * The two words can be "ab", "cd".
 * Example 3: Given ["a", "aa", "aaa", "aaaa"] Return 0
 * No such pair of words.
 * */

public class maxProductOfLength {
	public static int maxProduct(String[] words) {
        int max = 0;
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });
        int[] masks = new int[words.length];
        for (int i = 0; i < masks.length; i++) {    //alphabet masks
            for (char c : words[i].toCharArray()) {
                masks[i] |= 1 << (c - 'a');    //1左移c - 'a'位
            }
        }
        for (int i = 0; i < masks.length; i++) {
            if (words[i].length() * words[i].length() <= max) {
                break;    //That's what sorting is for. if squaring is not larger than max, the product will not get larger.
            }
            for (int j = i + 1; j < masks.length; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                    break;
                }
            }
        }
        return max;
    }
	public static void main(String... args) {
		String[] s1 = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
		System.out.println(maxProductOfLength.maxProduct(s1));
		String[] s2 = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
		System.out.println(maxProductOfLength.maxProduct(s2));
		String[] s3 = {"a", "aa", "aaa", "aaaa"};
		System.out.println(maxProductOfLength.maxProduct(s3));
	}
}
