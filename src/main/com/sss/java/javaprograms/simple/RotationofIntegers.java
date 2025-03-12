package src.main.com.sss.java.javaprograms.simple;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RotationofIntegers {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 3, 2);
        Map<Integer, Long> mostRepeatedMap = numbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map.Entry<Integer,Long> entryMap = (Map.Entry<Integer, Long>) mostRepeatedMap.entrySet();


    }

}
