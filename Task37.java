package tasks;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Task37 {
    public static void main(String[] args) {
        //Дан массив целых чисел и целевое значение.
        //Найди ИНДЕКСЫ двух чисел, которые в сумме дают целевое значение.
//        int[] arr = {1,2,4,2,56,7,3,4,2,7,83,2,8};
        Task37 task37 = new Task37();
//        int[] result = task37.twoSumm(arr,7);
//        System.out.println(result[0]+ " " +result[1]);
        /// //////////////////////////////////////////////
        //Задача [Medium]: Самая длинная подстрока без повторяющихся символов
        //Используй HashSet для отслеживания символов в текущем окне
        //Реализуй алгоритм за O(n) время
        //Верни длину самой длинной подстроки (не саму подстроку)
        //Дана строка s. Найди длину самой длинной подстроки,
        //в которой нет повторяющихся символов.
        //Пример 1:
        //s = "abcabcbb"
        //Ответ: 3
        //Объяснение: "abc" — длина 3 (подстроки "bca", "cab" тоже подходят)
        //Пример 2:
        //s = "bbbbb"
        //Ответ: 1
        //Объяснение: "b" — длина 1
        //Пример 3:
        //s = "pwwkew"
        //Ответ: 3
        //Объяснение: "wke" — длина 3 (обрати внимание: "pwke" — это подпоследовательность, а не подстрока!)

        String str = "abcabcbb";
        task37.lenghSubstring(str);
        /// //////////////////////////////////////////
        //Задача 1 [Easy]: Чтение файла построчно
        //Создай текстовый файл test.txt в корне проекта с несколькими строками текста
        //Напиши код, который читает файл построчно и выводит каждую строку на экран
        //Используй try-with-resources для автозакрытия потока
//        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test.txt"))) {
//            bufferedWriter.write("Привет как дела я новый файл");
//            bufferedWriter.newLine();
//            bufferedWriter.write("я вторая строка");
//            System.out.println("Файл создан");
//        } catch (IOException e) {
//            throw new RuntimeException(e.getMessage());
//        }
//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("test.txt"))) {
//            String c;
//            while ((c = bufferedReader.readLine()) != null) {
//                System.out.println(c);
//            }
//
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        /// /////////////////////////////////////////
        //Задаче 2 [Easy]: Запись в файл
        //Создай файл output.txt
        //Запиши в него 5 строк текста (например, "Line 1", "Line 2"...)
        //Используй try-with-resources
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))){
            String[] text  = {"Line1","Line2","Line3","Line4","Line5"};
            for (String s : text){
                bw.write(s);
                bw.newLine();
            }
            System.out.println("Файл записан");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public int lenghSubstring(String str) {
        Set<Character> window = new HashSet<>();
        //левый указатель
        int left = 0;
        // Максимальная длина найденной подстроки
        int maxLen = 0;
// Правый указатель двигается по всей строке
        for (int right = 0; right < str.length(); right++) {
            char currentSym = str.charAt(right);
            while (window.contains(currentSym)) {
                // Удаляем левый символ из окна
                window.remove(str.charAt(left));
                // Сдвигаем левый указатель вправо
                left++;
            }
            // Добавляем текущий символ в окно
            window.add(currentSym);
            // Вычисляем текущую длину окна: right - left + 1
            // Обновляем максимум, если текущее окно больше
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public int[] twoSumm(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{};
    }
}
