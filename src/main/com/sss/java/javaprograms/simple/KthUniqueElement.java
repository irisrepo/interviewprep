package src.main.com.sss.java.javaprograms.simple;

import java.util.*;
import java.util.stream.Collectors;

public class KthUniqueElement {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        Integer sum = numbers.stream().mapToInt(e -> e*e).sum();
        System.out.println(sum);
    }
}
