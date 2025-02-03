package src.main.com.sss.java.javaprograms.java8;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeOperations {
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

        //3.1 : How many male and female employees are there in the organization?
        Map<String,Long> noofMaleandFemaleEmployees = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
        System.out.print("\nnoofMaleandFemaleEmployees:"+noofMaleandFemaleEmployees);

        // 3.2 : Print the name of all departments in the organization?
        employeeList.stream().map(emp ->emp.getDepartment()).distinct().collect(Collectors.toList()).forEach(System.out::println);

        //3.3 What is the average age of male and female employees?
        Map<String,Double> avgAgeMaleandFemaleEmployees = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getAge)));
        System.out.print("\navgAgeMaleandFemaleEmployees:"+avgAgeMaleandFemaleEmployees);

        //3.4 Get the details of highest paid employee in the organization?
        Optional<Employee> highestpaidEmployee = employeeList.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
        System.out.print("\nhighestpaidEmployee=="+highestpaidEmployee);

        //3.5 Get the names of all employees who have joined after 2015?
        employeeList.stream().filter(y->y.yearOfJoining > 2015).map(Employee::getName).collect(Collectors.toList()).forEach(System.out::println);

        //3.6 Count the number of employees in each department?
        Map<String,Long> countnoofEmployeesEachDept = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
        System.out.print("\ncountnoofEmployeesEachDept:"+countnoofEmployeesEachDept);

        //3.7 what is the avg sal of each dept?
        Map<String,Double> avgSalofEachDept = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
        System.out.print("\navgSalofEachDept:"+avgSalofEachDept);

        //3.8 Get the details of youngest male employee in the product development department?
        Optional<Employee> youngestMaleEmployeeInProductDevelopmentWrapper = employeeList.stream().filter(yo-> (yo.getDepartment() =="Product Development" && yo.getGender() =="Male")).
                min(Comparator.comparing(Employee::getAge));
        System.out.print("\nyoungest male employee:"+youngestMaleEmployeeInProductDevelopmentWrapper);

        //3.9 Who has the most working experience in the organization?
        Optional<Employee> mostworkingexperience = employeeList.stream().sorted(Comparator.comparing(Employee::getYearOfJoining)).findFirst();
        System.out.print("mostworkingexperience"+mostworkingexperience);



    }
}
