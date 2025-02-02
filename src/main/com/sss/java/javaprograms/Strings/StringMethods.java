package src.main.com.sss.java.javaprograms.Strings;

import java.util.Arrays;
import java.util.stream.Collectors;


public class StringMethods {
    public static void main(String[] args) {
       /* Scanner  sc  = new Scanner(System.in);
        System.out.println("Enter String");
        String inputString = sc.nextLine().replaceAll("\\s+","");
        System.out.println(inputString);*/

        //2)charAt(int index)
        // Description: Returns the character at the specified index.
        String str = "Hello, World!";
        char ch = str.charAt(2);
        System.out.println("Character is--->" + ch);
        //3. substring(int beginIndex)
        //Description: Returns a substring starting from the specified index to the end of the string.

        String sub = str.substring(7); // sub = "World!
        str.replaceAll("\\s+", "");
        System.out.println("String is--->" + str + "<--postion substring  7-->" + str.substring(7));
        // System.out.println("rattation based ==="+indexPositionCharacter("Helloworld",1));
        //System.out.println("count of vowels"+countVowels("HelloWorld"));
        System.out.println("remove duplicates from string-->"+ removeDuplicates("amaravathi"));


    }

    //input ={"Helloworld" ,3) output =rldHellowo
    public static String indexPositionCharacter(String input, int rotation) {
        String part1 = input.substring(input.length() - rotation);
        String part2 = input.substring(0, input.length() - rotation);
        String finalString = part1.concat(part2);
        return finalString;
    }

    public static long countVowels(String str) {
        long count = Arrays.stream(str.split("")).filter(c -> "aeiouAEIOU".indexOf(c) != -1).collect(Collectors.toList()).stream().count();
        return count;
    }

    public static String removeDuplicates(String str) {
        String fianlString = Arrays.stream(str.split("")).distinct().collect(Collectors.joining());
        return fianlString;
    }

}
