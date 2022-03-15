package test;


        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.Collections;
        import java.util.Comparator;
        import java.util.List;
        import java.util.Map;
        import java.util.OptionalDouble;
        import java.util.stream.Collectors;
        import java.util.stream.Stream;


public class GroupAndMaxAndComparator {

    /*
     * static List<Employee> empList = Arrays.asList(new Employee("Tom",25), new
     * Employee("Jav",28), new Employee("Hello",32), new Employee("Hi",33), new
     * Employee("Harry",25), new Employee("Cal",28), new Employee("Jack",23), new
     * Employee("viv",32));
     */
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
        System.out.println("Before sort ");
        for (Employee emp :employeeList ) {
            System.out.println(emp.getEmpName()+"="+emp.getEmpAge());
        }

        // Collections.sort(employeeList,new Comparator<Employee>() {

        //@Override
        //public int compare(Employee o1, Employee o2) {
        // TODO Auto-generated method stub
        //return o1.getEmpAge()- o2.getEmpAge();
        //}

        //});

        System.out.println("After Sort ");
        for (Employee emp :employeeList ) {
            System.out.println(emp.getEmpName()+"="+emp.getEmpAge());
        }

        System.out.println("*********Lamda Java8 After Sort *********");
        employeeList.sort((Employee e1, Employee e2)->e1.getEmpAge()-e2.getEmpAge());
        employeeList.forEach((emp) -> System.out.println(emp.getEmpName()+"=="+emp.getEmpAge()));


        System.out.println("*********Lamda Java8 Number of employees with Same age******");
        Map<Integer, Long> cardsMap = employeeList
                .stream()
                .collect(Collectors.groupingBy(Employee::getEmpAge, Collectors.counting()));
        cardsMap.forEach((k,v)->System.out.println("Age: " + k + ", count: " + v));

        Map<Integer, Long> cardsMap1 = employeeList
                .stream().collect(Collectors.groupingBy(Employee::getEmpAge,Collectors.counting()));
        cardsMap1.forEach((k,v)->System.out.println("Age: " + k + ", count: " + v));

        //Find Employee salaries who are having more than 50k salary and add 10k hike to those employees.
        List<Integer> addIncrement =employeeList.stream().filter(e->e.getEmpAge() >30).map(e ->e.getEmpAge()+10).collect(Collectors.toList());
        System.out.println("processed list,addIncrement: " + addIncrement);



        System.out.println("****aggeragate operations****sum of emp age*****");

        double sumofAges=employeeList.stream().collect(Collectors.summingDouble(emp->emp.getEmpAge()));
        System.out.println("sumofAges=="+sumofAges);

        System.out.println("****aggeragate operations****min*****");
        Employee minAge=employeeList.stream().min((e1,e2)-> e1.getEmpAge()>e2.getEmpAge()?1:-1).get();
        System.out.println("MinAge=="+minAge.getEmpAge());

        Employee MaxAge=employeeList.stream().max((e1,e2)->e1.getEmpAge()>e2.getEmpAge()?1:-1).get();
        System.out.println("MaxAge=="+minAge.getEmpAge());

        long count=employeeList.stream().filter(emp->emp.getEmpAge()<30).count();
        System.out.println("count=="+count);

        double averageofAges=employeeList.stream().collect(Collectors.averagingDouble(emp->emp.getEmpAge()));
        System.out.println("sumofAges=="+averageofAges);

        // Write a Java 8 program to square the list of numbers and then filter out the numbers greater than 100 and then find the average of the remaining numbers?//

        Integer[] arr = new Integer[] { 100, 100, 9, 8, 200 };
        List<Integer> list = Arrays.asList(arr);
        // Stored the array as list
        OptionalDouble avg = list.stream().mapToInt(n -> n * n).filter(n -> n> 100).average();

	        /* Converted it into Stream and filtered out the numbers
	            which are greater than 100. Finally calculated the average
	        */

        if (avg.isPresent())
            System.out.println(avg.getAsDouble());





        Integer highest = Stream.of(1, 2, 3, 77, 6, 5)
                .max(Comparator.comparing(Integer::valueOf))
                .get();
        System.out.println("The highest number is: " + highest);
/* We have used max() method with Comparator.comparing() method
to compare and find the highest number
*/

        Integer lowest = Stream.of(1, 2, 3, 77, 6, 5)
                .min(Comparator.comparing(Integer::valueOf))
                .get();

/* We have used max() method with Comparator.comparing() method
to compare and find the highest number
*/


        System.out.println("The lowest number is: " + lowest);


        //You have given list of employees, find out all the employees whose designation is �Manager� and age is above 30.

        System.out.println("**********names of those employees whose age is more than 25 in java8 ***********");

        List<Employee> tempList = employeeList.stream()
                .filter(e ->  e.getEmpAge() > 25)
                .collect(Collectors.toList());


        tempList.forEach(e -> System.out.println("Names : " + e.getEmpName() + " , Age : " + e.getEmpAge()));

//	 Map<Integer, Long> cardsMap1 = employeeList
//	            .stream().filter(emp->emp.getEmpAge()>18)
//	            .map(emp->{
//	                  if(emp.getEmpName().equals(("dsfads")))
//	                		  {
//
//	                		  }
//	                  retun emp;
//	            }
//
//	            		)
//	            .collect(toMap(emp.getAge(), emp.getName()));
//
//	 ArrayList<employee> cardsMap1 = employeeList
//	            .stream().filter(emp->emp.getEmpAge()>18)
//	            .map(emp->{
//	                  if(emp.getEmpName().equals(("dsfads")))
//	                		  {
//
//	                		  }
//	            }
//
//	            		)
//	            .collect(Collectert.toList());
//

    }
}


