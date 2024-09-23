import java.util.List;

class Employee3 {
    private String name;
    private int age;
    private String position;
    private double salary;

    public Employee3(String name, int age, String position, double salary) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}

class Company {
    private String name;
    private int yearFounded;
    private List<Employee3> employees;

    public Company(String name, int yearFounded, List<Employee3> employees) {
        this.name = name;
        this.yearFounded = yearFounded;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public int getYearFounded() {
        return yearFounded;
    }

    public List<Employee3> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", yearFounded=" + yearFounded +
                ", employees=" + employees +
                '}';
    }
}