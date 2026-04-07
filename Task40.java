package tasks;

import java.util.*;

public class Task40 {
    public static void main(String[] args) {
        //Задача [Medium]: Самая длинная подстрока без повторяющихся символов
        //Дана строка s. Найди длину самой длинной подстроки,
        //в которой нет повторяющихся символов.
        //Подстрока — это последовательность символов, идущих подряд.
        //Вход: s = "abcabcbb"
        //Выход: 3
        //Объяснение: "abc" (длина 3) — самая длинная подстрока без повторов
//        String str = "abcabcbb";
        Task40 task40 = new Task40();
//        System.out.println(task40.slidingWindow(str));
        /// ////////////////////////////////////////////////////////
        // Задача: Пересечение двух массивов
        //Даны два целочисленных массива nums1 и nums2.
        //Найди пересечение этих массивов (общие элементы).
        //Реши ДВА варианта:
        //1. Без учёта дубликатов (уникальные элементы)
        //2. С учётом дубликатов (каждый элемент встречается
        //   столько раз, сколько он есть в обоих массивах)
        int[] nums1 = {2, 2,3,5};
        int[] nums2 = {2,1,2,5,3,2,2,2};
//        HashSet<Integer> resultListNotDublicate = task40.intersectionOfTwoArraysNotDublicate(nums1, nums2);
//        resultListNotDublicate.stream().forEach(System.out::println);
        List<Integer> resultListDublicate = task40.intersectionOfTwoArraysWithDuplicates(nums1, nums2);
        resultListDublicate.stream().forEach(System.out::println);

    }

    public List<Integer> intersectionOfTwoArraysWithDuplicates(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums1) {

            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }


        List<Integer> result = new ArrayList<>();

        for (int num : nums2) {

            if (frequencyMap.containsKey(num) && frequencyMap.get(num) > 0) {
                result.add(num);
                frequencyMap.put(num, frequencyMap.get(num) - 1);
            }
        }

        return result;
    }

    public List<Integer> intersectionOfTwoArraysDublicate(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        for (Integer i : nums1) {
            for (Integer j : nums2) {
                if (i == j) {
                    list.add(i);
                }
            }
        }
        return list;
    }

    public int slidingWindow(String str) {
        Set<Character> window = new HashSet<>();
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < str.length(); right++) {
            char currentSymbol = str.charAt(right);
            while (window.contains(currentSymbol)) {
                window.remove(str.charAt(left));
                left++;
            }
            window.add(str.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
