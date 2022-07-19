package CodeStatesString;
import java.lang.*;
import java.util.*;
import java.util.stream.Stream;

class Employee implements Comparable<Employee>{
    int id;
    String name,department;

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    String getName() {
        return name;
    }
    int getId() {
        return id;
    }
    String getDepartment() {
        return department;
    }
    public String toString() {
        return String.format("[%d, %s, %s]", id, name, department);
    }
    public int compareTo(Employee e) {
        return e.id - this.id;
    }

}

class ComparatorExample {
    public static void main(String[] args) {
        Stream<Employee> workersStream =
                Stream.of(new Employee(11, "Kim Coding", "Software Engineering"),
                        new Employee(5, "Hello World", "Growth Marketing"),
                        new Employee(7, "Park Hacker", "Software Engineering"));
        workersStream.sorted(Comparator.comparing(Employee::getId)).forEach(System.out::println);

    }
}
