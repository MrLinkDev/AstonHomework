package ru.link.exercise05.task02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static Employee[] employees = {
            new Employee("Bob", 25, "IT", 200),
            new Employee("Rob", 28, "Financial", 150),
            new Employee("Tom", 41, "IT", 160),
            new Employee("Eve", 19, "HR", 80),
            new Employee("Lia", 30, "HR", 140),
            new Employee("Joe", 55, "IT", 250)
    };

    public static void main(String[] args) {
        List<Employee> collection = createList(employees);

        System.out.println("Employees over 30: " + filterByAgeAndSortByAsc(collection, 30));
        System.out.println("Employees in IT department: " + countEmployeesInItDepartment(collection));
        System.out.println("Employee with max salary: " + findEmployeeWithMaxSalary(collection));
        System.out.println("Employees in HR department: " + getAllEmployeesInHrAndSortByName(collection));
        System.out.println("Average salary: " + getAvgSalary(collection));
    }

    /**
     * Создание списка из массива
     * @param employees Массив экземпляров объекта Employee
     * @return Список объектов Employee
     */
    private static List<Employee> createList(Employee[] employees) {
        return Arrays.stream(employees).toList();
    }

    /**
     * Возвращает список сотрудников старше N лет, который отсортирован по возрасту
     * @param employees Список сотрудников
     * @param age Возраст, по которому производится фильтрация
     * @return Список сотрудников
     */
    private static List<Employee> filterByAgeAndSortByAsc(List<Employee> employees, int age) {
        return employees.stream()
                .filter(employee -> employee.age() > age)
                .sorted(Comparator.comparingInt(Employee::age))
                .toList();
    }

    /**
     * Подсчитывает количество сотрудников в IT отделе
     * @param employees Список сотрудников
     * @return Количество сотрудников в IT отделе
     */
    private static long countEmployeesInItDepartment(List<Employee> employees) {
        return employees.stream()
                .filter(employee -> employee.department().equals("IT"))
                .count();
    }

    /**
     * Поиск сотрудника с максимальной зарплатой
     * @param employees Список сотрудников
     * @return Сотрудник с максимальной зарплатой
     */
    private static Employee findEmployeeWithMaxSalary(List<Employee> employees) {
        return employees.stream()
                .max(Comparator.comparingInt(Employee::salary))
                .get();
    }

    /**
     * Возвращает список сотрудников, которые работают в отделе HR.
     * Список отсортирован по именам сотрудников
     * @param employees Список сотрудников
     * @return Список сотрудников в отделе HR
     */
    private static List<Employee> getAllEmployeesInHrAndSortByName(List<Employee> employees) {
        return employees.stream()
                .filter(employee -> employee.department().equals("HR"))
                .sorted(Comparator.comparing(Employee::name))
                .toList();
    }

    /**
     * Возвращает среднюю зарплату
     * @param employees Список сотрудников
     * @return Средняя зарплата
     */
    private static float getAvgSalary(List<Employee> employees) {
        return employees.stream()
                .mapToInt(Employee::salary)
                .reduce(Integer::sum).getAsInt() / employees.stream().count();
    }
}
