package src.main.com.sss.java.javaprograms.java8;

import java.lang.reflect.AnnotatedType;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Practice {

    public static String rotate(String str,int rotator){
        String s1  = str.substring(str.length() -rotator);
        System.out.print(s1);
        String s2 = str.substring(0,str.length()-rotator);
        String roatatorString = s1.concat(s2);
        return roatatorString;
    }
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        // 1. How many male and female employees are there in the organization?
        Map<String,Long> maleandFemaleEmployees = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
        //System.out.print(maleandFemaleEmployees);
        // 2. What are the names of all departments in the organization?
        employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
        // 3. What is the average age of male and female employees?
        Map<String, Double> averagemaleandFemaleEmployees = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getAge)));
         //System.out.print(averagemaleandFemaleEmployees);
        // 4. What are the details of the highest-paid employee in the organization?
       Optional<Employee> higestpaidEmployee = Optional.of(employeeList.stream().max(Comparator.comparingDouble(Employee::getSalary)).get());
        // 5. What are the names of all employees who have joined after 2015?
        employeeList.stream().filter(e -> e.yearOfJoining >2015).map(Employee::getName).forEach(System.out::println);
        // 6. How many employees are there in each department?
        Map<String,Long> countmaleandFemaleEmployees = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
        //System.out.print(countmaleandFemaleEmployees);
        // 7. What is the average salary of each department?
        Map<String, Double> averageSalmaleandFemaleEmployees = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getAge)));
        //System.out.print(averageSalmaleandFemaleEmployees);
        // 8. What are the details of the youngest male employee in the product development department?
        Optional<Employee> youngestEmployee = Optional.of(employeeList.stream().min(Comparator.comparing(Employee::getAge)).get());
        //System.out.print(youngestEmployee.get().getName());

       // Get the details of youngest male employee in the product development department?
        Optional<Employee> youngestEmployeeinDevelopementDepartment = Optional.of(employeeList.stream().filter(e -> e.getDepartment() == "Product Development" && e.getGender() == "Male").min(Comparator.comparing(Employee::getAge)).get());
        //System.out.print(youngestEmployeeinDevelopementDepartment.get().getName());
        // 9. Who has the most working experience in the organization?
        Optional<Employee> mostWorkingExp = Optional.of(employeeList.stream().min(Comparator.comparingDouble(Employee::getYearOfJoining)).get());
        //System.out.print("mostWorkingExp==="+mostWorkingExp.get().getName());
        //10.: How many male and female employees are there in the sales and marketing team?

        


    }



}