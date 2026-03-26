package tasks;

import java.util.List;

public class Task30 {
    public static void main(String[] args) {
        //Первая задача (лёгкая)
        //Напиши метод, который принимает массив целых чисел и возвращает сумму всех положительных элементов.
        //Пример: [1, -2, 3, 4, -5] → 1+3+4 = 8.
//        int [] arr = {1, -2, 3, 4, -5};
//        Task30 task30  = new Task30();
//        int result = task30.summPositiveInteger(arr);
//        System.out.println(result);
        // 2 задача
        // Напиши метод, который принимает строку и возвращает количество гласных букв
        // (гласные: a, e, i, o, u, y — для простоты только английские, регистр не важен).
        //Пример: "Hello World" → 3 (e, o, o).
        //Реализуй самостоятельно, без использования готовых библиотек.
//        Task30 task30  = new Task30();
//        String str = "Hello World";
//        int result = task30.quantityNumberVowelsLetters(str);
//        System.out.println(result);

        //Третья задача (средняя)
        //Условие:
        //Дан массив целых чисел. Напиши метод, который возвращает массив из двух элементов:
        // минимальное и максимальное значение в массиве.
        //Пример: [3, 1, 4, 1, 5, 9, 2] → [1, 9].
        //Требования:
        //Найди минимальное и максимальное за один проход по массиву (без сортировки).
        //Если массив пустой или null, верни null или выбрось исключение (на твой выбор).
        Task30 task30  = new Task30();
        int[] numbers = {3, 1, 4, 1, 5, 9, 2};
        int[] result = task30.minMaxNumber(numbers);
        System.out.println("Самое маленькое число:"+result[0]+" Самое большое число:"+result[1]);

    }
    public int[] minMaxNumber (int [] arr){
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return new int[]{min, max};
    }
    public int quantityNumberVowelsLetters(String str){
        if (str== null || str.isEmpty()){
            System.out.println("Проверьте строку");
        }
        int count = 0;
        char[] ch = str.trim().toLowerCase().toCharArray();
            for (int i = 0; i<ch.length;i++){
                if (String.valueOf(ch[i]).equals("a")
                        ||String.valueOf(ch[i]).equals("e")
                        ||String.valueOf(ch[i]).equals("i")
                        ||String.valueOf(ch[i]).equals("o")
                        ||String.valueOf(ch[i]).equals("u")
                        ||String.valueOf(ch[i]).equals("y")){
                    count++;
                }
            }
            return count;

    }
    public int summPositiveInteger (int [] arr){
        int result=0;
        for (int i:arr){
            if (i>0){
                result += i;
            }
        }
        return result;
    }
}
