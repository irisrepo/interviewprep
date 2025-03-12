package src.main.com.sss.java.javaprograms.leetcode;

/*      Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

        You may assume that each input would have exactly one solution, and you may not use the same element twice.

        You can return the answer in any order.

        Example 1:
        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
        Example 2:

        Input: nums = [3,2,4], target = 6
        Output: [1,2]
        Example 3:
        Input: nums = [3,3], target = 6
        Output: [0,1]
        */


import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum solution = new TwoSum();

        // Example 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println("Example 1: [" + result1[0] + ", " + result1[1] + "]"); // Output: [0, 1]

        // Example 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println("Example 2: [" + result2[0] + ", " + result2[1] + "]"); // Output: [1, 2]

    }


    public int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store the difference and its index
        Map<Integer, Integer> numToIndex = new HashMap<>();
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int difference = target - num;
            // Check if the difference exists in the HashMap
            if (numToIndex.containsKey(difference)) {
                // If it exists, return the indices
                return new int[]{numToIndex.get(difference), i};
            }
            // Otherwise, store the current number and its index in the HashMap
            numToIndex.put(num, i);
        }
        return new int[]{};
    }
}
