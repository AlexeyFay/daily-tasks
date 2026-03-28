package tasks;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

public class Task32 {
    public static void main(String[] args) {
        //Задача 1 (лёгкая)
        //Напиши метод, который принимает массив целых чисел и возвращает среднее арифметическое всех положительных чисел.
        // Если положительных чисел нет, верни 0.
        Task32 task32 = new Task32();
//        int[]number = {2,4,2,7,4,9,3,5};
//        double result = task32.avergeArifmetic(number);
//        System.out.println(result);
        /// ///////////////////////////////////////
        //Задача 2 (лёгкая)
        //Напиши метод, который принимает строку и возвращает новую строку,
        // где каждый символ сдвинут на одну позицию в алфавите (a→b, b→c, …, z→a).
        // Строка содержит только строчные латинские буквы.
        //Пример: "abc" → "bcd", "xyz" → "yza".
//        String str = task32.shiftByOne("HELLOU");
//        System.out.println(str);

        /// //////////////////////////////////////////////////////////
        //1.3 Обработка ошибок (исключения)
        /// ////////////////////////////////////////////////
        //Задача 1 (лёгкая)
        //Создай метод divide(int a, int b), который возвращает результат деления a на b.
        // Если b == 0, метод должен выбросить ArithmeticException с сообщением "Деление на ноль".
        //В методе main вызови этот метод несколько раз (например, с b = 2, b = 0, b = 5) и обработай возможное исключение.

//        try {
//            System.out.println(task32.divide(4, 2)); // 2.0
//            System.out.println(task32.divide(4, 0)); // выбросит исключение
//        } catch (ArithmeticException e) {
//            System.out.println("Ошибка: " + e.getMessage());
//        }
        //Задача 2 (лёгкая)
        //Напиши программу, которая запрашивает у пользователя путь к файлу, пытается прочитать его и вывести содержимое.
        // Используй try-with-resources для BufferedReader.
        // Обработай FileNotFoundException (файл не найден) и IOException (другие ошибки ввода-вывода).
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please enter the file path");
//        String str = scanner.nextLine();
//        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(str))) {
//            String line;
//            while ((line = bufferedReader.readLine()) !=null){
//                System.out.println(line);
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("Файл не найден: " + e.getMessage());
//        } catch (IOException e) {
//            System.out.println("Ошибка чтения файла: " + e.getMessage());
//        }
        /// Задача 3 (средняя)
        // Создай собственное checked исключение InvalidAgeException.
        //Напиши метод validateAge(int age), который выбрасывает это исключение, если возраст меньше 0 или больше 150.
        //В main вызови метод с несколькими значениями и обработай исключение (выведи сообщение).
        try {
            task32.validateAge(25);    // нормально
            task32.validateAge(-5);    // выбросит исключение
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }

    }
    static class InvalidAgeException extends Exception {
        public InvalidAgeException(String message) {
            super(message);
        }
    }
    public void validateAge   (int age) throws InvalidAgeException {
        if (age<0||age>150){
            throw new InvalidAgeException("Некорректный возраст: " + age);
        }
    }


    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль");
        }
        return (double) a / b;
    }


    public double avergeArifmetic(int[] arr) {
        double result;
        int count = 0;
        int summ = 0;
        for (int i : arr) {
            if (i > 0) {
                count++;
                summ += i;
            }

        }
        result = (double) summ / count;

        return result;
    }

    public String shiftByOne(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'z') {
                result.append('a');
            } else {
                result.append((char) (c + 1));
            }
        }
        return result.toString();
    }
}
