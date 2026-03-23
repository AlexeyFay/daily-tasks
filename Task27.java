package tasks;

import java.awt.*;

public class Task27 {
    public static void main(String[] args) {
        //Task 1 (Easy) – Reverse a string
        //Write a method that takes a string and returns it reversed.
        Task27 task27 = new Task27();
        //Task 2 (Easy/Medium) – Second Largest Element
        //Write a method that takes an array of integers and returns the second largest element in the array.
        // If there is no second largest (e.g., array has less than 2 elements or all elements are equal), return null (or throw an exception – but for simplicity, return null).
        //Examples:
        //[3, 1, 4, 4, 5, 2] → 4 (first largest is 5, second is 4)
        //[1, 1, 1] → null
        //[10] → null
        int[] arr = {3, 1, 4, 4, 5, 2};
        int number = task27.previousMaximum(arr);
        System.out.println(number);
    }
    public Integer previousMaximum(int[]arr){
        int max=Integer.MIN_VALUE;
        int secondMax=Integer.MIN_VALUE;
        if (arr.length<2){
            return null;
        }
        for (int i:arr){
           if (i<max){
               if (i>secondMax) {
                   secondMax = i;
               }

           }else if (i>max){
               if (i>secondMax){
                   secondMax = max;
               }
               max = i;
           }
        }
       return secondMax;
    }
    public void reversWords(String str){
        char[] ch = str.toCharArray();
        String newStr = "";
        for (int i=ch.length-1;i>=0;i--){
            newStr += ch[i];
        }
        System.out.println(newStr);
    }
}
