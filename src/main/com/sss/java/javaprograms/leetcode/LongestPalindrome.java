package src.main.com.sss.java.javaprograms.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest palindrome that can be formed using the characters of the string.
 * <p>
 * Approach:
 * <p>
 * Brute force approach:
 * The simplest approach to solve this problem can be to try all possible combinations of characters to check if they can form a palindrome,
 * and find the length of the longest palindrome.
 * The algorithm is as follows:
 * 1. Iterate over all possible substrings using two nested loops.
 * 2. Check each substring for palindrome property using the helper function.
 * 3. Keep track of the maximum length encountered.
 * 4. Return the maximum length.
 * <p>
 * This approach has a time complexity of O(n^3). Hence, this is not a preferrable way to solve this problem.
 * <p>
 * Optimal Solution:
 * The optimal approach to find the longest palindrome is to count the occurrences of each character in the string and use them to calculate the length of the longest palindrome.
 * For each character:
 * If its count is even, it can be included in the palindrome as it can form pairs.
 * If the count is odd, we can include all but one occurrence of that character in the palindrome, as it can be placed in the middle.
 * Palindromes can have characters in pairs (even count) and at most one character with an odd count.
 * By considering these rules, we can calculate the length of the longest palindrome.
 * <p>
 * The algorithm is as follows:
 * 1. Initialize a HashMap 'charCount' to count the frequency of each character in the input string.
 * 2. Iterate through the character counts to calculate the length of the longest palindrome.
 * 3. Return the maximum length of the palindrome.
 * <p>
 * Time Complexity: O(n), where n is the length of the input string. We iterate through the string once to count the occurrences.
 * <p>
 * Space Complexity: O(n), where n is the length of the input string, as we are using a HashMap of size n to store the frequency of each character.
 * <p>
 * Leetcode Link: https://leetcode.com/problems/longest-palindrome/
 **/

public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        Map<Character, Integer> charCount = new HashMap<>();

        // Count the occurrences of each character
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        int palindromeLength = 0;
        boolean hasOddCount = false;

        // Calculate the length of the longest palindrome
        for (int count : charCount.values()) {
            if (count % 2 == 0) {
                palindromeLength += count;
            } else {
                palindromeLength += count - 1;
                hasOddCount = true;
            }
        }

        // Include one character with odd count in the middle if applicable
        if (hasOddCount) {
            palindromeLength++;
        }

        return palindromeLength;
    }

    public static void main(String[] args) {
        // Test Case 1
        String s1 = "abccccdd";
        int result1 = longestPalindrome(s1);
        System.out.println("Longest palindrome length for \"" + s1 + "\": " + result1); // Output: 7

        // Test Case 2
        String s2 = "a";
        int result2 = longestPalindrome(s2);
        System.out.println("Longest palindrome length for \"" + s2 + "\": " + result2); // Output: 1

        // Test Case 3
        String s3 = "bb";
        int result3 = longestPalindrome(s3);
        System.out.println("Longest palindrome length for \"" + s3 + "\": " + result3); // Output: 2

        // Test Case 4
        String s4 = "ccc";
        int result4 = longestPalindrome(s4);
        System.out.println("Longest palindrome length for \"" + s4 + "\": " + result4); // Output: 3

        // Test Case 5
        String s5 = "abccccdde";
        int result5 = longestPalindrome(s5);
        System.out.println("Longest palindrome length for \"" + s5 + "\": " + result5); // Output: 7

        // Test Case 6
        String s6 = "bananas";
        int result6 = longestPalindrome(s6);
        System.out.println("Longest palindrome length for \"" + s6 + "\": " + result6); // Output: 5
    }
    /*
     * Explanation of the Code:
     *
     * Character Counts:
     *
     * The code uses a HashMap (charCount) to store the frequency of each character in the input string s.
     * Palindrome Length Calculation:
     *
     * It iterates through the character counts in the charCount map.
     * For each character count:
     * If the count is even, it adds the entire count to palindromeLength. Even numbers of characters can be perfectly arranged in a palindrome.
     * If the count is odd, it adds count - 1 to palindromeLength. This is because we can use all but one of the characters to form pairs in the palindrome.
     * The hasOddCount flag is set to true if any odd character count is encountered.
     * Middle Character:
     *
     * If hasOddCount is true, it means there's at least one character with an odd count. We can place this single character in the middle of the palindrome, so palindromeLength is incremented by 1.
     * Return Length:
     *
     * The function returns the final palindromeLength, which represents the length of the longest palindrome that can be constructed from the given string.
     * How it Works (Example: "abccccdd"):
     *
     * Character Counts:
     *
     * a: 1
     * b: 1
     * c: 4
     * d: 2
     * Palindrome Length Calculation:
     *
     * a: 1 (odd) -> palindromeLength += 0, hasOddCount = true
     * b: 1 (odd) -> palindromeLength += 0, hasOddCount = true
     * c: 4 (even) -> palindromeLength += 4
     * d: 2 (even) -> palindromeLength += 2
     * Middle Character:
     *
     * hasOddCount is true, so palindromeLength += 1
     * Result:
     *
     * palindromeLength = 4 + 2 + 1 = 7

      */
}

