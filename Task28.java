package tasks;

import java.util.HashMap;
import java.util.Map;

public class Task28 {
    public static void main(String[] args) {
        //Task (Easy/Medium):
        //Given an array of integers, write a method that returns the most frequent element (the element that appears the most).
        // If there are multiple, return any of them.
        Task28 task28 = new Task28();
        int[] arr = {1, 3, 2, 3, 4, 3, 5};
        int result = task28.mostFrequentElement(arr);
        System.out.println(result);
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
