package tasks;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Task49 {
    public static void main(String[] args) {
        // Задача 1 [Easy]: Фильтрация и преобразование
        //Дан список чисел: List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //1. Отфильтруй только чётные числа.
        //2. Возведи каждое число в квадрат.
        //3. Собери результат в новый List.
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        numbers.stream().filter(i->i%2==0).map(i->i*i).toList().forEach(System.out::println);

        /// ///////////////////////////////////////////////////////////////////////////
        // Задача 2 [Easy]: Работа со строками
        //Дан список имён: List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Eve");
        //1. Отфильтруй имена, которые начинаются на букву "A" или "D".
        //2. Приведи все имена к верхнему регистру.
        //3. Собери в List.
//        List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Eve");
//        names.stream()
//                .filter(i->i.charAt(0)=='A'||i.charAt(0)=='D')
//                .map(i->i.toUpperCase()).toList().forEach(System.out::println);
        /// ///////////////////////////////////////////////////////////////////////////////
        //Задача 3 [Medium]: flatMap для вложенных структур
        //Дан список списков чисел:
        //List<List<Integer>> nested = List.of(
        //    List.of(1, 2, 3),
        //    List.of(4, 5),
        //    List.of(6, 7, 8, 9)
        //);
        //1. "Расплющи" эту структуру в один плоский список.
        //2. Отфильтруй только числа больше 5.
        //3. Собери в List.
        List<List<Integer>> nested = List.of(
                    List.of(1, 2, 3),
                    List.of(4, 5),
                    List.of(6, 7, 8, 9)
                );
//        nested.stream().flatMap(Collection::stream).filter(i->i>5).toList().forEach(System.out::println);

        /// ///////////////////////////////////////////////////////////////////
        //Задача 4 [Medium]: Статистика через Collectors
        //Дан список сотрудников (класс Employee):
        //class Employee {
        //    String name;
        //    int age;
        //    double salary;
        //    String department;
        //}
        //List<Employee> employees = ... (создай 5-6 сотрудников с разными отделами)
        //
        //1. Сгруппируй сотрудников по отделам (Map<String, List<Employee>>).
        //2. Найди общую сумму зарплат по всем сотрудникам (double).
        //3. Найди максимальную зарплату (Optional<Double>).
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alexey",23,500.0,"Инженер"));
        employees.add(new Employee("Boris",18,5200.0,"Стажер"));
        employees.add(new Employee("Olga",29,2500.0,"Оператор"));
        employees.add(new Employee("Mikhail",18,2300.0,"Инженер"));
        employees.add(new Employee("Sergey",28,10500.0,"Директор"));
        Map<String,List<Employee>> byDepartment = employees.stream().collect(Collectors.groupingBy(i->i.department));
        byDepartment.forEach((dept,list)->
                System.out.println(dept + ":"+ list.stream().map(e->e.name).toList()));

        double totalSalary = employees.stream().collect(Collectors.summingDouble(e->e.salary));
        System.out.println("\nОбщая сумма зарплат: " + totalSalary);

        Optional<Double> maxSal = employees.stream().map(i->i.salary).max(Double::compare);
        System.out.println("Максимальная зарплата: " +
                maxSal.map(String::valueOf).orElse("Нет данных"));

    }
}
class Employee {
    String name;
    int age;
    double salary;
    String department;

    public Employee(String name, int age, double salary, String department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }
}