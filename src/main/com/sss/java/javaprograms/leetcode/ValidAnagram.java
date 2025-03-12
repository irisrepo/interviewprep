package src.main.com.sss.java.javaprograms.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 * Approach:
 *
 * Brute Force Approach:
 * Anagrams have the same characters but in different orders. So, the first and straightforward approach to solve this would be sorting the characters and checking whether the new strings after sorting are equal or not.
 * Time Complexity: O(n log n), for sorting. 
 * Space Complexity: O(n), for storing sorted strings.
 *
 * Optimal Solution: Using HashMap
 * An optimized way to solve this problem would be to use a hash map to count the frequency of characters in both strings and compare the frequency maps of both strings.
 * Time Complexity: O(n)
 * Space Complexity: O(n), for storing the frequency maps.
 *
 * Leetcode link: https://leetcode.com/problems/valid-anagram/
 *
 */
public class ValidAnagram {
    public static void main(String[] args) {
        System.out.print(isAnagramCheck("racecar","carrace"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        for (char ch : t.toCharArray()) {
            if (!frequencyMap.containsKey(ch)) {
                return false;
            }
            frequencyMap.put(ch, frequencyMap.get(ch) - 1);

            if (frequencyMap.get(ch) == 0) {
                frequencyMap.remove(ch);
            }
        }
        return frequencyMap.isEmpty();
    }

    public static boolean isAnagramCheck(String s ,String t){
        boolean isAnagram = false;

        if(s.length()!=t.length()){
            return isAnagram;
        }
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        if(Arrays.equals(ch1,ch2)){
            isAnagram = true;
        }
        return isAnagram;
    }
}