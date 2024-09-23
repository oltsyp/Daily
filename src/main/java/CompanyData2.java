import java.util.*;
import java.util.stream.Collectors;

public class CompanyData2 {

    //Самая старая компанию (основанная раньше всех) и ее название:
    public static void main(String[] args) {
        List<Company> companies = CompanyData2.getCompanies();

        Company oldestCompany = companies.stream()
                .min(Comparator.comparingInt(Company::getYearFounded))
                .orElseThrow(NoSuchElementException::new);

        System.out.println("Самая старая компания: " + oldestCompany.getName());

        //Список всех компаний, отсортированных по количеству сотрудников в порядке убывания:
        companies.stream()
                .sorted(Comparator.comparingInt(company -> company.getEmployees().size()))
                .forEach(company -> System.out.println(company.getName() + ": " + company.getEmployees().size() + " сотрудников"));

        //Компания с наибольшим средним возрастом сотрудников:
        double maxAvgAge = companies.stream()
                .mapToDouble(company -> company.getEmployees().stream().mapToInt(Employee3::getAge).average().orElse(0))
                .max()
                .orElse(0);

        Company companyWithMaxAvgAge = companies.stream()
                .filter(company -> company.getEmployees().stream().mapToInt(Employee3::getAge).average().orElse(0) == maxAvgAge)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);

        System.out.println("Компания с наибольшим средним возрастом сотрудников: " + companyWithMaxAvgAge.getName());

        //Список всех сотрудников, работающих в компаниях, основанных до 2000 года:
        List<Employee3> employeesBefore2000 = companies.stream()
                .filter(company -> company.getYearFounded() < 2000)
                .flatMap(company -> company.getEmployees().stream())
                .collect(Collectors.toList());

        employeesBefore2000.forEach(employee -> System.out.println(employee.getName()));

        //Сгруппировать всех сотрудников по их должности, а затем вывести список должностей и сотрудников в каждой группе, отсортированных по зарплате:
        Map<String, List<Employee3>> employeesByPosition = companies.stream()
                .flatMap(company -> company.getEmployees().stream())
                .collect(Collectors.groupingBy(Employee3::getPosition));

        employeesByPosition.forEach((position, employees) -> {
            System.out.println("Должность: " + position);
            employees.stream()
                    .sorted(Comparator.comparingDouble(Employee3::getSalary))
                    .forEach(employee -> System.out.println(employee.getName() + " - Зарплата: $" + employee.getSalary()));
            System.out.println();
        });
    }
    public static List<Company> getCompanies() {
        List<Employee3> employees1 = Arrays.asList(
                new Employee3("John Doe", 35, "Manager", 75000.00),
                new Employee3("Alice Smith", 28, "Developer", 60000.00),
                new Employee3("Bob Johnson", 45, "Developer", 80000.00)
        );

        List<Employee3> employees2 = Arrays.asList(
                new Employee3("Charlie Brown", 32, "Manager", 72000.00),
                new Employee3("David Wilson", 29, "Designer", 55000.00),
                new Employee3("Eva White", 30, "Developer", 65000.00),
                new Employee3("Frank Harris", 40, "QA Engineer", 50000.00)
        );

        List<Employee3> employees3 = Arrays.asList(
                new Employee3("George Martin", 55, "CEO", 120000.00),
                new Employee3("Helen Lewis", 50, "CFO", 110000.00),
                new Employee3("Ivy Brown", 45, "Developer", 90000.00)
        );

        return Arrays.asList(
                new Company("TechCorp", 1995, employees1),
                new Company("DesignPro", 2005, employees2),
                new Company("FinanceInc", 1987, employees3)
        );
    }
}