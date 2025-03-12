package src.main.com.sss.java.javaprograms.leetcode;

import java.util.HashMap;
import java.util.Map;
/*
Determines if two strings are isomorphic by checking their character mappings.

Approach:

Brute Force Approach:
1. Traverse through the first string, say 's'.
2. For each character in s, check for the corresponding mapping of that character in second string, 't'.
3. Check whether the mapping is in the correct order.

This approach has a time complexity of O(n^2), where n is the total number of characters in s.

Optimal Solution:
We can use a hashmap, where the characters of s are keys and characters of t are mapped as values, as there is a mapping of each character of s in t.
We will insert the values for the corresponding key, keeping the following conditions in mind. Do not add values to the hashmap if:

1. Keys are same but the values are different.
2. Keys are different but the values are same.
Otherwise, we simply add to the hashmap the mapping of characters at 's' and 't'.

Time Complexity: O(n)

Space complexity: O(Number of different characters)

Leetcode link: https://leetcode.com/problems/isomorphic-strings/

 */

public class IsomorphicStrings {
    public static void main(String[] args) {
        IsomorphicStrings isomorphic = new IsomorphicStrings();

        // Test cases
        String s1 = "egg";
        String t1 = "add";
        System.out.println("\"" + s1 + "\" and \"" + t1 + "\" are isomorphic: " + isomorphic.isIsomorphic(s1, t1)); // true

        String s2 = "foo";
        String t2 = "bar";
        System.out.println("\"" + s2 + "\" and \"" + t2 + "\" are isomorphic: " + isomorphic.isIsomorphic(s2, t2)); // false

        String s3 = "paper";
        String t3 = "title";
        System.out.println("\"" + s3 + "\" and \"" + t3 + "\" are isomorphic: " + isomorphic.isIsomorphic(s3, t3)); // true

        String s4 = "badc";
        String t4 = "baba";
        System.out.println("\"" + s4 + "\" and \"" + t4 + "\" are isomorphic: " + isomorphic.isIsomorphic(s4, t4)); // false

        String s5 = "ab";
        String t5 = "aa";
        System.out.println("\"" + s5 + "\" and \"" + t5 + "\" are isomorphic: " + isomorphic.isIsomorphic(s5, t5)); // false

        String s6 = "abc";
        String t6 = "xyz";
        System.out.println("\"" + s6 + "\" and \"" + t6 + "\" are isomorphic: " + isomorphic.isIsomorphic(s6, t6)); // true
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> map1 = new HashMap<>();
        int i = 0;

        while (i < s.length()) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (map1.containsKey(c1)) {
                if (map1.get(c1) != c2) {
                    return false;
                }
            } else if (map1.containsValue(c2)) {
                return false;
            } else {
                map1.put(c1, c2);
            }
            i++;
        }
        return true;
    }
}

