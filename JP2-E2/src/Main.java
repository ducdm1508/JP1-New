import Entity.Department;
import Entity.Employee;
import Entity.Gender;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Department> departments = new ArrayList<Department>();
        List<Employee> employees = new ArrayList<Employee>();

        Map<String, Long> countEmployee = new HashMap<>();

        departments.add(new Department(1, "HR", "Human Resource"));
        departments.add(new Department(2, "IT", "Information Technology"));

        employees.add(new Employee(1, "Nguyễn Văn A", departments.get(0), LocalDate.of(1990, 5, 15), Gender.M, "Hà Nội"));
        employees.add(new Employee(2, "Trần Thị B", departments.get(1), LocalDate.of(1988, 8, 20), Gender.F, "TP. Hồ Chí Minh"));
        employees.add(new Employee(3, "Lê Văn C", departments.get(1), LocalDate.of(1992, 10, 10), Gender.M, "Đà Nẵng"));
        employees.add(new Employee(4, "Phạm Thị D", departments.get(0), LocalDate.of(1995, 11, 25), Gender.F, "Hải Phòng"));
        employees.add(new Employee(5, "Hoàng Văn E", departments.get(1), LocalDate.of(1985, 8, 5), Gender.M, "Cần Thơ"));
        employees.add(new Employee(6, "Đặng Thị F", departments.get(0), LocalDate.of(1991, 10, 17), Gender.M, "Nha Trang"));
        employees.add(new Employee(7, "Vũ Văn G", departments.get(0), LocalDate.of(1989, 10, 12), Gender.M, "Huế"));
        employees.add(new Employee(8, "Bùi Thị H", departments.get(1), LocalDate.of(1993, 9, 22), Gender.F, "Vũng Tàu"));


        Map<String, Long> countMale = new HashMap<>();
        departments.forEach(department -> {
            long totaleMale = employees.stream()
                    .filter(emp -> department.getId() == emp.getDepartment().getId())
                    .filter(emp -> emp.getGender() == Gender.M )
                    .collect(Collectors.toSet())
                    .stream().count();
            countMale.put(department.getCode(), totaleMale );
        });
        System.out.println(countMale);

        Map<String, List<String>> birthdaysThisMonth  = new HashMap<>();
        departments.forEach(department -> {
            List<String> totalDoB = employees.stream()
                    .filter(employee -> department.getId() == employee.getDepartment().getId())
                    .filter(employee -> employee.getDoB().getMonthValue() == LocalDate.now().getMonthValue())
                    .map(Employee::getName)
                    .collect(Collectors.toList());

            birthdaysThisMonth .put(department.getCode(), totalDoB);
        });
        System.out.println(birthdaysThisMonth);
    }
}