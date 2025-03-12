package src.main.com.sss.java.javaprograms.java8;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;




public class JavaConceptOftheday8 {
    public static void main(String[] args) {

        int[] nums1 = {2, 9, 7, 11, 15};
        int target1 = 18;
        int[] result1 = getIndexes(nums1, target1);
        System.out.println("Example 1: [" + result1[0] + ", " + result1[1] + "]"); // Output: [0, 1]


    }

    public static int[] getIndexes(int[] arr, int target) {

        Map<Integer, Integer> numIndex = new HashMap<>();
        System.out.println("target" + target);
        for (int i = 0; i < arr.length; i++) {

            int num = arr[i];

            int difference = target - num;

            System.out.println(numIndex.containsKey(difference));

            if (numIndex.containsKey(difference)) {


                return new int[]{numIndex.get(difference), i};
            }
            numIndex.put(num, i);

        }
        return new int[]{};
    }
}