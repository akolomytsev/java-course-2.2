package Task3;
import java.util.*;

    /*1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
    Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
    Посчитать сколько раз встречается каждое слово.
    2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
    В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать
    номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов
    (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.*/

public class Collection {



    public static void main(String[] args) {
        List<String> wordArray = new ArrayList<String>(); // создаем массив
        ArrayOperation.fillTheArray(wordArray);           // Просто подтягиваем нашу коллекцию
        System.out.println(wordArray + "\n");             // выводим все в консоль в скобках
        ArrayOperation.printUniqueWords(wordArray);       // Тянем метод для сортировки и подсчета, он все и выводит в консоль уже после обработки


        Phonebook phonebook = new Phonebook();            // создаем массив с унаследованными параметрами

        phonebook.add(2304578, "Ivanov");  // задаем н-ое количество параметров
        phonebook.add(5678794, "Ivanov");
        phonebook.add(3456783, "Petrov");
        phonebook.add(3456278, "Sidorov");
        phonebook.add(9786053, "Sidorov");
        phonebook.add(6475893, "Sidorov");

        phonebook.get("Ivanov"); // делаем запрос по фамилиям и нам возвращается обработанная информация
        phonebook.get("Petrov");
        phonebook.get("Sidorov");
        phonebook.get("Akulshin");
    }
}
