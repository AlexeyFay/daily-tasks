package tasks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Task38 {
    public static void main(String[] args) {
        //task1 ease search dublicate
        //Дан массив целых чисел. Определи, есть ли в нём хотя бы один дубликат.
        //Верни true, если какое-либо значение встречается дважды или более.
        //Верни false, если все элементы уникальны.
        //Реши за O(n) время (один проход по массиву)
        //Используй HashSet для отслеживания уже виденных чисел
        //Верни boolean
//        int[] nums = {1, 2, 2, 3, 4};
//        Task38 task38 = new Task38();
//        System.out.println(task38.dublicateSearch(nums));
        /// ////////////////////////////////////////////////////////////
        //Задача [Medium]: Самая длинная подстрока без повторяющихся символов
        //Дана строка s. Найди длину самой длинной подстроки,
        //в которой нет повторяющихся символов.
        //Пример 1:
        //s = "abcabcbb"
        //Ответ: 3
        //Объяснение: "abc" — длина 3 (подстроки "bca", "cab" тоже подходят)
        //Пример 2:
        //s = "bbbbb"
        //Ответ: 1
        //Объяснение: "b" — длина 1
        //Пример 3:
        //s = "pwwkew"
        //Ответ: 3
        //Объяснение: "wke" — длина 3 (обрати внимание: "pwke" — это подпоследовательность, а не подстрока!)
//        String str = "abcabcbbqwerty";
//        int result = task38.slidingWindow(str);
//        System.out.println(result);

        /// /////////////////////////////////////////////////////////////////////////////

        //Задача 1 [Easy]: Создание и запуск потока
        //Создай класс, который реализует Runnable
        //В методе run() выведи сообщение "Поток работает..." и номер потока
        //Создай и запусти 3 потока с этим Runnable
        //Используй join(), чтобы главный поток дождался завершения всех трёх
//        NewClass newClass1 = new NewClass();
//        NewClass newClass2 = new NewClass();
//        NewClass newClass3 = new NewClass();
//        Thread thread1 = new Thread(newClass1);
//        Thread thread2 = new Thread(newClass2);
//        Thread thread3 = new Thread(newClass3);
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        try{
//            thread1.join();
//            thread2.join();
//            thread3.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("Все потоки завершены!");

/// ////////////////////////////////////////////////////
        //Задаче 2 [Medium]: Race Condition + synchronized
        //1. Создай класс Counter с полем int count и методом increment()
        //2. Запусти 10 потоков, каждый делает 1000 инкрементов
        //3. СНАЧАЛА без synchronized — увидишь race condition (результат < 10000)
        //4. ПОТОМ с synchronized — результат должен быть ровно 10000
        Counter counter = new Counter();
        System.out.println(counter);
        List<Thread> threads = new ArrayList<>();
        for (int j = 0; j < 10; j++) {
            Thread thread = new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
                    counter.increment();
                }
            });
            thread.start();
            threads.add(thread);
        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Итог: " + counter.getCounter());
    }


    static class Counter {
         AtomicInteger counter = new AtomicInteger(0);

        public AtomicInteger getCounter() {
            return counter;
        }

        public  void increment() {
            counter.incrementAndGet();
        }
    }


    static class NewClass implements Runnable {

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println("stream " + name + " works");
        }
    }

    public int slidingWindow(String str) {
        int left = 0;
        int maxLenght = 0;
        HashSet<Character> window = new HashSet<>();

        for (int right = 0; right < str.length(); right++) {
            char currentSymbl = str.charAt(right);
            while (window.contains(currentSymbl)) {
                window.remove(str.charAt(left));
                left++;
            }
            window.add(currentSymbl);
            maxLenght = Math.max(maxLenght, right - left + 1);

        }
        return maxLenght;
    }

    public boolean dublicateSearch(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i : nums) {
            hashSet.add(i);
        }
        if (nums.length == hashSet.size()) {
            return false;
        }
        return true;
    }
}

