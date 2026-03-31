package tasks;

import java.util.*;

public class Task34 {
    public static void main(String[] args) {
        //Тема: Массивы + Хеш-таблицы
        //Задача #1 [Easy] — «Two Sum» (Две суммы)
        //Дан массив целых чисел nums и целевое значение target.
        //Найди индексы двух чисел, которые в сумме дают target.
        Task34 task = new Task34();
//        int[] numbers = {1, 2, 5, 2, 7, 4, 3, 7};
//        int target = 9;
//        int[] result = task.twoSum(numbers, target);
//        System.out.println(result[0] + " " + result[1]);
        /// ////////////////////////////////////
        //Задача #1 [Easy] — ArrayList vs LinkedList
        //Создай ArrayList<Integer> и LinkedList<Integer>
        //В каждый добавь 100 000 элементов в начало списка (индекс 0)
        //Замерь время для каждой коллекции
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        long start = System.currentTimeMillis();
//        long end  = System.currentTimeMillis();
// твой код

//        for (int i =0;i<100000;i++){
//
//            arrayList.add(0,i);
//
//        }
//        end = System.currentTimeMillis();
//        System.out.println("Время: " + (end - start) + " мс");
//        start = System.currentTimeMillis();
//        for (int i =0;i<100000;i++){
//
//            linkedList.add(0,i);
//
//        }
//        end = System.currentTimeMillis();
//        System.out.println("Время: " + (end - start) + " мс");
        /// ///////////////////////////////
        //Задача #2 [Easy] — HashMap: подсчёт частоты символов
        //закрепить работу с HashMap на практике
        //Дана строка. Подсчитай, сколько раз встречается каждый символ.
        String str = "hellookejjdyss";
        Map<Character, Integer> list = new HashMap<>();
        for (int i = str.length() - 1; i > 0; i--) {
            if (list.containsKey(str.charAt(i))){
                list.put(str.charAt(i),list.getOrDefault(str.charAt(i),0)+1);
            }else {
                list.put(str.charAt(i),1);
            }

        }
        for (Map.Entry<Character,Integer> s : list.entrySet()){
            System.out.println(s.getKey()+" "+ s.getValue());
        }
    }


    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int compliment = target - numbers[i];
            if (map.containsKey(compliment)) {
                return new int[]{map.get(compliment), i};
            }
            map.put(numbers[i], i);
        }
        return new int[]{};
    }
}
