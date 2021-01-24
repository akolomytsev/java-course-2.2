package Task2;
import java.util.*;

public class ArrayOperation {
    public static List<String> fillTheArray(List<String> array) { // Изначально  List на 10 позиций
        // просто заводим немного слов
        array.add("apple");
        array.add("person");
        array.add("car");
        array.add("Car");
        array.add("Meet");
        array.add("coat");
        array.add("CoaT");
        array.add("coat");
        array.add("meet");
        array.add("phone");
        array.add("phone"); // После этого ввода он сам становится больше в 1,5 раза
        array.add("meet");
        return array; // возвращаем всё в массив
    }

    public static void printUniqueWords(List<String> array) { // создаем метод для сортировки и подсчета
        Set<String> tempArray = new LinkedHashSet<>();        // создаем конструктор без повторяющихся элементов
        for (String arr : array) {                            // бежим по всей имеющейся коллекции слов
            String a = arr.toLowerCase();                     // преобразуем все символы строки в строчный регистр и присваевает к определенной позиции коллекции
            tempArray.add(a);                                 // добавляем элемент если он уже не добавлен в коллекцию
        }
        for (String tempArr : tempArray) {                    // для того же конструктора продолжаем действие
            int count = 0;                                    // задаем изначальное число счетчика
            for (String arr : array) {                        // для всех строк преобразованных в строчный регистр сравниваем
                String a = arr.toLowerCase();                 // преобразуем все символы строки в строчный регистр и присваевает к определенной позиции коллекции
                if(tempArr.equals(a)) count++;                // если все символы в строке совпали с уже имеющейся в коллекции и значение истина то увеличиваем счетчик на 1
            }
            System.out.println("\"" + tempArr + "\"" + " repeated in the list = " + count); // Выводим в консоль то что получилось
        }
        System.out.println();                                                               // Делаем одну пустую строку что бы отделить следующее задание
    }
}
