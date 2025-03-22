package dsa.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8 {
    public static void main(String[] args) {

        List<Employee>  employees = Arrays.asList(
                new Employee("Nithish",50000.00),
                new Employee("harini",10000.00),
                new Employee("harini",10400.00),
                new Employee("Kishore",30000.00),
        new Employee("Kishore",40000.00)
        );

        Double salaryHigh = employees.stream().mapToDouble(Employee::getSalary).max().orElse(0.00);
        System.out.println(salaryHigh);

        Optional<Employee> highSalary = employees.stream().max(Comparator.comparing(Employee::getSalary));
        System.out.println(highSalary);

        int maxLength = employees.stream().mapToInt(e-> e.getName().length()).max().orElse(0);

        List<Employee> getTwoHighSalaries = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(2).collect(Collectors.toList());
        System.out.println(getTwoHighSalaries);

        String longestName = employees.stream().map(e->e.getName()).filter(e-> e.length() == maxLength).findFirst().orElse("Not Found");
        System.out.println(longestName);
        Map<String,Double> salaryGreaterThan20LessThan40 = employees.stream().filter(m-> m.getSalary() > 30000.00).filter(m-> m.getSalary()<45000.00).collect(Collectors.toMap(Employee::getName,Employee::getSalary));
        Double totalEmployeesSalary = employees.stream().map(m-> m.getSalary()).reduce(0.0,Double::sum);
        System.out.println("Total Emp Salary: "+totalEmployeesSalary);


        System.out.println("salaryGreaterThan20LessThan40" + salaryGreaterThan20LessThan40);

        List<String>  firstUpperCase = employees.stream().map(m-> m.getName().substring(0,1).toUpperCase()+m.getName().substring(1).toLowerCase()).collect(Collectors.toList());

        System.out.println("Naming Upper case and lower case: "+firstUpperCase);

        employees.stream().forEach(emp->{
                    System.out.println("Emp Name: "+emp.getName()+ " "+"Salary:"+emp.getSalary());
        });
        //Map<String, Double> eachSalary =     employees.stream().collect(Collectors.toMap(Employee::getName,Employee::getSalary));
       // System.out.println(eachSalary);
        //Remove Duplicate Key

//        Map<String,Double> duplicateNameRemoval = employees.stream().collect(Collectors.groupingBy(Employee::getName,Employee::getSalary));
        Map<String,Double> duplicateNameRemoval = employees.stream().collect(Collectors.toMap(Employee::getName,Employee::getSalary,(e,r)-> e));

        System.out.println(duplicateNameRemoval);
        Map<String,Double> highestSalaryIfDuplicatePresent = employees.stream().collect(Collectors.toMap(Employee::getName,Employee::getSalary,Math::max));
        System.out.println(highestSalaryIfDuplicatePresent);

        Map<String, Double> employeeSalaryMap = new HashMap<>();
        employeeSalaryMap.put("Alice", 48000.0);
        employeeSalaryMap.put("Bob", 55000.0);
        employeeSalaryMap.put("Charlie", 72000.0);
        employeeSalaryMap.put("David", 45000.0);
        employeeSalaryMap.put("Emma", 60000.0);
        employeeSalaryMap.put("Emma", 60000.0);
        employeeSalaryMap.put("David", 60000.0);
//        Double totalEmployeesSalary2 = employees.stream().map(e->e.getSalary()).
//                reduce(0.0,Employee::getSalary);


        Map<String,Double> salaryGreaterThan50k = employeeSalaryMap.entrySet().stream().filter(e->e.getValue() > 50000.00)
                .collect(Collectors.toMap(e->e.getKey(),e->e.getValue()));


        System.out.println(salaryGreaterThan50k);

        Map<String,Long> countingEmp =employeeSalaryMap.entrySet().stream().collect(Collectors.groupingBy(e->e.getKey(),Collectors.counting()));
        System.out.println(countingEmp);
        List<String> employCount = Arrays.asList("Alice", "Bob", "Charlie", "Alice", "Bob", "Alice");

        Map<String,Long> count = employCount.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(count);



    }

}
