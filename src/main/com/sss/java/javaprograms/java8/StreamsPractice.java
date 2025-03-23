package src.main.com.sss.java.javaprograms.java8;

import java.util.*;

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
       /* String str = "Java Concept Of The Day".replaceAll("\\s","").toLowerCase();
     String s =Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting())).
                entrySet().stream().filter(entry -> entry.getValue()>1).map(Map.Entry::getKey).findFirst().orElse(null);
     System.out.print(s);*/

        int[] arr = {1, 4, 14, 5, 8, 45};
        System.out.print(threeSum(arr,13));
        threeSumInteger(arr,13);
            }
          /*  public static boolean twosum(int[] arr,int target){
            Set<Integer>   unique = new HashSet<>();
            for(int i=0; i<arr.length;i++){
                int complement =target- arr.length;
                if(unique.contains(complement))
                {
                     return true;
                }
                else{
                    unique.add(arr[i]);
                }
            }
            return false;
            }*/
    public static boolean threeSum(int[] num,int target){
        Arrays.sort(num);
        for(int i=0 ; i<num.length-1; i++){
            int first = i+1;
            int second = num.length-1;
            while(first<second){
                if(num[i]+num[first]+num[second] == target){
                    return true;
                }
                else if(num[i]+num[first]+num[second] < target){
                    first++;
                }
                else{
                    second--;
                }
            }

        }
       return false;
    }

    public static Object threeSumInteger(int[] num, int target){
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < num.length - 1; i++) {
            int first = i + 1;
            int second = num.length - 1;
            while (first < second) {
                if (num[i] + num[first] + num[second] == target) {
                    List<Integer> numList = new ArrayList<>();
                    List.of(num[i], num[first], num[second]);
                    result.add(numList);
                    System.out.print(result);
                    return result;

                } else if (num[i] + num[first] + num[second] < target) {
                    first++;
                } else {
                    second--;
                }
            }

        }
        return result;
    }




}
