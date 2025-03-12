package src.main.com.sss.java.javaprograms.simple;

import java.util.*;

public class RemoveNsmallElement {
    public static void main(String[] args) {
        List<Integer> elementsList = new ArrayList<>(Arrays.asList(99,345,2,12,24,275));
        removeNthElement(elementsList,3);
        System.out.println(elementsList);
    }

    public static void removeNthElement(List<Integer> integerList, int n){

        if(n<=0 || n> integerList.size()){
            System.out.println("Invalid value of N.");
        };
        List<Integer> sortedList = new ArrayList<>(integerList);
        Collections.sort(sortedList);
        System.out.println(sortedList);

        Integer nthElement = sortedList.get(n-1);
        System.out.println(nthElement);
        integerList.remove(nthElement);

    }
}
