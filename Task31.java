package tasks;

import java.util.ArrayList;

public class Task31 {
    public static void main(String[] args) {
        //Задача 1 (лёгкая)
        //Дан массив целых чисел. Напиши метод, который возвращает количество чётных чисел в массиве.
//        int [] number = {2,3,4,2,16,4,2,1,6,8};
//        Task31 task31 = new Task31();
//        int result = task31.evenNumber(number);
//        System.out.println(result );
        /// ////////////////////////////////
        // Задача 2 (лёгкая)
        //Напиши метод, который принимает строку и возвращает строку,
        // в которой все гласные (a, e, i, o, u, y) заменены на символ '*'.
//        Task31 task31 = new Task31();
//        String str = task31.ReplaseLettersForSymbol("hallo me alex");
//        System.out.println(str);

        /// ////////////////////////
        //1.2 Объектно-ориентированное программирование (ООП)
        //Создай класс Person с полями name (String) и age (int).
        // Добавь конструктор, геттеры и сеттеры. В методе main создай несколько объектов и выведи их данные.
//    Person person1 = new Person("Alexey",26);
//    Person person2 = new Person("Oleg",36);
//        System.out.println(person1.getName() + " " + person1.getAge());
//        System.out.println(person2.getName() + " " + person2.getAge());
        //Задача 2 (лёгкая)
        //Создай класс Animal с методом void sound(), который выводит "Animal makes a sound".
        //Создай класс Dog, наследующий Animal, и переопредели sound(), чтобы выводилось "Dog barks".
        //В main создай переменную типа Animal, но объект Dog. Вызови sound(). Объясни, почему работает полиморфизм.
//            Animal dog = new Dog();
//            dog.sound();
        /// ////////////////////////////
        //Задача 3 (средняя)
        //Создай интерфейс Drawable с методом void draw().
        //Создай классы Circle и Rectangle, реализующие Drawable.
        // В draw() выводи соответственно "Drawing a circle" и "Drawing a rectangle".
        //Создай список ArrayList<Drawable>, добавь объекты, в цикле вызови draw().
        //ArrayList<Drawable> list = new ArrayList<>();
        //        list.add(new Rectangle());
        //        list.add(new Circle());
        //        list.add(new Rectangle());
        //        list.add(new Circle());
        //        for (Drawable i : list){
        //            i.draw();
        //        }
        /// /////////////////////////////////////
        //Задача 4 (средняя)
        //Создай абстрактный класс Shape с полем color (String) и абстрактным методом double getArea().
        //Создай классы Circle (с полем radius) и Rectangle (с полями width, height), реализующие getArea().
        //В main создай список ArrayList<Shape>, добавь объекты, выведи площадь каждой фигуры.

//        ArrayList<Shape> list = new ArrayList<>();
//        list.add(new NewRectangle(30,18));
//        list.add(new NewCircle(16));
//
//        for (Shape i : list){
//            System.out.println(i.getArea());
//        }
        /// /////////////////////////////////
        //Задача 5 (средняя/сложная)
        //Создай класс User с полями username (String), email (String).
        //Создай enum UserRole с ролями ADMIN, USER, GUEST.
        // Добавь в enum поле String description и конструктор, устанавливающий описание для каждой роли.
        //Добавь в User поле role типа UserRole.
        //Создай несколько пользователей с разными ролями и выведи их информацию (имя, роль, описание роли).
        ArrayList<User> list = new ArrayList<>();
        list.add(new User("alex", "alex@mail.com", UserRole.ADMIN));
        list.add(new User("oleg", "oleg@mail.com", UserRole.USER));
        list.add(new User("guest", "guest@mail.com", UserRole.GUEST));
        for (User u : list ){
            System.out.println(u.getUsername() + " | " + u.getEmail() + " | " + u.getRole() + " | " + u.getRole().getDescription());
        }
    }

    public String ReplaseLettersForSymbol(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] ch = str.toLowerCase().toCharArray();
        for (Character c : ch) {
            if (String.valueOf(c).equals("a") ||
                    String.valueOf(c).equals("e") ||
                    String.valueOf(c).equals("i") ||
                    String.valueOf(c).equals("o") ||
                    String.valueOf(c).equals("u") ||
                    String.valueOf(c).equals("y")) {

                stringBuilder.append("*");
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public int evenNumber(int[] arr) {
        int result = 0;
        for (int i : arr) {
            if (i % 2 == 0) {
                result++;
            }
        }
        return result;
    }
}

class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Animal {
    public void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}

interface Drawable {
    void draw();
}

class Circle implements Drawable {

    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class Rectangle implements Drawable {

    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}

abstract class Shape {
    private String color;

    abstract double getArea();
}

class NewCircle extends Shape {
    int radius;

    public NewCircle(int radius) {
        this.radius = radius;
    }

    @Override
    double getArea() {
        return radius * radius;
    }
}

class NewRectangle extends Shape {
    int width;
    int height;

    public NewRectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    double getArea() {
        return width * height;
    }
}

class User {
    String username;
    String email;
    UserRole role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public User(String username, String email, UserRole role) {
        this.username = username;
        this.email = email;
        this.role = role;
    }
}

enum UserRole {
    ADMIN("Administrator with full rights"),
    USER("Regular user"),
    GUEST("Guest user");
    private final String description;

    UserRole(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}