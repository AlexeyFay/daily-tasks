package tasks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Task52 {
    public static void main(String[] args) {
        //Задача 1 [Easy]: Деление с проверкой
        //// Напиши метод divide(int a, int b):
        //// • Если b == 0 → выбрось ArithmeticException с сообщением "Деление на ноль!"
        //// • Иначе → верни результат деления
        //// В main:
        //// • Вызови метод с b = 0 внутри try-catch
        //// • Выведи сообщение об ошибке
        Task52 task = new Task52();
//        try {
//            task.divide(3,0);
//        }catch (ArithmeticException e){
//            System.out.println("Ошибка!"+e.getMessage());
//        }

        /// ////////////////////////////////////////////////////////////////////////////////////////////////////////

        //Задача 2 [Medium]: Валидация пароля — условие:
        //// 1. Создай unchecked-исключение:
        ////    public class WeakPasswordException extends RuntimeException
        //// 2. Создай класс User с методом:
        ////    public void setPassword(String password) throws WeakPasswordException
        //// 3. Требования к паролю (если не подходит → throw new WeakPasswordException):
        ////    • Длина >= 8 символов
        ////    • Есть хотя бы одна цифра
        ////    • Есть хотя бы одна заглавная буква
        //// 4. В main протестируй:
        ////    • Пароль "123" → должно выбросить исключение
        ////    • Пароль "StrongPass1" → должно пройти
        UserTask52 user1 = new UserTask52();
//        user1.setPassword("111");

        /// /////////////////////////////////////////////////////////////////////////////////////////////////
        // Задача 3 [Medium]: Чтение файла — условие:
        //// Напиши метод:
        //public static void readFile(String path)
        //// Требования:
        //// 1. Используй try-with-resources с BufferedReader
        //// 2. Прочитай файл построчно и выведи в консоль
        //// 3. Обработай IOException (файл не найден, ошибка чтения)
        //// В main:
        //// • Создай файл "test.txt" (через IntelliJ: правая кнопка → New → File)
        //// • Запиши в него 3-5 строк текста
        //// • Вызови readFile("test.txt") — должно вывести содержимое
        //// • Вызови readFile("nonexistent.txt") — должно обработать ошибку
        task.readFile("tes.txt");

    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль!");
        } else {
            return (double) a / b;
        }
    }

    public void readFile(String path) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Ошибка: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class WeakPasswordException extends RuntimeException {
    public WeakPasswordException(String message) {
        super(message);
    }
}

class UserTask52 {
    private String password;


    public void setPassword(String password) throws WeakPasswordException {
        if (password == null || password.length() < 8) {
            throw new WeakPasswordException("Пароль должен содержать минимум 8 символов!");
        }
        boolean hasDigit = false;
        boolean hasUpperCase = false;
        for (var c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            }
        }
        if (!hasDigit) {
            throw new WeakPasswordException("Пароль должен содержать хотя бы одну цифру!");
        }
        if (!hasUpperCase) {
            throw new WeakPasswordException("Пароль должен содержать хотя бы одну заглавную букву!");
        }
        this.password = password;


    }
}
