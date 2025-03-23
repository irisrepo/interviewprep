package src.main.com.sss.java.javaprograms.java8.mapflatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntegerPairSum {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(30, 15, 25, 10, 0, 30, 45);
        int targetSum = 45; // Example target sum, change as needed.

        List<String> pairs = findPairs(numbers, targetSum);

        if (pairs.isEmpty()) {
            System.out.println("No pairs found that sum to " + targetSum);
        } else {
            System.out.println("Pairs that sum to " + targetSum + ":");
            pairs.forEach(System.out::println);
        }
    }

    public static List<String> findPairs(List<Integer> numbers, int targetSum) {
        return numbers.stream()
                .flatMap(i -> numbers.stream()
                        .filter(j -> numbers.indexOf(j) > numbers.indexOf(i)) // Avoid duplicates and same element pairs
                        .filter(j -> i + j == targetSum)
                        .map(j -> "(" + i + ", " + j + ")"))
                .collect(Collectors.toList());
    }
}