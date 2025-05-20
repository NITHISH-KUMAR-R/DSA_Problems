package dsa.steram;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamAPI {

    public static  void main(String a[]){

        List<Integer> list = new ArrayList<>();
        for(int i =0;i<10;i++){
            list.add(i);
        }
        Integer largest = list.stream().sorted(Comparator.reverseOrder()).findFirst().get();
        System.out.println("Largest: " +largest);

        Integer smallest = list.stream().sorted().findFirst().get();
        System.out.println("smallest: " + smallest);

        Optional<Integer> secondHighest = list.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();
       secondHighest.ifPresentOrElse(value-> System.out.println("Second Highest "+value),
               ()-> System.out.println("Not present"));

        Map<String, Double> map= new HashMap<>();
        map.put("nithish",50000.00);
        map.put("dinesh",45000.00);
        map.put("soundari",60000.00);
        map.put("ramasamy",45000.00);
        map.put("dharun",69000.00);

        Map<Double , List<String>> groupBysalary =  map.entrySet().stream()
                .collect(
                        Collectors.groupingBy(
                                Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey,Collectors.toList()
                        )
                        ));

        System.out.println(groupBysalary);

        List<String>  salaryGreaterThan50k =  map.entrySet().stream()
                .filter(v-> v.getValue()>50000.00)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("salaryGreaterThan50k: " +salaryGreaterThan50k);

        //.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        String  seconHighest =  map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).skip(1)
                .map(Map.Entry::getKey).findFirst().orElse("Not found");


        Employee obj = new Employee("Nithish",25,50000.00);
        Employee ob5 = new Employee("nicokle",75,50000.00);
        Employee ob2 = new Employee("Sobiya",24,70000.00);
        Employee ob3 = new Employee("Dinesh",27,80000.00);
        Employee ob4 = new Employee("Ramasamy",55,45000.00);
        List<Employee> employees = new ArrayList<>();
        employees.add(obj);
        employees.add(ob2);
        employees.add(ob3);
        employees.add(ob4);
        employees.add(ob5);


        List<String> salarylowToHigh = employees.stream().
                sorted(Comparator.comparingDouble(Employee::getSalary))
                .map(Employee::getName).collect(Collectors.toList());

        System.out.println("salarylowToHigh: "+salarylowToHigh);

        List<String> secondHighestSalary = employees.stream().
                sorted(Comparator.comparingDouble(Employee::getSalary).reversed())

                .skip(1)
                .limit(1)
                .map(Employee::getName).collect(Collectors.toList());

        System.out.println("secondHighestSalary: "+secondHighestSalary);


        List<String> startsWithNEldest = employees.stream()
                // Filter names starting with 'n' or 'N'
                .filter(e -> e.getName().toLowerCase().startsWith("n"))
                // Find max age among filtered employees
                .collect(Collectors.groupingBy(Employee::getAge))
                .entrySet().stream()
                .max(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .stream()
                .flatMap(List::stream)
                .map(Employee::getName)
                .collect(Collectors.toList());


        List<Employee> eldestandStartsWith = employees.stream()
                        .filter(s->s.getName().toLowerCase().startsWith("n"))
                .collect(Collectors.toList());

        OptionalInt maxAge = eldestandStartsWith.stream().mapToInt(e->e.getAge())
                        .max();

        List<String> finalCheck = eldestandStartsWith.stream()
                        .filter(e-> maxAge.isPresent() && e.getAge()==maxAge.getAsInt())
                                .map(e->e.getName()).collect(Collectors.toList());


        System.out.println(startsWithNEldest);



        System.out.println("eldestandStartsWith: "+eldestandStartsWith);


        System.out.println("startsWithNandEldestAge "+finalCheck);

//        Optional<LocalDate> latestDOB = employees.stream()
//                .map(Employee::getDob)
//                .max(LocalDate::compareTo);
//
//        List<Employee> youngestEmployees = employees.stream()
//                .filter(e -> latestDOB.isPresent() && e.getDob().equals(latestDOB.get()))
//                .collect(Collectors.toList());
















    }
}
