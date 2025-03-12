package src.main.com.sss.java.javaprograms.leetcode;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 *
Approach:

Brute Force Approach:
The brute force approach behind finding the longest common prefix among a given array of strings is to compare the characters one by one and keep
 updating the longest common prefix until a mismatch is found or the shortest string is exhausted.
By iterating through the strings, we can gradually narrow down the common prefix.
The time complexity of this approach is O(n^2), where n is the number of strings in the array.

Optimal Solution:
The intuition for the optimal approach used in the code:
1. We start by assuming the first string in the array as the initial prefix.
2. For each subsequent string in the array, we compare it with the current prefix.
3. If the current prefix is not a prefix of the current string, we remove the last character from the prefix and repeat the comparison.
4. We continue this process until we find the longest common prefix or the prefix becomes empty.

Time complexity: O(n * m), where n is the number of strings in the array and m is the length of the shortest string.
 This is because we iterate through all the strings and
 compare each character until a mismatch is found or the shortest string is exhausted.

Space complexity: O(1), since we only use a constant amount of extra space to store the common prefix. We do not use any additional data structures that depend on the input size.

Leetcode Link: https://leetcode.com/problems/longest-common-prefix/

 */

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] strs1 = {"flower", "flow", "flight"};
        String result1 = longestCommonPrefix(strs1);
        System.out.println("Longest common prefix for {\"flower\", \"flow\", \"flight\"}: " + result1); // Output: fl

        // Test Case 2
        String[] strs2 = {"dog", "racecar", "car"};
        String result2 = longestCommonPrefix(strs2);
        System.out.println("Longest common prefix for {\"dog\", \"racecar\", \"car\"}: " + result2); // Output: ""

        // Test Case 3
        String[] strs3 = {"apple", "application", "apply"};
        String result3 = longestCommonPrefix(strs3);
        System.out.println("Longest common prefix for {\"apple\", \"application\", \"apply\"}: " + result3); // Output: appl

        // Test Case 4
        String[] strs4 = {"c", "c"};
        String result4 = longestCommonPrefix(strs4);
        System.out.println("Longest common prefix for {\"c\", \"c\"}: " + result4); // Output: c

        //Test Case 5
        String[] strs5 = {""};
        String result5 = longestCommonPrefix(strs5);
        System.out.println("Longest common prefix for {\"\"}: " + result5); // Output: ""

        //Test Case 6
        String[] strs6 = {"ab", "a"};
        String result6 = longestCommonPrefix(strs6);
        System.out.println("Longest common prefix for {\"ab\", \"a\"}: " + result6); // Output: a

    }

}
