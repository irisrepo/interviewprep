package src.main.com.sss.java.javaprograms.java8;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Practice {
    public static void main(String[] args) {
        String str ="Helloworld";
        Map<Character ,Long> frequencyofword = str.chars().mapToObj(c ->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("frequencyofword"+frequencyofword);

    }
}
