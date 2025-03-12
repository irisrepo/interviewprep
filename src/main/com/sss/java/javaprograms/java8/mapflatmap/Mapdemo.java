package src.main.com.sss.java.javaprograms.java8.mapflatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Mapdemo {
    public static List<Customer> getAll() {
        return Stream.of(
                new Customer(101, "john", "john@gmail.com", Arrays.asList("9839779379", "741654725")),
                new Customer(102, "smith", "smith@gmail.com", Arrays.asList("895663865", "7487238947")),
                new Customer(103, "peter", "peter@gmail.com", Arrays.asList("7894628654", "6286487236")),
                new Customer(104, "kely", "kely@gmail.com", Arrays.asList("8924682934", "9486094667"))
        ).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Customer> customerList = getAll();
        //Using Map
        List<List<String>> phonenumbersmap = customerList.stream().map(Customer::getPhoneNumbers).collect(Collectors.toList());
        System.out.println(phonenumbersmap);

        //USing FlatMAp
        List<String> phonenumbers = customerList.stream().flatMap(Customer -> Customer.getPhoneNumbers().stream()).collect(Collectors.toList());
        System.out.println(phonenumbers);





    }
}
