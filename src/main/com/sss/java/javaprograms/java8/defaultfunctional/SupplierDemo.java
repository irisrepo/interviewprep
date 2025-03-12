package src.main.com.sss.java.javaprograms.java8.defaultfunctional;

import javax.xml.transform.stream.StreamSource;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierDemo  {

    public static void main(String[] args) {
        Supplier<String> supplier = () ->"Hi Techie";
       // System.out.println("supplier info:"+supplier.get());
        List<String> stringList = Arrays.asList();
        System.out.println(stringList.stream().findAny().orElseGet(supplier));
    }

}
