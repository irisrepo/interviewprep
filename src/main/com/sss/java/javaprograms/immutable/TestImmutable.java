package src.main.com.sss.java.javaprograms.immutable;

public class TestImmutable {
    public static void main(String[] args) {
        Address address = new Address("Hyderabad","Telangana");
        Employee employee = new Employee("Suresh",39,address);
        System.out.println("Original object\n"+employee);
        address.setCity("Mumbai");
        address.setState("Maharstra");
        System.out.println("Modify  object\n"+employee);
    }
}
