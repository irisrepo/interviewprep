package src.main.com.sss.java.javaprograms.java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsPractice {
    public static void main(String[] args) {

   /*    //first 3 elements
      int[] num = {1,2,1,3,3,4,4,4,5,6,6};
      Set<Integer> unique = new HashSet<>();
      Arrays.stream(num).boxed().filter(nums -> !unique.add(nums)).limit(3).forEach(System.out::println);*/

      //Duplicate characters
   /*     String str = "Java Concept Of The Day".replaceAll("\\s","").toLowerCase();

        Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).
                entrySet().stream().filter(entry -> entry.getValue()>1).map(Map.Entry::getKey).forEach(System.out::println);*/

        //first nonrepeated character
        String str = "Java Concept Of The Day".replaceAll("\\s","").toLowerCase();
     String s =Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting())).
                entrySet().stream().filter(entry -> entry.getValue()>1).map(Map.Entry::getKey).findFirst().orElse(null);
     System.out.print(s);


    }
}
