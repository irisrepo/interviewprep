package src.main.com.sss.java.javaprograms.simple;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveNthLargest {
    public static void main(String[] args) {
        List<Integer> elementsList = new ArrayList<>(Arrays.asList(99,345,2,12,24,275));
        removeNthElement(elementsList,1);
        System.out.println(elementsList);
    }

    public static void removeNthElement(List<Integer> integerList, int n){
         System.out.println(integerList);
        if(n<=0 || n> integerList.size()){
            System.out.println("Invalid value of N.");
        };
        List<Integer> sortedList = new ArrayList<>();
        integerList.stream().sorted(Comparator.reverseOrder()).map(e -> sortedList.add(e)).collect(Collectors.toList());
        System.out.println(sortedList);

        Integer nthElement = sortedList.get(n-1);
        System.out.println(nthElement);
        integerList.remove(nthElement);

    }
}
