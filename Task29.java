package tasks;

import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;

public class Task29 {
    public static void main(String[] args) {
        //Algorithmic Task (Easy/Medium)
        //Реализуй метод int lengthOfLongestSubstring(String s),
        // который возвращает длину самой длинной подстроки без повторяющихся символов.
//        Task29 task29 = new Task29();
//        int size = task29.lengthOfLongestSubstring("opookomno");
//        System.out.println(size);


        //Stream API и лямбда-выражения
        //Задача 1 (лёгкая)
        //Дан список строк: ["apple", "banana", "cherry", "date", "elderberry"].
        //Используя Stream API:
        //Оставь только строки, длина которых больше 5.
        //Преобразуй их в верхний регистр.
        //Собери в новый список.
        //Выведи результат.
//        String[] str = {"apple", "banana", "cherry", "date", "elderberry"};
//        Arrays.stream(str).filter(i->i.length()>5).map(i->i.toUpperCase()).toList().forEach(System.out::println);

        //Задача 2 (лёгкая)
        //Дан список целых чисел: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10].
        //Используя Stream API:
        //Оставь только чётные числа.
        //Возведи их в квадрат.
        //Найди сумму полученных чисел.
//        int [] number = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int sumNumber = Arrays.stream(number).filter(i->i%2==0).map(i->i*i).sum();
//        System.out.println(sumNumber);

        //Task 3 (Medium)
        //Given a list of strings: ["cat", "dog", "elephant", "tiger", "lion"].
        //Using Stream API:
        //Group the strings by their first letter.
        //Print the resulting map (Map<Character, List<String>>).
//        List<String> str = new ArrayList<>(Arrays.asList("apple", "banana", "cherry", "date", "elderberry"));
//        Map<Character,List<String>> map =
//         str.stream().collect(Collectors.groupingBy(word -> word.charAt(0))).forEach((key,val)-> System.out.println(key+"->"+val));
//
        //Task 4 (Medium)
        //Given a list of strings: ["level", "hello", "radar", "java", "madam"].
        //Using Stream API:
        //Keep only the strings that are palindromes (read the same forwards and backwards).
        //Sort them alphabetically.
        //Collect them into a list and print it.
        List<String> str = new ArrayList<>(Arrays.asList("level", "hello", "radar", "java", "madam"));
        str.stream().filter(word -> word.equals(String.valueOf(new StringBuilder(word).reverse()))).sorted().forEach(System.out::println);

    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            char curent = s.charAt(right);
            while (window.contains(curent)) {
                window.remove(s.charAt(left));
                left++;
            }
            window.add(curent);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
