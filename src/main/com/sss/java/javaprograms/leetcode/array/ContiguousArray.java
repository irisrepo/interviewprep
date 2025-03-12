package src.main.com.sss.java.javaprograms.leetcode.array;


import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {0, 1};
        int result1 = findMaxLength(nums1);
        System.out.println("Max length: " + result1); // Output: 2

        // Test Case 2
        int[] nums2 = {0, 1, 0};
        int result2 = findMaxLength(nums2);
        System.out.println("Max length: " + result2); // Output: 2

        // Test Case 3
        int[] nums3 = {0, 0, 1, 0, 0, 0, 1, 1};
        int result3 = findMaxLength(nums3);
        System.out.println("Max length: " + result3); // Output: 6

        // Test Case 4
        int[] nums4 = {1, 1, 1, 0, 0, 0, 1};
        int result4 = findMaxLength(nums4);
        System.out.println("Max length: " + result4); // Output: 6

        // Test Case 5
        int[] nums5 = {0, 0, 0, 0};
        int result5 = findMaxLength(nums5);
        System.out.println("Max length: " + result5); // Output: 0

        // Test Case 6
        int[] nums6 = {1, 1, 1, 1};
        int result6 = findMaxLength(nums6);
        System.out.println("Max length: " + result6); // Output: 0

        // Test Case 7
        int[] nums7 = {0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1};
        int result7 = findMaxLength(nums7);
        System.out.println("Max length: " + result7); // Output: 16
    }

    public static int findMaxLength(int[] nums) {
        int count = 0;  // Variable to keep track of the count of 0s and 1s encountered so far
        int maxLength = 0;  // Variable to store the maximum length of the subarray
        Map<Integer, Integer> countMap = new HashMap<>();  // Hashmap to store the count and its corresponding index

        countMap.put(0, -1);  // Initial entry in the hashmap to handle the case when subarray starts from index 0

        for (int i = 0; i < nums.length; i++) {
            count += (nums[i] == 1 ? 1 : -1);  // Increment count by 1 if the element is 1, else decrement by 1

            if (countMap.containsKey(count)) {
                // If the current count is already present in the hashmap, calculate the length of the subarray
                // by subtracting the previous index (stored in the hashmap) from the current index
                maxLength = Math.max(maxLength, i - countMap.get(count));
            } else {
                // If the current count is not present in the hashmap, add an entry with the count and its corresponding index
                countMap.put(count, i);
            }
        }

        return maxLength;

    }
}


