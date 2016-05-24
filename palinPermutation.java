package GoogleOA;

import java.util.HashSet;
import java.util.Set;

/* Given a string, determine if a permutation of the string could form a palindrome.
 * For example, "code" -> False, "aab" -> True, "carerac" -> True.
 * Hint:
 * Consider the palindromes of odd vs even length. What difference do you notice?
 * Count the frequency of each character.
 * If each character occurs even number of times, then it must be a palindrome. How about character which 
 * occurs odd number of times?
 * */
//Time O(n) Space O(1)
public class palinPermutation {
	public static boolean canPermutePalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
            }
            else {
                set.remove(s.charAt(i));
            }
        }
        return set.size() == 1 || set.size() == 0;
    }
	public static void main(String... args) {
		String s1 = "code";
		System.out.println(palinPermutation.canPermutePalindrome(s1));
		String s2 = "aab";
		System.out.println(palinPermutation.canPermutePalindrome(s2));
		String s3 = "carerac";
		System.out.println(palinPermutation.canPermutePalindrome(s3));
	}
}
