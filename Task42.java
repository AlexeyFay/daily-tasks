package tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Task42 {
    public static void main(String[] args) {
        //Задача 1 [Easy]: Two Sum (Две суммы)
        //Дан массив целых чисел nums и целое число target.
        //Найди ИНДЕКСЫ двух чисел, которые в сумме дают target.
        //Реши за O(n) время (один проход по массиву)
        //Используй HashMap для хранения: число → его индекс
        //Верни массив из двух индексов [index1, index2]
        //Гарантируется, что решение существует
        //Нельзя использовать один и тот же элемент дважды
        Task42 task42 = new Task42();
//        int[] nums = {1,23,4,5,2,5,76,4,7,9};
//        int[] result = task42.twoSum(nums,9);
//        System.out.println(result[0]+" "+result[1]);
        /// ////////////////////////////////////////////////
        //Задаче 2: Пересечение двух массивов
        //Даны два массива: nums1 и nums2
        //Найди пересечение (общие элементы).
        //ВАРИАНТ 1: Без дубликатов → [2]
        //ВАРИАНТ 2: С дубликатами → [2, 2]
        //Пример:
        //nums1 = [1, 2, 2, 1], nums2 = [2, 2]
        //Вариант 1: используй HashSet
        //Вариант 2: используй HashMap для подсчёта частоты
        //Реши за O(n + m) время
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
//        task42.researchNoDublicateArr(nums1,nums2).stream().forEach(System.out::println);
//        task42.researchDublicateArr(nums1,nums2).stream().forEach(System.out::println);
        /// /////////////////////////////////
        //Задача 1 [Easy]: Класс Person
        //Создай класс Person с полями:
        //• private String name
        //• private int age
        //
        //Требования:
        //1. Параметризованный конструктор
        //2. Геттеры и сеттеры (в setAge() добавь валидацию: 0 < age < 150)
        //3. Метод toString(), который возвращает "Person{name='...', age=...}"
        //4. Протестируй создание объекта и вывод
        PersonTask42 personTask42 = new PersonTask42("Alexey",152);
        personTask42.setAge(151);
    }
    public HashSet<Integer> researchNoDublicateArr(int[]nums1, int[]nums2){
        HashSet<Integer> list = new HashSet<>();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i: nums1){
            hashSet.add(i);
        }
        for (int i = 0 ; i<nums2.length;i++){
            if (hashSet.contains(nums2[i])){
                list.add(nums2[i]);
            }
        }
        return list;
    }

    public List<Integer> researchDublicateArr(int[]nums1,int[]nums2){
        HashMap<Integer,Integer> map = new HashMap<>();
       for (int num:nums1){
           map.put(num,map.getOrDefault(num,0)+1);
       }
       List<Integer> result = new ArrayList<>();
       for (int num:nums2){
           if (map.containsKey(num)&&map.get(num)>0){
               result.add(num);
               map.put(num,map.get(num)-1);
           }
       }
       return result;
    }

    public int[] twoSum(int[] arr , int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i =0;i<arr.length;i++){
            int complement = target-arr[i];
            if (map.containsKey(complement)){
                return new int[]{i,map.get(complement)};
            }
            map.put(arr[i],i);
        }
        return new int[]{};
    }
}
class PersonTask42 {
    private  String name;
    private  int age;

    public PersonTask42(String name, int age) {
        this.name = name;
        setAge(age);
    }

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

        if (age>=150 || age<=0){
            throw new IllegalArgumentException("Проверьте ваш возраст");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonTask42{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
