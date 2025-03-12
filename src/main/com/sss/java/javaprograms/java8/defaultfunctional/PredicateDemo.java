package src.main.com.sss.java.javaprograms.java8.defaultfunctional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        integerList.stream().filter(i -> i % 2 == 0).forEach(System.out::println);
    }
}
