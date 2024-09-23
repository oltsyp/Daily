import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Student {

    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("John", 22, 3.5, Arrays.asList("Mathematics", "Physics")),
                new Student("Alice", 19, 4.0, Arrays.asList("Biology", "Chemistry")),
                new Student("Bob", 21, 3.8, Arrays.asList("Mathematics", "History")),
                new Student("Charlie", 23, 3.9, Arrays.asList("Literature", "History")),
                new Student("David", 18, 3.4, Arrays.asList("Mathematics", "Physics"))
        );

        // 1. Найти всех студентов старше 20 лет
        List<Student> studentsOver20 = students.stream()
                .filter(student -> student.getAge() > 20)
                .collect(Collectors.toList());
        System.out.println("Студенты старше 20 лет:\n" + studentsOver20);

        // 2. Найти студента с наивысшим средним баллом
        Student studentWithHighestGrade = students.stream()
                .max(Comparator.comparing(Student::getGrade))
                .orElse(null);
        System.out.println("Студент с наивысшим средним баллом:\n" + studentWithHighestGrade);

        // 3. Подсчитать количество студентов, которые посещают курс "Mathematics"
        long mathStudentsCount = students.stream()
                .filter(student -> student.getCourses().contains("Mathematics"))
                .count();
        System.out.println("Количество студентов, которые посещают курс \"Mathematics\":" + mathStudentsCount);

        // 4. Создать список студентов, отсортированных по имени в алфавитном порядке
        List<Student> studentsSortedByName = students.stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
        System.out.println("Список студентов, отсортированных по имени в алфавитном порядке:\n" + studentsSortedByName);

        // 5. Вывести список уникальных курсов, которые посещают студенты
        Set<String> uniqueCourses = students.stream()
                .flatMap(student -> student.getCourses().stream())
                .collect(Collectors.toSet());
        System.out.println("Список уникальных курсов, которые посещают студенты:\n" + uniqueCourses);
    }

    private String name;
    private int age;
    private double grade; // Средний балл
    private List<String> courses; // Список курсов

    public Student(String name, int age, double grade, List<String> courses) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.courses = courses;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGrade() {
        return grade;
    }

    public List<String> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                ", courses=" + courses +
                '}';
    }
}