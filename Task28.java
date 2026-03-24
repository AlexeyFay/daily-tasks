package tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Task28 {
    public static void main(String[] args) {
        //Task (Easy/Medium):
        //Given an array of integers, write a method that returns the most frequent element (the element that appears the most).
        // If there are multiple, return any of them.
        Task28 task28 = new Task28();
//        int[] arr = {1, 3, 2, 3, 4, 3, 5};
//        int result = task28.mostFrequentElement(arr);
//        System.out.println(result);
        /// //////////////////////////////////////////////////////////////////////////
        //multithreading task
        //Задача 1 (лёгкая)
        //Создайте класс, реализующий Runnable. В методе run() в цикле выведите 5 раз имя текущего потока (Thread.currentThread().
        // getName()) и порядковый номер. Затем в main создайте два потока с этим Runnable и запустите их.
        // Убедитесь, что вывод перемешивается.
//        Thread thread1 = new Thread(new CurrentClass());
//        Thread thread2 = new Thread(new CurrentClass());
//        thread1.start();
//        thread2.start();

        ///Task 2
        //Rewrite the same logic using ExecutorService with a fixed thread pool of 2. Submit 5 tasks.
        // Each task should print its number and the thread name (like in Task 1).
//        ExecutorService service = Executors.newFixedThreadPool(2);
//        for (int taskNumber = 1; taskNumber <= 5; taskNumber++) {
//            int num = taskNumber; // effectively final для использования в лямбде
//            service.submit(() -> {
//                System.out.println("Задача " + num + " выполняется в потоке " + Thread.currentThread().getName());
//            });
//        }
//        service.shutdown();
//        try {
//            service.awaitTermination(1, TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            System.out.println("Ожидание прервано");
//        }
//        System.out.println("Все задачи выполнены");

        //task 3 race condition
//        int[] counter = {0};
//
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        for (int t = 0; t < 5; t++) {
//            int taskNumber = t;
//            executorService.submit(() -> {
//                for (int j = 0; j < 1000; j++) {
//                    counter[0]++;
//                }
//            });
//        }
//        executorService.shutdown();
//        try {
//            executorService.awaitTermination(1, TimeUnit.MINUTES);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Результат без синхронизации: " + counter[0]);
        //task 3 The right decision race condition
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        AtomicInteger counter = new AtomicInteger(0);
        for (int t = 0; t < 5; t++) {
            int taskNumber = t;
            executorService.submit(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.addAndGet(+1);
                }
            });
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Результат с AtomicInteger: " + counter);
    }

    public int mostFrequentElement(int[] arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        int maxCount = 0;
        int mostFrequent = arr[0];
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequent = entry.getKey();
            }
        }
        return mostFrequent;

    }

}

class CurrentClass implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + "number: " + i);
        }
    }
}
