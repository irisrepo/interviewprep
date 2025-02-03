package src.main.com.sss.java.javaprograms.java8;

import java.awt.desktop.SystemEventListener;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LamdaOperations {
    public static void main(String[] args) {

        //1. separate odd and even number
        List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);
        System.out.println("====Even numbers====");
        listOfIntegers.stream().filter(i -> i % 2 == 0).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("====odd numbers====");
        listOfIntegers.stream().filter(i -> i % 2 != 0).collect(Collectors.toList()).forEach(System.out::println);

        //2.emove duplicate elements
        List<String> listOfStrings2 = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
        listOfStrings2.stream().distinct().forEach(System.out::println);

        //3.frequency of each character in a string using Java 8 streams
        String inputString = "Java Concept Of The Day";
        Map<String, Long> frequencyOfEachCharacter = Arrays.stream(inputString.replaceAll("\\s+", "").split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> frequencyOfEachCharacterCaseSensitive = Arrays.stream(inputString.replaceAll("\\s+", "").toUpperCase().split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("frequencyOfEachCharacter==" + frequencyOfEachCharacter);
        //System.out.println("frequencyOfEachCharacterCaseSensitive=="+frequencyOfEachCharacterCaseSensitive);

        //4.frequency of each element in an array or a list
        List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil");
        Map<String, Long> frequencyEachElement = stationeryList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //System.out.println("frequencyEachElement"+frequencyEachElement);
        //5.reverse the elements
        List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);
        decimalList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        //6.join the strings with ‘[‘ as prefix, ‘]’ as suffix and ‘,’ as delimiter?
        List<String> listOfStrings3 = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");
        String joinedString = listOfStrings3.stream().collect(Collectors.joining(",", "[", "]"));
        System.out.println("joinedString" + joinedString);

        //7.print the numbers which are multiples of 5
        List<Integer> listOfIntegersMultiplesof5 = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        //listOfIntegersMultiplesof5.stream().filter(i -> i % 5 == 0).forEach(System.out::println);

        //8.find maximum and minimum of those numbers
        int max = listOfIntegersMultiplesof5.stream().max(Comparator.naturalOrder()).get();
        int min = listOfIntegersMultiplesof5.stream().min(Comparator.naturalOrder()).get();
        System.out.println("max:" + max + "min:" + min);

        //9.merge two unsorted arrays into single sorted array using Java 8 streams
        int[] a = new int[]{4, 2, 7, 1};
        int[] b = new int[]{8, 3, 9, 5};
        int[] c = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().toArray();
        System.out.println("Merged sorted array" + Arrays.toString(c));

        //10.two unsorted arrays into single sorted array without duplicates
        int[] d = new int[]{4, 2, 5, 1};
        int[] e = new int[]{8, 1, 9, 5};

        int[] f = IntStream.concat(Arrays.stream(d), Arrays.stream(e)).distinct().sorted().toArray();
        System.out.println("SingleSorted Array without duplicates" + Arrays.toString(f));

        //11.get three maximum numbers and three minimum numbers from the given list of integers
        List<Integer> listOfIntegers4 = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        System.out.print("First 3 max numbers===========");
        listOfIntegers4.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);
        System.out.print("First 3 minimum numbers===");
        listOfIntegers4.stream().sorted(Comparator.naturalOrder()).limit(3).forEach(System.out::println);

        //12.check if two strings are anagrams or not
        String s1 = "racecar";
        String s2 = "carrace";
        s1 = Arrays.stream(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
        s2 = Arrays.stream(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
        if (s1.equals(s2)) {
            System.out.print("Anagrams");
        } else {
            System.out.print("Not Anagrams");
        }
        //13. all digits of a number in Java 8
        int i = 15623;
        int sum = Arrays.stream(String.valueOf(i).split("")).collect(Collectors.summingInt(Integer::parseInt));
        System.out.print("All digits of a number: " + sum);

        //14.second largest number in an integer array
        List<Integer> listOfIntegers5 = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        int secondLargest = listOfIntegers5.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.print("\n second largetst: " + secondLargest);

        //15.sort them according to increasing order of their length
        List<String> listOfStrings6 = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
        listOfStrings6.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);

        //16.integer array, find sum and average of all elements
        int[] g = new int[]{45, 12, 56, 15, 24, 75, 31, 89};
        int sumofelements = Arrays.stream(g).sum();
        double avg = Arrays.stream(g).average().getAsDouble();
        System.out.print("sumofelements:" + sumofelements + "Avg:" + avg);

        //17.find common elements between two arrays
        List<Integer> list1 = Arrays.asList(71, 21, 34, 89, 56, 28);
        List<Integer> list2 = Arrays.asList(12, 56, 17, 21, 94, 34);
        list1.stream().filter(list2::contains).forEach(System.out::println);
        //18. Reverse each word of a string using Java 8 streams
        String str = "Java Concept Of The Day";
        String reverseString = Arrays.stream(str.split(" "))
                .map(word -> new StringBuffer(word).reverse())
                .collect(Collectors.joining(" "));
        System.out.print("reversedString: " + reverseString);

        //19.sum of first 10 natural numbers
        int sumoffirst = IntStream.range(1, 11).sum();
        System.out.print("sum of first 10 natural numbers" + sumoffirst);

        //20.reverse an integet Array
        int[] array = new int[]{5, 1, 7, 3, 9, 6};
        int[] reverseArray = IntStream.rangeClosed(1, array.length).map(arrr -> array[array.length - arrr]).toArray();
        System.out.print(Arrays.toString(reverseArray));

        //21.Print first 10 even numbers
        IntStream.range(1, 11).filter(num -> num % 2 == 0).forEach(System.out::println);

        //22.find the most repeated element in an array
        List<String> listOfStrings7 = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book", "Pencil");
        Map<String, Long> repeatedElementMap = listOfStrings7.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map.Entry<String, Long> repeatedElement = repeatedElementMap.entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.print("most repeated elemnt" + repeatedElement);

        //23.Palindrome program using Java 8 stream
        String palindrome = "madam";
        boolean isPlaindromee = IntStream.range(0, palindrome.length() / 2).
                noneMatch(k -> palindrome.charAt(k) != palindrome.charAt(palindrome.length() - k - 1));
        if (isPlaindromee) {
            System.out.print("Palindrome===");
        } else {
            System.out.print("Not palindrome---");
        }

        //24. Given a list of strings, find out those strings which start with a number
        List<String> listOfStrings8 = Arrays.asList("One", "2wo", "3hree", "Four", "5ive", "Six");
        listOfStrings8.stream().filter(n -> Character.isDigit(n.charAt(0))).forEach(System.out::println);

        //25.extract duplicate elements from an array
        List<Integer> listOfIntegers9 = Arrays.asList(111, 222, 333, 111, 555, 333, 777, 222);
        Set<Integer> uniqueElements = new HashSet<>();
        Set<Integer> extractedEleemnts = listOfIntegers9.stream().filter(o -> !uniqueElements.add(o)).collect(Collectors.toSet());
        System.out.print("extractedEleemnts" + extractedEleemnts);

        //26.first repeacted characters in string
        String instr = "java concept of the day".replaceAll("\\s+", "");
        Map<String, Long> mostrepeatedcharacters = Arrays.stream(instr.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        String firstRepeatedChar = mostrepeatedcharacters.entrySet().stream().filter(entry -> entry.getValue() > 1).map(entry -> entry.getKey()).findFirst()
                .get();
        System.out.print("firstRepeatedChar====" + firstRepeatedChar);

        //27.print duplicate characters in the string
        mostrepeatedcharacters.entrySet().stream().filter(entry -> entry.getValue() > 1).map(entry -> entry.getKey()).collect(Collectors.toList()).forEach(System.out::println);

        //28.finanoci series
        Stream.iterate(new int[]{1, 3}, u -> new int[]{u[1], u[1] + 2}).limit(10).map(u -> u[0]).forEach(p -> System.out.print(p + " "));

        //29.last element of the array
        List<String> listOfStrings10 = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six");
        String lastelementofString = listOfStrings10.stream().skip(listOfStrings10.size() - 1).findFirst().get();
        System.out.print(lastelementofString);


    }
}





