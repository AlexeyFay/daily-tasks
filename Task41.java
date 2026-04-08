package tasks;

import java.util.HashMap;
import java.util.HashSet;

public class Task41 {
    public static void main(String[] args) {
        // Задача 1 [Medium]: Самая длинная подстрока без повторяющихся символов
        //Дана строка s. Найди длину самой длинной подстроки, в которой нет повторяющихся символов.
//        String str = "abcabcbb";
        Task41 task41 = new Task41();
//        System.out.println(task41.longestLine(str));
        /// ///////////////////////////////////////////////////
        //Задаче 2 [Easy]: Two Sum
        //Дан массив целых чисел nums и целое число target.
        //Найди ИНДЕКСЫ двух чисел, которые в сумме дают target.
        //Пример:
        //nums = [2, 7, 11, 15], target = 9
        //Ответ: [0, 1] (потому что nums[0] + nums[1] = 2 + 7 = 9)
        //Требования:
        //• Реши за O(n) время (один проход по массиву)
        //• Используй HashMap для хранения: число → его индекс
        //• Верни массив из двух индексов [index1, index2]

//        int[] nums = {2, 7, 11, 15};
//        int[] result =  task41.twoSum(nums,9);
//         System.out.println(result[0]+" "+result[1]);

/// ////////////////////////////////////////////////////////
        //Задача 1 [Easy]: Работа с массивами
        //Дан массив целых чисел: [5, 2, 8, 1, 9, 3]
        //Напиши код, который:
        //1. Найдёт максимальное число в массиве
        //2. Найдёт сумму всех чётных чисел
        //3. Выведет все числа в обратном порядке
        int[] number = {5,2,8,1,9,3};
        int sum = 0;
        int max = 0;
        for (int i:number){
            if (i%2 ==0){
                sum += i;
            }
            if (i>max){
                max = i;
            }

        }
//        for (int i = number.length-1;i>=0;i--){
//            System.out.println(number[i]);
//        }
//        System.out.println(sum);
//        System.out.println(max);

        /// //////////////////////////////////////
        //Задача 2 [Easy]: Работа со строками
        //Дана строка: "Java is awesome"
        //Напиши код, который:
        //1. Подсчитает количество букв 'a' (регистр не важен: 'a' и 'A' считаются)
        //2. Перевернёт строку (используй StringBuilder)
        //3. Проверит, начинается ли строка с "Java" (регистр важен)
        String  str = "Java is awesome";
        int resultA = 0;
        for (int i =0;i<str.length();i++){
            if (String.valueOf(str.charAt(i)).equals("a")||String.valueOf(str.charAt(i)).equals("A")){
                resultA++;
            }
        }
        System.out.println(resultA);
        StringBuilder stringBuilder = new StringBuilder(str);
        System.out.println(stringBuilder.reverse());
        String[] arrWord = str.split(" ");
        boolean startsWithJava = str.startsWith("Java");
        System.out.println(startsWithJava);

    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> list = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (list.containsKey(complement)) {
                return new int[]{list.get(complement), i};
            }
            list.put(nums[i], i);
        }
        return new int[]{};
    }

    public int longestLine(String str) {
        HashSet<Character> window = new HashSet<>();
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < str.length(); right++) {
            char currentSymbol = str.charAt(right);
            while (window.contains(currentSymbol)) {
                window.remove(str.charAt(left));
                left++;
            }
            window.add(currentSymbol);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
