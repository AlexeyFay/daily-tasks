package tasks;

public class Task50 {
    public static void main(String[] args) {
        //Задача 3.3 [Medium]:
        // Дано: String day = "Понедельник";
        // Используй switch для определения:
        // - "Рабочий день" (Пн-Пт)
        // - "Выходной" (Сб, Вс)
        String day = "Понедельник";
//        String result;
//        String result = switch (day){
//            case "Понедельник","Вторник","Среда","Четверг","Пятница"->"Рабочий день";
//            case "Суббота","Воскресенье"->"Выходной";
//            default -> "Неизвестный день";
//        };
//        switch (day){
//            case "Понедельник":
//            case "Вторник":
//            case "Среда":
//            case "Четверг":
//            case "Пятница":
//                result = "Рабочий день";
//                break;
//            case "Суббота":
//            case "Воскресенье":
//                result = "Выходной";
//                break;
//            default:
//                result = "Неизвестный день";
//
//
//        }
//        System.out.println(result);

        /// ///////////////////////////////////////////////////////
        //Задача 6.3 [Medium]:
        //// Подсчитай количество гласных букв в строке:
        //// String text = "Hello World";
        //// Гласные: a, e, i, o, u (и русские а, е, ё, и, о, у, ы, э, ю, я)
        String text = "Hello World".toLowerCase();
        int count = 0;
        char[] ch = text.toCharArray();
        for (var i : ch){
            if (i=='а'
                    ||i=='е'
                    ||i=='ё'
                    ||i=='и'
                    ||i=='о'
                    ||i=='у'
                    ||i=='ы'
                    ||i=='э'
                    ||i=='ю'
                    ||i=='я'
                    ||i=='a'
                    ||i=='e'
                    ||i=='i'
                    ||i=='o'
                    ||i=='u'){
                count++;
            }

        }
        System.out.println("Колличество букв :"+count);



    }
}
