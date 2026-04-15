package tasks;

import java.util.*;

public class Task45 {
    public static void main(String[] args) {
        //Задача [Medium]: Пересечение двух массивов
        //Даны два целочисленных массива: nums1 и nums2.
        //Найди пересечение этих массивов (общие элементы).
        //Реши ДВА варианта:
        //🔹 ВАРИАНТ 1: Без учёта дубликатов
        //(каждый элемент в результате встречается только 1 раз)
        //Пример:
        //Вход: nums1 = [1, 2, 2, 1], nums2 = [2, 2]
        //Выход: [2]
        //🔹 ВАРИАНТ 2: С учётом дубликатов
        //(элемент встречается столько раз, сколько он есть
        //в ОБОИХ массивах — минимальная частота)
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2, 1};
        Task45 task45 = new Task45();
//        task45.notDublicateIntersectionNumbers(nums1,nums2).stream().forEach(System.out::println);
//        task45.containsDublicateIntersectionNumbers(nums1,nums2).stream().forEach(System.out::println);

        /// /////////////////////////////////////////////////////////////////////////////
        //Задача 1 [Easy]: Generic класс "Коробка"
        //Создай класс Box<T> с одним полем value типа T.
        //Требования:
        //1. Конструктор принимает значение типа T
        //2. Метод get() возвращает T
        //3. Метод set() принимает T
        //4. Протестируй с String и Integer

        BoxT<String> box1 = new BoxT<>("String");
        BoxT<Integer> box2 = new BoxT<>(1);
        /// //////////////////////////////////////////////////////////////
        //Задача 2 [Medium]: Generic метод
        //// Напиши метод: public static <T> T getFirst(T[] array)
        //// Верни первый элемент или null, если массив пустой
        //// Протестируй со String[] и Integer[]
        String[] arr1 = {"a","b","c"};
        Integer[] arr2 = {2,3,4};
//        System.out.println(task45.getFirst(arr1));
//        System.out.println( task45.getFirst(arr2));
        /// //////////////////////////////////////////////////////
        // Задача 3 [Hard] — PECS (закончить Generics)
        // Напиши универсальный метод copy(), который копирует элементы
        //из одной коллекции в другую, используя правило PECS.
        //Метод должен работать с ЛЮБЫМИ совместимыми типами.

    }
    public <T> void copy (List<? extends T> source , List<? super T> destination){
        for (T i:source){
            destination.add(i);
        }


    }
    public  <T> T getFirst(T[] array) {
        if (array != null){
            return array[0];
        }
        return array[0];
    }


    public HashSet<Integer> notDublicateIntersectionNumbers(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();
        for (var s : nums1) {
            set.add(s);
        }
        for (var i : nums2) {
            if (set.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }

    public List<Integer> containsDublicateIntersectionNumbers(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : nums1) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        for (int num : nums2) {
            if (freq.containsKey(num) && freq.get(num) > 0) {
                result.add(num);
                freq.put(num, freq.get(num) - 1);
            }
        }

        return result;
    }
}

class BoxT<T> {
    private T value;

    public BoxT(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
