package src.main.com.sss.java.javaprograms.leetcode.array;

public class MaxAscendingSubarraySum {
    public static int maxAscendingSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currentSum += nums[i];
            } else {
                currentSum = nums[i];
            }
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] nums = {10, 11, 12, 3, 4, 30, 31};
        int result = maxAscendingSum(nums);
        System.out.println("Maximum ascending subarray sum: " + result); // Output: 68

        int[] nums2 = {100, 10, 1};
        int result2 = maxAscendingSum(nums2);
        System.out.println("Maximum ascending subarray sum: " + result2); // Output: 100

        int[] nums3 = {12,17,15,13,10,11,12};
        int result3 = maxAscendingSum(nums3);
        System.out.println("Maximum ascending subarray sum: " + result3); // Output: 33

        int[] nums4 = {1,2,3,4,5};
        int result4 = maxAscendingSum(nums4);
        System.out.println("Maximum ascending subarray sum: " + result4); // Output: 15

        int[] nums5 = {5,4,3,2,1};
        int result5 = maxAscendingSum(nums5);
        System.out.println("Maximum ascending subarray sum: " + result5); // Output: 5
    }
}