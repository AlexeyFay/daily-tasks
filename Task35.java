package tasks;

import javax.naming.ldap.SortKey;
import java.util.*;
import java.util.stream.Collectors;

public class Task35 {
    public static void main(String[] args) {
        //Two Sum [Medium]
        //Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
        Task35 task35 = new Task35();
//    int[]numbers = {1,2,4,3,5,7,4,26,6};
//    int[] result = task35.twoSum(numbers,9);
//        System.out.println(result[0]+" "+result[1]);
        /// ///////////////////////////////////////////////////////////
        // Задача: Сгруппировать анаграммы
        //Given an array of strings strs, group the anagrams together. You can return the answer in any order.
        //Anagrams are words that contain the same letters in a different order.
//        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
//       Map<String,List<String>> list = new HashMap<>();
//       for (String word : strs){
//           char[] ch = word.toCharArray();
//           Arrays.sort(ch);
//           String key = new String(ch) ;
//           List<String> group = list.getOrDefault(key, new ArrayList<>());
//           group.add(word);
//           list.put(key, group);
//       }
//       for (Map.Entry<String,List<String>> s : list.entrySet()){
//           System.out.println(s.getKey() + " " + s.getValue());
//       }
//        List<List<String>> result = new ArrayList<>(list.values());
//        result.stream().forEach(System.out::println);
        /// //////////////////////////////////////////////////////
        //Task 1 [Easy]: Generic Class Box<T>
        //Class Box<T> with a private field T value.
        //Constructor to set the value.
        //Method T get() to return the value.
        //Method void set(T value) to update the value.
        //Test it in main with String and Integer.
//        Box<String> box1 = new Box<>();
//        Box<Integer> box2 = new Box<>();
//        box1.setField("Box1");
//        box2.setField(5);
        /// ///////////////////////////////////////
        //Task 2 [Medium]: Create a static generic method printArray
        Integer[] number = {1,2,4,2,5,6,32,5,7};
        String[] str = {"hello","by","friend"};
        Double[] d = {2.45,14.13,56.2,23.12,5.0};
        Task35.<Integer>printArray(number);
        printArray(str);
        Task35.<Double>printArray(d);
    }

    // Structure:
    public static <T> void printArray(T[] array) {
        for (T t: array){
            System.out.println(t);
        }
    }

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> list = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int compliment = target - numbers[i];
            if (list.containsKey(compliment)) {
                return new int[]{list.get(compliment), i};
            }
            list.put(numbers[i], i);
        }
        return new int[]{};
    }
}

class Box<T> {
    private T field;

    public void setField(T field) {
        this.field = field;
    }

    public T getField() {
        return field;
    }
}
