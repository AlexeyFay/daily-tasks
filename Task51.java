package tasks;


public class Task51 {
    public static void main(String[] args) {
        //Задача 1 [Easy]: Класс "Книга"
        //// Создай класс Book с полями:
        //// • String title (название)
        //// • String author (автор)
        //// • int year (год издания)
        //// • boolean isAvailable (доступна ли)
        //// Добавь:
        //// • Конструктор по умолчанию
        //// • Параметризованный конструктор (все поля)
        //// • Метод displayInfo() → выводит информацию о книге
        //// • Геттеры и сеттеры для всех полей
//        Book book1 = new Book("Золотая рыбка","Пушкин",1993,true);
//        book1.displayInfo();
        /// ///////////////////////////////////////////////////////////////
        //Задача 2 [Medium]: Класс "Студент" — условие:
        //// Создай класс Student с полями:
        //// • String name
        //// • int age
        //// • double gpa (средний балл)
        //// Добавь:
        //// • Конструктор только с name (age=0, gpa=0.0)
        //// • Конструктор с name и age (gpa=0.0)
        //// • Конструктор со всеми полями
        //// • Конструктор копирования (Student other)
        //// • Метод isHonorsStudent() → возвращает true, если gpa >= 3.5
        //// В main создай 3-4 объекта разными способами и протестируй
//        StudentTask51 student1 = new StudentTask51("Alexey");  // name только
//        StudentTask51 student2 = new StudentTask51("Boris", 23);  // name + age (исправлено!)
//        StudentTask51 student3 = new StudentTask51("Olga", 26, 3.8);  // все поля
//        StudentTask51 student4 = new StudentTask51(student3);
//        System.out.println(student1);
//        System.out.println(student2);
//        System.out.println(student3);
//        System.out.println(student4);
//        System.out.println("Olga — отличница? " + student3.isHonorsStudent());
//        System.out.println("Alexey — отличник? " + student1.isHonorsStudent());

        /// /////////////////////////////////////////////////////////////////////////////////////////////
        // Задача 3 [Medium]: Класс "Прямоугольник" — условие:
        //// Создай класс Rectangle с полями:
        //// • double width
        //// • double height
        //
        //// Добавь:
        //// • Конструктор по умолчанию (width=1, height=1) → используй this()
        //// • Конструктор с одним параметром (квадрат) → используй this(s, s)
        //// • Конструктор с двумя параметрами
        //// • Метод getArea() → площадь
        //// • Метод getPerimeter() → периметр
        //// • Метод isSquare() → true, если ширина = высоте
//        RectangleTask51 rectangle1 = new RectangleTask51(12.3);
//        RectangleTask51 rectangle2 = new RectangleTask51(19.2,23.1);
//        RectangleTask51 rectangle3 = new RectangleTask51();
//        rectangle1.getArea();
//        rectangle2.getPerimeter();
//        rectangle3.isSquare();

        /// ///////////////////////////////////////////////////////////////////////////////////////////////
        //Задача 1 [Easy]: Инкапсуляция класса "Сотрудник"
        //// Создай класс Employee с полями:
        //// • private String name
        //// • private double salary
        //// • private String position
        //// Добавь:
        //// • Конструктор с параметрами
        //// • Геттеры для всех полей
        //// • Сеттеры с валидацией:
        ////   - name: не пустое, не null
        ////   - salary: >= 0
        ////   - position: не пустое
        //// В main создай объект и протестируй валидацию
        EmployeeTask51 employee1 = new EmployeeTask51("Alexey",100,"developer");
//        employee1.setSalary(-3);
//        employee1.setName(" ");
//        employee1.setPosition(" ");
    }
}

class Book {
    private String title;
    private String author;
    private int year;
    private boolean isAvailable;

    public Book() {
        System.out.println("Создана книга (по умолчанию)");
    }

    public Book(String title, String author, int year, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isAvailable = isAvailable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void displayInfo() {
        System.out.println("Title:" + title + "," + "Year:" + year + "," + "Author:" + author + "," + "Availability" + isAvailable);
    }
}

class StudentTask51 {
    String name;
    int age;
    double gpa;

    @Override
    public String toString() {
        return "StudentTask51{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gpa=" + gpa +
                '}';
    }

    public StudentTask51(String name) {
        this.name = name;
        this.age = 0;
        this.gpa = 0.0;
    }

    public StudentTask51(String name, int age) {
        this.name = name;
        this.age = age;
        this.gpa = 0.0;
    }

    public StudentTask51(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    public StudentTask51(StudentTask51 other) {
        this.name = other.name;
        this.age = other.age;
        this.gpa = other.gpa;
    }

    public boolean isHonorsStudent() {

        return this.gpa >= 3.5;
    }


}

class RectangleTask51 {
    private double width;
    private double height;

    public RectangleTask51(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public RectangleTask51() {
        this(1, 1);
    }

    public RectangleTask51(double side) {
        this(side, side);  // ← width = side, height = side
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public boolean isSquare() {
        return width == height;
    }

}

class EmployeeTask51 {
    private String name;
    private double salary;
    private String position;

    public EmployeeTask51(String name, double salary, String position) {
        this.name = name;
        this.salary = salary;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }


    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Имя не может быть пустым!");
        }
        this.name = name;
    }

    public void setSalary(double salary) {
        if (salary>=0){
            this.salary = salary;
        }else {
            throw  new IllegalArgumentException("Значение должно быть больше 0");
        }
    }

    public void setPosition(String position) {
        if (position == null || position.isEmpty()){
            throw new IllegalArgumentException("Должность не может быть пустой!");
        }
        this.position = position;
    }
}
