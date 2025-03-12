package src.main.com.sss.java.javaprograms.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        int maxLength = 0;

        // Add all numbers to a set for O(1) lookup
        for (int num : nums) {
            numSet.add(num);
        }

        // Iterate through each number in the set
        for (int num : numSet) {
            // Check if num-1 is in the set, if it is, skip this number
            if (!numSet.contains(num - 1)) {

                // Otherwise, we have found a new sequence
                int currentNum = num;
                int currentLength = 1;

                // Iterate through the consecutive numbers until we reach the end of the sequence
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                // Update the maxLength if necessary
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        int result1 = longestConsecutive(nums1);
        System.out.println("Longest consecutive sequence length: " + result1); // Output: 4

        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int result2 = longestConsecutive(nums2);
        System.out.println("Longest consecutive sequence length: " + result2); // Output: 9

        int[] nums3 = {1, 2, 3, 4, 5};
        int result3 = longestConsecutive(nums3);
        System.out.println("Longest consecutive sequence length: " + result3); // Output: 5

        int[] nums4 = {1, 1, 1, 1, 1};
        int result4 = longestConsecutive(nums4);
        System.out.println("Longest consecutive sequence length: " + result4); // Output: 1

        int[] nums5 = {};
        int result5 = longestConsecutive(nums5);
        System.out.println("Longest consecutive sequence length: " + result5); // Output: 0

        int[] nums6 = {-1, 0, 1};
        int result6 = longestConsecutive(nums6);
        System.out.println("Longest consecutive sequence length: " + result6); // Output: 3
    }

}

