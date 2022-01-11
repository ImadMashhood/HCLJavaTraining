import java.util.*;

public class ArrayListMain {
    public static void main(String[] args) {
        //ArrayList
        ArrayList<Employee> list = new ArrayList<Employee>();
        list.add(new Employee(23132131,"Test Name 1","11/12/1998",23, 213131.31));
        list.add(new Employee(76575756,"Test Name 2","12/12/1967",32, 13131.31));
        list.add(new Employee(56776575,"Test Name 3","11/12/1932",64, 9131.31));
        list.add(new Employee(76576575,"Test Name 4","11/12/1998",51, 65131.31));
        list.add(new Employee(46545654,"Test Name 5","11/12/1967",53, 63131.31));
        list.add(new Employee(74656564,"Test Name 6","11/12/1965",26, 21531.31));
        list.add(new Employee(26577657,"Test Name 7","11/12/1997",34, 54331.31));
        list.add(new Employee(34532131,"Test Name 8","11/12/1988",23, 8131.31));
        list.add(new Employee(56572131,"Test Name 9","11/12/1986",23, 21131.31));
        list.add(new Employee(24564656,"Test Name 10","11/12/1975",24, 211213.31));

        System.out.println("Employees older than 30:\n------------------------");
        list.stream().filter(employee -> employee.getAge() > 30)
                        .forEach(employee -> System.out.println(employee.toString()+"\n------------------------"));
        System.out.println("\n\nEmployees between the age of 50 and 60:\n------------------------");
        list.stream().filter(employee -> employee.getAge() >= 50 && employee.getAge() <= 60)
                .forEach(employee -> System.out.println(employee.toString()+"\n------------------------"));
        System.out.println("\n\nEmployees salary higher than $10,000:\n------------------------");
        list.stream().filter(employee -> employee.getSalary() > 10000.00)
                .forEach(employee -> System.out.println(employee.toString()+"\n------------------------"));
    }
}
