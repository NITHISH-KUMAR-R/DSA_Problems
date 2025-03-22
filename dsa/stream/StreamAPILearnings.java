package dsa.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAPILearnings {
    public static void main(String[] args) {

        List<Employee> listOfEmployees = Arrays.asList(
                new Employee("nithish", 10000.00),
                new Employee("sobiya", 200000.00),
                new Employee("soundari", 50000.00),
                new Employee("DInesh", 70000.00),
                new Employee("SeLVamani", 2300000.00)

        );

        //Convert list of Employees to Map

        Map<String,Double> mapOfEmployees = listOfEmployees.stream().collect(Collectors.toMap(Employee::getName,Employee::getSalary));
        System.out.println("Map of Employees: "+mapOfEmployees);
        //Convet naming case  firstLetter Caps and continuous small;

        List<String> namingCaseForMap = listOfEmployees.stream()
                .map(e->e.getName().substring(0,1).toUpperCase()+
                        e.getName().substring(1).toLowerCase())
                .collect(Collectors.toUnmodifiableList());

        System.out.println("namingCaseForMap: "+namingCaseForMap);
        List<String> namingCaseForMap2 = listOfEmployees.stream().map(e->e.getName().substring(0,1).toUpperCase()+e.getName().substring(1).toLowerCase()).collect(Collectors.toUnmodifiableList());

        //Convet and keep it as map
        Map<String,Double> namingMap = listOfEmployees.stream()
                .collect(Collectors.toMap(e-> {
                    return e.getName().substring(0,1).toUpperCase()+e.getName().substring(1).toLowerCase();},
                        Employee::getSalary));

        System.out.println("NamingMap: "+namingMap);


    }
}
