package tasks;


import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Task43 {
    public static void main(String[] args) {
        //Задача 1 [Easy]: Best Time to Buy and Sell Stock
        //Дан массив prices, где prices[i] — цена акции в день i.
        //Найди максимальную прибыль, которую можно получить,
        //купив акцию в один день и продав в другой (позже).
        //Реши за O(n) время (один проход по массиву)
        //Используй один проход с отслеживанием минимума
        //Верни int (максимальная прибыль)
//        int[] prices  = {7, 1, 5, 3, 6, 4};
        Task43 task43 = new Task43();
//        int result = task43.robotStock(prices);
//        System.out.println(result);
        /// ////////////////////////////////////////////////////////////////
        //Задача 1 [Easy]: Обработка Checked исключения
        //Напиши метод, который читает файл и возвращает его содержимое.
        //Требования:
        //1. Используй try-with-resources
        //2. Обработай IOException (верни null или пустую строку при ошибке)
        //3. Выведи сообщение об ошибке в консоль
        String result = task43.readerFile();
//        System.out.println(result);

        /// /////////////////////////////////////////////////////////
        //: Задача 2 [Medium] — Своё исключение + валидация
        //• Создай класс InvalidUserException (checked)
        //• Создай класс User с валидацией email/age
        //• Протестируй с try-catch
        try {
            UserTask43 userTask43 = new UserTask43("@mail", -1);
        }catch (InvalidUserException e){
            System.err.println(e.getMessage());

        }


    }

    public String readerFile() {
        StringBuilder result = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("test.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line).append(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден" + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка чтения из файла" + e.getMessage());
        }
        return result.toString();
    }

    public int robotStock(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int p : prices) {
            int profit = p - min;
            maxProfit = Math.max(maxProfit, profit);
            min = Math.min(min, p);
        }
        return maxProfit;
    }
}
class  UserTask43    {
    private String email;
    private int age;
    UserTask43  (String email, int age) throws InvalidUserException {
        if (email==null||email.isEmpty()||!email.contains("@")){
            throw new InvalidUserException("Проблема с Email");
        }
        if (age<0||age>150){
            throw new InvalidUserException("Проблема с Age");
        }

        this.email = email;
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
class InvalidUserException extends  Exception {

    public InvalidUserException(String message) {
       super(message);

    }
}
