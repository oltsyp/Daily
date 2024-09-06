import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
    String name;
    int age;
    String department;

    public Employee(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("John", 25, "IT"),
                new Employee("Sarah", 30, "IT"),
                new Employee("Mike", 35, "HR"),
                new Employee("Anna", 40, "HR"),
                new Employee("James", 22, "Sales")
        );
        Map<String, Map<String, Integer>> departmentEmployeeMap = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.toMap(Employee::getName, Employee::getAge)));

        System.out.println(departmentEmployeeMap);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }
}