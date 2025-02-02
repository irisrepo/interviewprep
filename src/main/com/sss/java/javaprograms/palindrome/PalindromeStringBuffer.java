package com.sss.java.javaprograms.palindrome;

import java.util.Scanner;

public class PalindromeStringBuffer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter input string");
        String inputString = sc.nextLine().replaceAll("\\s+", "");
        String reverseString = new StringBuffer(inputString).reverse().toString();
        if (inputString.equals(reverseString)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palinddrome");
        }
    }
}
