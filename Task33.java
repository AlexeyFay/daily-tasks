package tasks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Task33 {
    public static void main(String[] args) {
        //Задача 1 (Easy) – Сумма уникальных элементов
        //Дан массив целых чисел. Напиши метод, который возвращает сумму всех
        // уникальных элементов (тех, которые встречаются ровно один раз).
        //Пример:
        //[1, 2, 3, 2, 4, 1] → 3 + 4 = 7
        //[1, 1, 1] → 0
//        int[] arr = {1, 2, 3, 2, 4, 1};
        Task33 task33 = new Task33();
//        int result = task33.sumOfUnique(arr);
//        System.out.println(result);

        /// /////////////////////////////////////////////////////////////////////
        //Задача 2 (Medium) – Две суммы (Two Sum)
        //Дан массив целых чисел nums и целое число target. Напиши метод, который возвращает индексы двух чисел,
        // сумма которых равна target.
        // Гарантируется, что решение существует, и один и тот же элемент нельзя использовать дважды.
//        int[] arr = {1,2,6,3,7,9};
//        int target = 9;
//        int [] result = task33.twoSum(arr,target);
//        System.out.println(result[0] + " "+ result[1]);
        /// ////////////////////////////////////////////////////////////////////////
        //ТЕМА Исключения задачи
        //Задача 1 (лёгкая)
        //Создай метод divide(int a, int b), который возвращает результат деления a на b.
        //Если b == 0, выброси ArithmeticException с сообщением «Деление на ноль».
        // В main вызови метод с разными значениями и обработай исключение.

//        double number = 0;
//        try {
//            number = task33.divide(2,0);
//        } catch (ArithmeticException e) {
//            System.out.println(e);
//        }
//        System.out.println(number);
        /// //////////////////////////////////////
        //Задача 2 (лёгкая)
        //Напиши программу, которая запрашивает у пользователя путь к файлу,
        // пытается прочитать его и вывести содержимое. Используй try-with-resources для BufferedReader.
        // \Обработай FileNotFoundException (файл не найден) и IOException (другие ошибки ввода-вывода).
//        Scanner scanner = new Scanner(System.in);
//        String userPuth = scanner.nextLine();
//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(userPuth))) {
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                System.out.println(line);
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("Файл не найден: " + e.getMessage());
//        } catch (IOException e) {
//            System.out.println("Ошибка чтения файла: " + e.getMessage());
//        }
        /// /////////////////////////////////////////////////
        //Задача 3 (средняя)
        //Создай собственное checked исключение InvalidAgeException.
        // Напиши метод validateAge(int age), который выбрасывает это исключение, если возраст меньше 0 или больше 150.
        // В main вызови метод с несколькими значениями и обработай исключение (выведи сообщение).
//        try {
//            task33.validateAge(151);
//        } catch (InvalidAgeException e) {
//            System.out.println(e);
//        }
        /// /////////////////////////////////////////////
        //Задача 4 (средняя)
        //Напиши метод, который принимает массив чисел и возвращает его среднее значение.
        // Если массив пустой или null, выброси IllegalArgumentException с сообщением.
        // Продемонстрируй работу в main.
        int [] number = {12,2,42,55,6,21};
        double result = task33.average(number);
        System.out.println(result);


    }
    public double average(int[] arr){
        int count = 0;
        if (arr == null || arr.length == 0){
           throw  new IllegalArgumentException("Массив пустой или null");
        }
            for (int i: arr){
                count+=i;
            }
        return(double) count/arr.length;
    }

    // Создаю исключение
    static class InvalidAgeException extends Exception {
        public InvalidAgeException(String message) {
            super(message);
        }
    }

    public void validateAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 150) {
            throw new InvalidAgeException("Проверьте возраст");
        }
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Деление на 0");
        }
        return a / b;
    }

    public int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{};
    }

    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) {
                sum += entry.getKey();
            }
        }
        return sum;
    }
}
