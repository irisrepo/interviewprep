package src.main.com.sss.java.javaprograms.leetcode.stacks;

import java.util.Stack;


public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                result[idx] = i - idx;
            }
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();

        // Test Case 1
        int[] temperatures1 = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result1 = dailyTemperatures.dailyTemperatures(temperatures1);
        System.out.print("Test Case 1 Output: ");
        for (int val : result1) {
            System.out.print(val + " ");
        }
        System.out.println(); // Expected Output: 1 1 4 2 1 1 0 0

        // Test Case 2
        int[] temperatures2 = {30, 40, 50, 60};
        int[] result2 = dailyTemperatures.dailyTemperatures(temperatures2);
        System.out.print("Test Case 2 Output: ");
        for (int val : result2) {
            System.out.print(val + " ");
        }
        System.out.println(); // Expected Output: 1 1 1 0

        // Test Case 3
        int[] temperatures3 = {60, 50, 40, 30};
        int[] result3 = dailyTemperatures.dailyTemperatures(temperatures3);
        System.out.print("Test Case 3 Output: ");
        for (int val : result3) {
            System.out.print(val + " ");
        }
        System.out.println(); // Expected Output: 0 0 0 0
    }
}
/**
 * Explanation:
 * <p>
 * Initialization:
 * <p>
 * n = temperatures.length;: Gets the length of the input temperatures array.
 * result = new int[n];: Creates an integer array result of the same length as temperatures to store the number of days until a warmer temperature.
 * stack = new Stack<>();: Initializes an empty stack of integers. This stack will store the indices of the temperatures.
 * Iterating Through Temperatures:
 * <p>
 * The code iterates through the temperatures array using a for loop ( for (int i = 0; i < n; i++) ).
 * Using the Stack to Find Warmer Days:
 * <p>
 * while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]): This while loop is the core of the algorithm. It continues as long as the stack is not empty and the current temperature (temperatures[i]) is greater than the temperature at the index at the top of the stack (temperatures[stack.peek()]).
 * In other words, we're checking if the current temperature is warmer than the temperature of a day we've seen previously (which is stored as an index in the stack).
 * int idx = stack.pop();:
 * If the condition in the while loop is true, it means we've found a warmer day for the day at the top of the stack. We get the index of that previous day by popping it from the stack and store it in idx.
 * result[idx] = i - idx;: We calculate the number of days between the warmer day (i) and the previous day (idx) and store it in the result array at the index idx.
 * stack.push(i);: After the while loop (either after finding warmer days or if the while condition was initially false), we push the current day's index (i) onto the stack.
 * Returning the Result:
 * <p>
 * return result;: After processing all temperatures, the result array contains the number of days until a warmer temperature for each day. The code returns this result array.
 * How the Stack Helps:
 * <p>
 * The stack is used to keep track of the days for which we haven't yet found a warmer day.
 * <p>
 * When we find a warmer day, we can go back and determine how many days it took to reach that warmer day for the days stored in the stack.
 * The stack maintains a decreasing sequence of temperatures (from bottom to top). This helps us efficiently find the next warmer day for each day.
 * Example Walkthrough (temperatures1 = {73, 74, 75, 71, 69, 72, 76, 73}):
 * <p>
 * i	temperatures[i]	Stack	result
 * 0	73	[0]	[0, 0, 0, 0, 0, 0, 0, 0]
 * 1	74	[1]	[1, 0, 0, 0, 0, 0, 0, 0]
 * 2	75	[2]	[1, 1, 0, 0, 0, 0, 0, 0]
 * 3	71	[2, 3]	[1, 1, 0, 0, 0, 0, 0, 0]
 * 4	69	[2, 3, 4]	[1, 1, 0, 0, 0, 0, 0, 0]
 * 5	72	[2, 3, 5]	[1, 1, 0, 2, 0, 0, 0, 0]
 * 6	76	[6]	[1, 1, 4, 2, 0, 1, 0, 0]
 * 7	73	[6, 7]	[1, 1, 4, 2, 1, 1, 0, 0]
 */