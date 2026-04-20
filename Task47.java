package tasks;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Task47 {
    public static void main(String[] args) {
        //Дан массив целых чисел nums и целое число k.
        //Найди ОБЩЕЕ КОЛИЧЕСТВО подмассивов, сумма элементов которых равна k.
        //Подмассив — это непрерывная последовательность элементов массива.
        //Вход: nums = [1, 1, 1], k = 2
        //Выход: 2
        int[] nums = {1, 1, 1};
        int target = 2;
        Task47 task47 = new Task47();
//        System.out.println(task47.totalNumberOfSubarrays(nums,target));
        /// //////////////////////////////////////////////////////////////////////////////////////////
        //Задача 1 [Easy]: Копирование файла (Байтовые потоки)
        //Напиши программу, которая копирует один файл в другой,
        //используя байтовые потоки (FileInputStream и FileOutputStream).
        try (FileInputStream fileInputStream = new FileInputStream("test.txt");
             FileOutputStream fileOutPutStream = new FileOutputStream("testDublicate.txt")) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) > 0) {
                fileOutPutStream.write(buffer, 0, bytesRead);
            }
//            System.out.println("File copy successfully");
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not exist", e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /// /////////////////////////////////////////////////////////////
        // Задача 2 [Easy]: Чтение текста построчно (Символьные потоки)
        //Напиши программу, которая читает текстовый файл построчно
        //и выводит каждую строку в консоль с номером строки.
        try (BufferedReader br = Files.newBufferedReader(Paths.get("test.txt"),StandardCharsets.UTF_8)) {
            int count = 1;
            String line;
            while (( line = br.readLine()) != null){
//                System.out.println(count++ + ": " + line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found", e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /// ///////////////////////////////////////////////////////
        //Задача 3 [Medium]: Статистика текста (Анализ файла)
        //Напиши программу, которая анализирует текстовый файл
        //и подсчитывает:
        //1. Общее количество строк
        //2. Общее количество слов
        //3. Общее количество символов (без пробелов)
        //4. Самое частое слово (регистр не важен)
        try(BufferedReader br = Files.newBufferedReader(Paths.get("test.txt"),StandardCharsets.UTF_8)){
            HashMap<String,Integer> hashMap = new HashMap<>();
            String line;
            String mostFrequentWord = null;
            int maxCount = 0;
            int sizeWords = 0;
            int countLine = 0;
            int summSimbol = 0;
            while ((line = br.readLine())!= null){
                countLine++;
                String[] words = line.split("\\s+");

                for (var i: words){

                    String clean = i.replaceAll("[^a-zA-Zа-яА-ЯёЁ]", "").toLowerCase();
                    if (clean.isEmpty()) continue;
                    hashMap.put(clean,hashMap.getOrDefault(clean,0)+1);
                    if (clean.isEmpty()) continue;  // Сначала проверка
                    sizeWords++;                    // Считаем только валидные слова
                    summSimbol += clean.length();
                }


            }
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                if (entry.getValue() > maxCount) {  // Ищем МАКСИМУМ
                    maxCount = entry.getValue();
                    mostFrequentWord = entry.getKey();
                }
            }
            System.out.println("Общее колличество строк:"+ countLine);
            System.out.println("Общее колличество слов:"+ sizeWords);
            System.out.println("Общее колличество символов:"+ summSimbol);
            System.out.println("Самое частое слово: " + mostFrequentWord + " (" + maxCount + " раз)");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public int totalNumberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int currentSum = 0;
        for (var i : nums) {
            currentSum += i;
            if (map.containsKey(currentSum - k)) {
                count += map.get(currentSum - k);
            }
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }
}
