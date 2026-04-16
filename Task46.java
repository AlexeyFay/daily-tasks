package tasks;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Task46 {
    public static void main(String[] args) {
        //Проверка существования суммы подмассива (Subarray Sum Equals K) – префиксные суммы.
        //Дан массив целых чисел nums и целое число k.
        //Найди ОБЩЕЕ КОЛИЧЕСТВО подмассивов, сумма элементов которых равна k.
        //Подмассив — это непрерывная последовательность элементов массива.
        int[] nums = {1, 1, 1};
        Task46 task46 = new Task46();
        int result = task46.subarraySum(nums, 2);
        //System.out.println(result);

        /// /////////////////////////////////////////////////////////////
        //Задача 1 [Easy]: Работа с LocalDate
        //Напиши метод, который принимает дату рождения (LocalDate)
        //и возвращает возраст человека в полных годах.
        //Требования:
        //1. Используй LocalDate для работы с датой
        //2. Учитывай високосные годы
        //3. Верни int (полных лет)
        //4. Обработай случай, когда дата рождения в будущем (верни -1 или выбрось исключение)
        //Пример:
        //Вход: LocalDate.of(1995, 6, 15)
        //Выход: 30 (если сегодня 16.04.2026)

//            System.out.println(task46.returnAge(LocalDate.of(1995,6,15)));


        /// /////////////////////////////////////////////////////////////////////////////////////////////////
        //Задача 2 [Easy]: Работа с DateTimeFormatter
        //Напиши метод, который принимает LocalDateTime и возвращает
        //строку в формате: "dd.MM.yyyy HH:mm"
//        System.out.println(task46.formatDate(LocalDateTime.now()) );

    }


    public String formatDate(LocalDateTime localDateTime) {
        String formatted = "dd.MM.yyyy HH:mm";
        return localDateTime.format(DateTimeFormatter.ofPattern(formatted));
    }

    public int returnAge(LocalDate birthDate) {
        if (birthDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Дата рождения не может быть в будущем");
        }
        Period period = Period.between(birthDate, LocalDate.now());
        return period.getYears();
    }

    public int subarraySum(int[] nums, int target) {
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1);
        int count = 0;
        int currentSum = 0;
        for (var num : nums) {
            currentSum += num;
            if (prefixSumMap.containsKey(currentSum - target)) {
                count += prefixSumMap.get(currentSum - target);
            }
            prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }
}
