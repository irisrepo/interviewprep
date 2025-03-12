package src.main.com.sss.java.javaprograms.leetcode;

/**
 * Given an array nums of size n, return the majority element.
 * <p>
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 * <p>
 * <p>
 * Intuition:
 * The majority element in an array is defined as the element that appears more than n/2 times, where n is the size of the array.
 * One simple approach to find the majority element is to use a brute force algorithm that checks each element and counts
 * its occurrences in the array. The element with the highest count that exceeds n/2 is considered the majority element.
 * <p>
 * Approach:
 * <p>
 * Brute Force Approach:
 * 1. Initialize a variable, majority, to store the current majority element, and count to keep track of its occurrence count.
 * 2. Iterate through each element, num, in the array.
 * 3. For each element, iterate through the array again to count the number of occurrences.
 * 4. If the count exceeds n/2, update the majority element and its count.
 * 5. Return the majority element as the result.
 * <p>
 * The brute force approach works by examining each element and counting its occurrences, but it requires nested loops,
 * resulting in a time complexity of O(n^2) since we iterate through the array twice. While this approach is simple to implement,
 * it may not be efficient for large arrays.
 * <p>
 * Optimal Solution:
 * We can optimize the algorithm using the Boyer-Moore Voting Algorithm, which has a time complexity of O(n).
 * <p>
 * Working of the algorithm:
 * 1. Initialize a counter variable to 1, and another variable majority index, to track the index of the potential majority element.
 * 2. For each element in the array, check whether the element is equal to the element at majority index. In order to be a potential majority element, an element needs to have its matching counterpart in the array.
 * 3. If yes, increment the count variable. Else, decrement the counter.
 * 4. If the value of the count variable becomes 0, we will reset the count variable to 1 and the majority index will now point to the current index 'i'.
 * 5. Return the element at majority index as the majority element.
 * <p>
 * The intuition behind this optimized approach is that if we cancel out each occurrence of an element with all the other elements that
 * are different from it, the remaining element will be the majority element.
 * <p>
 * Time complexity: O(n)
 * The algorithm iterates through the array once, performing constant-time operations for each element.
 * <p>
 * Space complexity: O(1)
 * The algorithm uses only a constant amount of extra space to store the majority index.
 * <p>
 * Leetcode link: https://leetcode.com/problems/majority-element/
 */
public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int count = 1;
        int maj = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == nums[maj]) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                count = 1;
                maj = i;
            }
        }

        return nums[maj];
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {3, 2, 3};
        int result1 = majorityElement(nums1);
        System.out.println("Majority element: " + result1); // Output: 3

        // Test Case 2
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        int result2 = majorityElement(nums2);
        System.out.println("Majority element: " + result2); // Output: 2

        // Test Case 3
        int[] nums3 = {1};
        int result3 = majorityElement(nums3);
        System.out.println("Majority element: " + result3); // Output: 1

        // Test Case 4
        int[] nums4 = {2, 2, 2, 1, 1};
        int result4 = majorityElement(nums4);
        System.out.println("Majority element: " + result4); // Output: 2

        // Test Case 5
        int[] nums5 = {1, 2, 3, 4, 5, 5, 5, 5, 5};
        int result5 = majorityElement(nums5);
        System.out.println("Majority element: " + result5); // Output: 5

        //Test Case 6
        int[] nums6 = {3,3,3,1,2};
        int result6 = majorityElement(nums6);
        System.out.println("Majority element: " + result6); // Output: 3

    }

}
