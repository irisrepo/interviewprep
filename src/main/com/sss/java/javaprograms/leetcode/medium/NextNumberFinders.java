package src.main.com.sss.java.javaprograms.leetcode.medium;

import java.util.Arrays;

public class NextNumberFinders {

    public static void main(String args) {
        int num = 218765;
        int nextHighest = findNextHighest(num);
        int nextLowest = findNextLowest(num);

        System.out.println("Given number: " + num);
        System.out.println("Next highest number: " + nextHighest); // Output: 251678
        System.out.println("Next lowest number: " + nextLowest);  // Output: 218756

        int num2 = 534976;
        nextHighest = findNextHighest(num2);
        nextLowest = findNextLowest(num2);
        System.out.println("Given number: " + num2);
        System.out.println("Next highest number: " + nextHighest); // Output: 534967
        System.out.println("Next lowest number: " + nextLowest);  // Output: 534769

        int num3 = 1234;
        nextHighest = findNextHighest(num3);
        nextLowest = findNextLowest(num3);
        System.out.println("Given number: " + num3);
        System.out.println("Next highest number: " + nextHighest); // Output: 1243
        System.out.println("Next lowest number: " + nextLowest);  // Output: 1234

        int num4 = 4321;
        nextHighest = findNextHighest(num4);
        nextLowest = findNextLowest(num4);
        System.out.println("Given number: " + num4);
        System.out.println("Next highest number: " + nextHighest); // Output: -1
        System.out.println("Next lowest number: " + nextLowest);  // Output: 4312
    }


    public static int findNextHighest(int num) {
        String numStr = String.valueOf(num);
        char[] digits = numStr.toCharArray();
        int n = digits.length;

        // 1. Find the first digit from right which is smaller than digit to its right.
        int i;
        for (i = n - 2; i >= 0; i--) {
            if (digits[i] < digits[i + 1]) {
                break;
            }
        }

        // If no such digit found, then it is the last number
        if (i == -1) {
            return -1; // Indicate no next highest number
        }

        // 2. Find the smallest digit on right side of digit[i] which is greater than digits[i]
        int smallestGreater = i + 1;
        for (int j = i + 1; j < n; j++) {
            if (digits[j] > digits[i] && digits[j] <= digits[smallestGreater]) {
                smallestGreater = j;
            }
        }

        // 3. Swap the above found smallest digit with digit[i]
        swap(digits, i, smallestGreater);

        // 4. Sort the digits after position 'i' in ascending order
        Arrays.sort(digits, i + 1, n);

        try {
            return Integer.parseInt(new String(digits));
        } catch (NumberFormatException e) {
            return -1; // Handle potential overflow
        }
    }

    public static int findNextLowest(int num) {
        String numStr = String.valueOf(num);
        char[] digits = numStr.toCharArray();
        int n = digits.length;

        // 1. Find the first digit from right which is greater than digit to its right.
        int i;
        for (i = n - 2; i >= 0; i--) {
            if (i > 0 && digits[i] > digits[i + 1]) {
                break;
            }
        }

        // If no such digit found, then it is the smallest number
        if (i == -1) {
            return -1; // Indicate no next lowest number
        }

        // 2. Find the largest digit on right side of digit[i] which is smaller than digits[i]
        int largestSmaller = i + 1;
        for (int j = i + 1; j < n; j++) {
            if (digits[j] < digits[i] && digits[j] >= digits[largestSmaller]) {
                largestSmaller = j;
            }
        }

        // 3. Swap the above found largest digit with digit[i]
        swap(digits, i, largestSmaller);

        // 4. Sort the digits after position 'i' in descending order
        Arrays.sort(digits, i + 1, n);
        reverseSort(digits, i + 1, n);

        // Handle leading zeros
        if (digits[0] == '0') {
            return -1; // Or handle this case as needed
        }

        try {
            return Integer.parseInt(new String(digits));
        } catch (NumberFormatException e) {
            return -1; // Handle potential overflow
        }
    }

    private static void swap(char[] digits, int i, int j) {
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }

    private static void reverseSort(char[] digits, int start, int end) {
        for (int i = start, j = end - 1; i < j; i++, j--) {
            swap(digits, i, j);
        }
    }


}