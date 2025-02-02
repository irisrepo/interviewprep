package com.sss.java.javaprograms.palindrome;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Palindromejava8 {
    public static void main(String[] args) {
        //palindrome
        Scanner sc = new Scanner(System.in);
        String inputString = sc.next().replaceAll("\\s+", "");
        boolean isPalindrome = IntStream.range(0, inputString.length() / 2)
                .peek(i -> System.out.println("Checking index: " + i)) // Peek 2: Current index
                .peek(i -> System.out.println("Comparing: " + inputString.charAt(i) + " and " + inputString.charAt(inputString.length() - i - 1))) // Peek 3: Characters being compared
                .noneMatch(i -> inputString.charAt(i) != inputString.charAt(inputString.length() - i - 1));
        System.out.println(" is palindrome ===" + isPalindrome);
    }

}
