package tasks;

import java.util.*;

public class Task44 {
    public static void main(String[] args) {
        //Дан массив целых чисел nums и целое число target.
        //Найди ИНДЕКСЫ двух чисел, которые в сумме дают target.
        //Пример 1:
        //Вход: nums = [2, 7, 11, 15], target = 9
        //Выход: [0, 1]
        //Объяснение: nums[0] + nums[1] = 2 + 7 = 9
        //Реши за O(n) время (один проход по массиву)
        //Используй HashMap для хранения: число → его индекс
        //Верни массив из двух индексов [index1, index2]
        //Гарантируется, что решение существует
        //Нельзя использовать один и тот же элемент дважды
        int[] arr = {2, 3, 1, 4, 5, 6, 8, 3, 7, 4};
        Task44 task44 = new Task44();
//        int[] result  = task44.twoSumm(arr, 10);
//        System.out.println(result[0]+" "+result[1]);

        /// //////////////////////////////////////////////////////////////////////////////////////////
        //Дана строка s. Найдите длину самой длинной подстроки без повторяющихся символов.
        //Вход: s = "abcabcbb"
        //Выход: 3
        //Пояснение: ответ — "abc", длина 3.
        //Требование к решению:
        //Использовать метод «скользящее окно» с HashSet (или подобной структурой) для достижения временной сложности O(n).
        String s = "abcabcbb";
        int result = task44.slidingWindow(s);
//        System.out.println(result);


        /// /////////////////////////////////////////////////////
        // Задача 1 [Easy]: Работа с List
        //Создай список студентов (класс Student с полями: name, age).
        //Требования:
        //1. Используй ArrayList для хранения
        //2. Добавь 5 студентов
        //3. Отсортируй по возрасту (используй Comparator)
        //4. Выведи всех студентов старше 20 лет
        //5. Удали студента по имени
        List<Student> list = new ArrayList<>();
        list.add(new Student("Alexey", 24));
        list.add(new Student("Ksenia", 28));
        list.add(new Student("Boris", 30));
        list.add(new Student("Mikhail", 18));
        list.add(new Student("Olga", 38));
        //first option
//        Comparator<Student> nameComparator = new ComparatorByAge();
        //second option
        list.sort(Comparator.comparingInt(Student::getAge));
        for (Student i: list){
            if (i.getAge()>20){
//                System.out.println(i.getAge() + " " + i.getName());
            }
        }
        list.removeIf(name->name.getName().equals("Olga"));
        for (Student i: list){
//                System.out.println(i.getAge() + " " + i.getName());
        }

        //third option
//        list.stream()
//                .sorted(Comparator.comparingInt(Student::getAge))
//                .filter(i->i.getAge()>20)
//                .forEach(i-> System.out.println(i.getAge()+" "+i.getName()));

        /// ////////////////////////////////////////////////////////////////////////////////////////////

        //Задача 2 [Easy]: Работа с Set
        //Дан список слов:
        //["apple", "banana", "apple", "orange", "banana", "kiwi"]
        //Требования:
        //1. Используй HashSet для удаления дубликатов
        //2. Используй LinkedHashSet для сохранения порядка добавления
        //3. Используй TreeSet для сортировки по алфавиту
        //4. Выведи результат для каждого типа Set
        //

        //option first
//        String[] str = {"apple", "banana", "apple", "orange", "banana", "kiwi"};
//        HashSet<String> hashSet = new HashSet<>();
//        for (String h: str){
//            hashSet.add(h);
//        }
//        System.out.println("HashSet delete dublicate");
//        hashSet.stream().forEach(System.out::println);
//       Set<String> linkedHashSet = new LinkedHashSet<>();
//        System.out.println();
//        System.out.println("LinkedHashSet save order");
//        for (String j:str){
//            linkedHashSet.add(j);
//        }
//        linkedHashSet.stream().forEach(System.out::println);
//        System.out.println();
//        System.out.println("TreeSet alphabetically sorted");
//        Set<String> treeSet = new TreeSet<>();
//        for (String k:str){
//            treeSet.add(k);
//        }
//        treeSet.stream().forEach(System.out::println);

        /// ///////////////////////////////////////////////////////
        //variant second
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "kiwi");
        Set<String> hashSet = new HashSet<>(words);
        Set<String> linkedSet = new LinkedHashSet<>(words);
        Set<String> treeSet = new TreeSet<>(words);
        System.out.println("HashSet: " + hashSet);
        System.out.println("LinkedHashSet: " + linkedSet);
        System.out.println("TreeSet: " + treeSet);

    }

    public int slidingWindow(String str) {
        HashSet<Character> window = new HashSet<>();
        int left = 0;
        int maxLengh = 0;
        for (int right = 0; right < str.length(); right++) {
            char currentSymbol = str.charAt(right);
            while (window.contains(currentSymbol)) {
                window.remove(str.charAt(left));
                left++;
            }
            window.add(currentSymbol);
            maxLengh = Integer.max(maxLengh, right - left + 1);
        }

        return maxLengh;
    }

    public int[] twoSumm(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{};
    }

}
//first option
//class ComparatorByAge implements Comparator<Student> {
//    @Override
//    public int compare(Student o1, Student o2) {
//        return Integer.compare(o1.getAge(), o2.getAge()) ;
//    }
//}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

