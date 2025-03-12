package src.main.com.sss.java.javaprograms.java8.defaultfunctional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo  {
    public static void main(String[] args) {
        /*Consumer<Integer> consumer = t -> System.out.println("Print " + t);
        consumer.accept(10);*/

        List<Integer> integerList = Arrays.asList(1,2,3,4,5);
        integerList.forEach(t->System.out.println("Print:"+t));
    }
}
