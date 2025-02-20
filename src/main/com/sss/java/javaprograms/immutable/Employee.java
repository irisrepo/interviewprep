package src.main.com.sss.java.javaprograms.immutable;

 class Employee {
    private final String name;
    private final int age;
    private final Address address;

     public Employee(String name, int age, Address address) {
         this.name = name;
         this.age = age;
         Address cloneAddress = new Address(address.getCity(),address.getState());
         this.address = cloneAddress;
     }

     public String getName() {
         return name;
     }

     public int getAge() {
         return age;
     }

     public Address getAddress() {
         return address;
     }

     @Override
     public String toString() {
         return "Employee{" +
                 "name='" + name + '\'' +
                 ", age=" + age +
                 ", address=" + address +
                 '}';
     }
 }
