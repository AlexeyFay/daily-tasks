package tasks;

import java.util.*;
import java.util.stream.Collectors;

public class Task39 {
    public static void main(String[] args) {
        //Задача 1 [Easy]: Two Sum (Две суммы)
        //Дан массив целых чисел nums и целое число target.
        //Найди ИНДЕКСЫ двух чисел, которые в сумме дают target.
        //Пример:
        //nums = [2, 7, 11, 15], target = 9
        //Ответ: [0, 1] (потому что nums[0] + nums[1] = 2 + 7 = 9)
//        int[] numbers = {2,7,11,15};
//        int target = 9;
        Task39 task39 = new Task39();
//        int [] result = task39.twoSum(numbers,target);
//        System.out.println(result[0]+" "+ result[1]);
        /// ////////////////////////////////////////////////////////////
        // 2 [Medium]: Longest Substring Without Repeating Characters
        //Дана строка s. Найди длину самой длинной подстроки,
        //в которой нет повторяющихся символов.
        //Пример 1:
        //s = "abcabcbb"
        //Ответ: 3  ("abc")
        //Реши за O(n) время (один проход)
        //Используй скользящее окно (two pointers) + HashSet (или HashMap)
        //Верни длину подстроки (int)
        String str = "abcabcbb";
//        System.out.println(task39.twoPointars(str));
        /// ////////////////////////////////////////////////
        //Задача 1 [Easy]: Фильтрация и преобразование
        //Дан список чисел: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        //Используя Stream API:
        //1. Отфильтруй только чётные числа
        //2. Возведи каждое в квадрат
        //3. Собери результат в List
//        int[] numbers = {1,2,3,4,5,6,7,8,9,10};
//        List<Integer> list = Arrays.stream(numbers).filter(i -> i % 2 == 0).map(i -> i * i).boxed().collect(Collectors.toList());
//        for (Integer i : list){
//            System.out.println(i);
//        }
        /// /////////////////////////////////////////////
        //Задаче 2 [Medium]: Группировка
        //Дан список имён: ["Alice", "Bob", "Charlie", "David", "Eve"]
        //Используя Stream API:
        //1. Сгруппируй имена по их длине
        //2. Результат: Map<Integer, List<String>>
        //Ожидаемый результат:
        //{3=[Bob, Eve], 5=[Alice, David], 7=[Charlie]}
//        List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Eve");
//          Map<Integer, List<String>> newList = names.stream().collect(Collectors.groupingBy(String::length));
//          for (Map.Entry<Integer,List<String>> s: newList.entrySet()){
//              System.out.println(s.getKey()+ "  "+ s.getValue());
//          }
        //Задача 3 [Hard]: Закрепление flatMap + groupingBy
        //Дан список списков слов:
        //[["Java", "Python"], ["C++", "Go", "Rust"], ["JavaScript"]]
        //Используя Stream API:
        //1. "Разверни" все слова в один поток (flatMap)
        //2. Найди все слова длиной больше 4 символов
        //3. Приведи к верхнему регистру
        //4. Собери в List
        //Ожидаемый результат: [PYTHON, JAVASCRIPT, RUST]
       List<List<String>> list = List.of(
               List.of("Java", "Python"),
               List.of("C++", "Go", "Rust"),
               List.of("JavaScript")
       );
       list.stream().flatMap(Collection::stream).filter(i->i.length()>=4).map(i->i.toUpperCase()).toList();



    }

    public int twoPointars(String str) {
        int left = 0;
        int maxLengh = 0;
        HashSet<Character> list = new HashSet<>();
        for (int right = 0; right < str.length(); right++) {
            char currentSymbl = str.charAt(right);
            while (list.contains(currentSymbl)){
                list.remove(str.charAt(left));
                left++;
            }
            list.add(currentSymbl);
            maxLengh = Math.max(maxLengh,right-left+1);
        }
        return maxLengh;
    }

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(numbers[i], i);
        }
        return new int[]{};
    }
}
