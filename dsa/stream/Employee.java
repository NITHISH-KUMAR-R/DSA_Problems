package dsa.stream;


public class Employee {
         Double salary;
         String name;

        public Employee(String name,Double salary) {
            this.salary = salary;
            this.name = name;
        }

        public Double getSalary() { return salary; }
        public String getName() { return name; }

        @Override
        public String toString() {
            return "Person{id=" + salary + ", name='" + name + "'}";
        }
    }
