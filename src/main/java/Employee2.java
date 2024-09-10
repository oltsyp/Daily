import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee2 {
    String name;
    int age;
    String position;
    double salary;
    String department;

    Employee2(String name, int age, String position, double salary, String department) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.salary = salary;
        this.department = department;
    }

    static List<Employee2> employees = Arrays.asList(
            new Employee2("John Doe", 35, "Developer", 60000, "IT"),
            new Employee2("Jane Smith", 28, "Manager", 50000, "HR"),
            new Employee2("Peter Johnson", 45, "Developer", 70000, "IT"),
            new Employee2("Lucy Brown", 30, "QA", 45000, "QA"),
            new Employee2("Tom White", 29, "Developer", 55000, "IT"),
            new Employee2("Alice Green", 32, "Manager", 75000, "Sales"),
            new Employee2("Bob Black", 25, "Intern", 30000, "IT")
    );

    public static void main(String[] args) {
        // Фильтрация сотрудников по возрасту и зарплате
        List<Employee2> filteredEmployees = employees.stream()
                .filter(employee -> employee.age > 30 && employee.salary > 50000)
                .sorted((emp1, emp2) -> emp1.name.compareTo(emp2.name))
                .collect(Collectors.toList());

        // Группировка сотрудников по отделам
        Map<String, Long> employeeCountByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee2::getDepartment, Collectors.counting()));

        // Поиск максимальной зарплаты в отделе IT
        Double maxSalaryIT = employees.stream()
                .filter(employee -> "IT".equals(employee.department))
                .mapToDouble(Employee2::getSalary)
                .max()
                .orElse(0);

        // Конвертация сотрудников в имена
        List<String> employeeNames = employees.stream()
                .map(Employee2::getName)
                .collect(Collectors.toList());

        // Подсчет среднего возраста сотрудников
        double averageAge = employees.stream()
                .mapToDouble(Employee2::getAge)
                .average()
                .orElse(0);

        // Нахождение всех сотрудников с ролью 'Developer'
        List<Employee2> developers = employees.stream()
                .filter(employee -> "Developer".equals(employee.position))
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }
}