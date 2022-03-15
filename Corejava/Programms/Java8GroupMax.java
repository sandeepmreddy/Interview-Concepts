package test;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Java8GroupMax {

    private static List<Employee> getEmployees(){
        List<Employee> empList = new ArrayList<Employee>();
        empList.add(new Employee("tom",25));
        empList.add(new Employee("Hi",29));
        empList.add(new Employee("Hope",36));
        empList.add(new Employee("mike",32));
        empList.add(new Employee("Joy",29));
        empList.add(new Employee("Happy",26));
        empList.add(new Employee("Meave",40));
        empList.add(new Employee("Yes",25));

        return empList;
    }

    public static void main(String[] args) {
        List<Employee> employeeList = getEmployees();

        Map<Integer,Long> map = employeeList.stream().collect(Collectors.groupingBy(Employee::getEmpAge,Collectors.counting()));

        //Grouping on multiple fields
        Map<String, Map<Integer, Long>> multipleFieldsMap1 = employeeList.stream()
                .collect(
                        Collectors.groupingBy(Employee::getEmpName,
                                Collectors.groupingBy(Employee::getEmpAge,
                                        Collectors.counting())));

        //Compare by first name and then age
        Comparator<Employee> compareByName = Comparator
                .comparing(Employee::getEmpName)
                .thenComparing(Employee::getEmpAge);

        List<Employee> sortedEmployees = employeeList.stream()
                .sorted(compareByName)
                .collect(Collectors.toList());


        employeeList.sort((Employee e1,Employee e2)->e1.getEmpAge()-e2.getEmpAge());

        Employee e=employeeList.stream().max((Employee e1,Employee e2)->e1.getEmpAge()-e2.getEmpAge()).get();

        Employee e0=employeeList.stream().max((Employee e1,Employee e2)->e1.getEmpAge()>e2.getEmpAge()?1:-1).get();

        Double d =employeeList.stream().collect(Collectors.summingDouble(Employee::getEmpAge));

        Double d1 =employeeList.stream().collect(Collectors.averagingDouble(Employee::getEmpAge));

        int[] integers = new int[] { 20, 98, 12, 7, 35 };

        Arrays.sort(integers);

        Arrays.stream(integers).max();

        Arrays.stream(integers).max().getAsInt();

        Stream.of(20, 98, 12, 7, 35).max(Comparator.comparing(Integer::valueOf)).get();

        Stream.of(20, 98, 12, 7, 35).max(Comparator.comparing(Integer::valueOf)).orElseThrow(NoSuchElementException::new);

    }

}


