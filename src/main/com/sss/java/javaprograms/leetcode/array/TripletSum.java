package src.main.com.sss.java.javaprograms.leetcode.array;

import java.util.Arrays;

public class TripletSum {
    public static void main(String[] args) {
        int[] arr = {1, 4, 14, 5, 8, 45};
        System.out.println(isTrippletExsist(arr, 54));
    }

    public static boolean isTrippletExsist(int[] arr, int target) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right) {
                if (arr[i] + arr[right] + arr[left] == target) {
                    return true;
                } else if (arr[i] + arr[right] + arr[left] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return false;
    }
}
