package tasks;

import org.w3c.dom.Text;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class Task36 {
    public static void main(String[] args) {
        //Задача 1 [Easy]: Создать и вывести дату
        //Задание:
        //Создай LocalDate с датой 15 марта 2026 года
        //Выведи её на экран
        //Добавь к дате 10 дней (не забудь про неизменяемость!)
        //Выведи новую дату
//        LocalDate localDate = LocalDate.of(2026, Month.MARCH,15);
//        System.out.println(localDate);
//        localDate = localDate.plusDays(10);
//        System.out.println(localDate);
        /// /////////////////////////////////////////
        //Задаче 2 [Easy]: Форматирование даты
        //Создай LocalDate с сегодняшней датой (LocalDate.now())
        //Создай DateTimeFormatter с паттерном "dd.MM.yyyy"
        //Отформатируй дату в строку с помощью formatter
        //Выведи строку на экран
//        LocalDate localDate = LocalDate.now();
//        String formattedDate = localDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
//        System.out.println(formattedDate);
        /// ///////////////////////////////////////
        //Задаче 3 [Medium]: Разница между датами (Period)
        //Создай две даты: 1 января 2026 и 15 марта 2026
        //Вычисли разницу между ними через Period.between()
        //Выведи: сколько месяцев и дней между этими датами
//        LocalDate localDate1 = LocalDate.of(2026,Month.JANUARY,1);
//        LocalDate localDate2 = LocalDate.of(2026,Month.MARCH,15);
//        Period difference = Period.between(localDate1,localDate2);
//        System.out.println("Месяцев:"+difference.getMonths() +" "+"Дней:"+ difference.getDays());
        /// //////////////////////////////////////////////////////////////////
        //Задача [Hard]: Полная работа с датами и локалью
        //Дана строка с датой: "15.03.2026"
        //Преобразуй её в LocalDate с помощью DateTimeFormatter
        //Добавь к дате 2 месяца и 5 дней (не забудь про неизменяемость!)
        //Отформатируй результат в строку формата: "EEEE, dd MMMM yyyy"
        //Используй русскую локаль, чтобы день недели и месяц были на русском
        //Выведи результат на экран
        String date = "15.03.2026";


        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localDate = LocalDate.parse(date, inputFormatter);
        localDate = localDate.plusMonths(2).plusDays(5);

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", new Locale("ru"));
        String formattedDate = localDate.format(outputFormatter);
        System.out.println(formattedDate);

    }
}
