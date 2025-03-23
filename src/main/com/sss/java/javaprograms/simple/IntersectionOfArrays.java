package src.main.com.sss.java.javaprograms.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntersectionOfArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 1, 3};
        int[] arr2 = {2, 2, 3, 4};

        List<Integer> list1 = Arrays.stream(arr1).boxed().collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(arr2).boxed().collect(Collectors.toList());
        list1.stream().filter(list2::contains).distinct().collect(Collectors.toList()).forEach(System.out::println);


    }
}
