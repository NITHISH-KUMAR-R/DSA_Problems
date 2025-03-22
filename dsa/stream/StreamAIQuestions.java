package dsa.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamAIQuestions {
    public static void main(String[] args) {
        //Convert a list of integers to a list of their squares using Stream API.

        List<Integer> list = List.of(1, 2, 3, 4, 5);

        List<Integer> squaresList = list.stream().map(a -> a * a).collect(Collectors.toUnmodifiableList());
        System.out.println("List of Squares: " + squaresList);

        // Given a list of strings, filter out the ones that start with the letter "A".
        List<String> listNames = List.of("Nithish", "Apple", "amma", "Annai", "Anna", "amma", "Annai", "Anna", "Sobiya", "Ramasamy");

        List<String> startsWithA = listNames.stream().filter(a -> a.toUpperCase().startsWith("A")).collect(Collectors.toList());
        System.out.println("startsWithA: " + startsWithA);

        //Count the number of elements in a list that are greater than 50.

        List<Integer> numbers = List.of(1, 2, 3, 50, 45, 56, 78, 9, 88, 56, 34, 59);

        List<Integer> greaterThan50 = numbers.stream().filter(a -> a > 50).collect(Collectors.toUnmodifiableList());
        System.out.println("greaterThan50: " + greaterThan50);
        //Find the maximum and minimum value from a list of integers using Stream API.

        Optional<Integer> maximum = numbers.stream().max(Integer::compareTo);
        Optional<Integer> minimum = numbers.stream().min(Integer::compareTo);

        //  List<Integer>  maxAndMinimum = numbers.stream().sorted();

        System.out.println("maximum: " + maximum);
        System.out.println("minimun: " + minimum);
        //Convert a list of strings to uppercase using Stream API.
        List<String> upperCase = listNames.stream().map(a -> a.toUpperCase()).collect(Collectors.toList());
        System.out.println("Upper Case: " + upperCase);


        List<Employee> listOfEmployees = List.of(
                new Employee("Nithish", 50000.00),
                new Employee("Selvamani", 55000.00),
                new Employee("Ramasamy", 45000.00),
                new Employee("Soundari", 100000.00),
                new Employee("Kumar", 14000.00),
                new Employee("Anbu", 1000.00));

        List<String> employeesNameSalaryGreaterThan50k = listOfEmployees.stream().filter(a -> a.getSalary() >= 50000.00).map(a -> a.getName()).collect(Collectors.toUnmodifiableList());

        System.out.println("GreaterThan50: " + employeesNameSalaryGreaterThan50k);


        //Sort a list of employees by salary in descending order.
        List<Employee> salaryDesc = listOfEmployees.stream().sorted((a, b) -> (int) (b.getSalary() - a.getSalary())).collect(Collectors.toList());
        //Sort a list of employees by salary in descending order.
        List<Employee> salaryDesc2 = listOfEmployees.stream().sorted((a, b) -> Double.compare(b.getSalary(), a.getSalary())).collect(Collectors.toList());
        System.out.println("Salary Desc: " + salaryDesc);
        System.out.println("Salary Desc: " + salaryDesc2);

        //Find the second highest salary from a list of employees.
        List<Employee> secondHighestSalary = listOfEmployees.stream().sorted((a, b) -> Double.compare(b.getSalary(), a.getSalary())).skip(1).limit(1).collect(Collectors.toUnmodifiableList());
        System.out.println("secondHighestSalary: " + secondHighestSalary);

        List<Employee> top3HighestSalary = listOfEmployees.stream().sorted((a, b) -> Double.compare(b.getSalary(), a.getSalary())).limit(3).collect(Collectors.toUnmodifiableList());
        System.out.println("top3HighestSalary: " + top3HighestSalary);


        Set<String> distinctNames = listNames.stream().collect(Collectors.toCollection(HashSet::new));
        System.out.println("distinctNames: " + distinctNames);

        Map<Boolean, List<Employee>> employeePartition = listOfEmployees.stream().collect(Collectors.partitioningBy(e -> e.getSalary() > 20000.00));

        List<Employee> moreThan20K = employeePartition.get(true);
        List<Employee> lessThan10K = employeePartition.get(false);

        System.out.println("moreThan20K: " + moreThan20K);
        System.out.println("lessThan20K: " + lessThan10K);

        List<String> sortsAplahabetically = listNames.stream().map(e -> e.toUpperCase()).sorted().collect(Collectors.toUnmodifiableList());
        System.out.println("sortsAplahabetically:" + sortsAplahabetically);

        Optional<String> longestName = listNames.stream().max(Comparator.comparingInt(String::length));
        System.out.println("Longest Name: " + longestName);

        Double averageSalary = listOfEmployees.stream().mapToDouble(Employee::getSalary).average().orElse(0);
        System.out.println(averageSalary);

        Map<String, Long> frequencyofEachWord = listNames.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Character, Long> eachCharCount = listNames.stream()
                .flatMap(s -> s.chars().mapToObj(c -> (char) c))
                .map(Character::toUpperCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("frequencyofEachWord: " + frequencyofEachWord);
        System.out.println("eachCharCount: " + eachCharCount);

        String  sentence = "hiusdisajbisdcobhsoc bsdcsabhsdpc sijdcod snisdcjodc sjosdio";
        Map<Character,Long> countOccurencesInString= sentence.chars()
                .filter(c -> !Character.isWhitespace(c))  // Ignore spaces
                .mapToObj(c-> (char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        System.out.println("CountOccurencesInString: "+countOccurencesInString);

        //Group employees by their department and count how many employees are in each department.


    }
}
