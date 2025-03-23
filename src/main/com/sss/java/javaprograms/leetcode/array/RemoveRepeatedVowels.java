package src.main.com.sss.java.javaprograms.leetcode.array;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveRepeatedVowels {

    public static String removeRepeatedVowels(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        Set<Character> vowelsSeen = new LinkedHashSet<>();
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            char lowerC = Character.toLowerCase(c);

            if (lowerC == 'a' || lowerC == 'e' || lowerC == 'i' || lowerC == 'o' || lowerC == 'u') {
                if (vowelsSeen.add(lowerC)) { // Add the original character (preserving case)
                    result.append(lowerC);
                }
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String input3 = "AaEeIiOoUu";
        String result3 = removeRepeatedVowels(input3);
        System.out.println("Input: " + input3 + ", Output: " + result3);

        String input1 = "aaeiouu";
        String result1 = removeRepeatedVowels(input1);
        System.out.println("Input: " + input1 + ", Output: " + result1);

        String input2 = "Hellooo Worldd";
        String result2 = removeRepeatedVowels(input2);
        System.out.println("Input: " + input2 + ", Output: " + result2);

        String input4 = "This is a test sentence with repeated vowels.";
        String result4 = removeRepeatedVowels(input4);
        System.out.println("Input: " + input4 + ", Output: " + result4);

        String input5 = "programming";
        String result5 = removeRepeatedVowels(input5);
        System.out.println("Input: " + input5 + ", Output: " + result5);

    }
}