package Task3;
import java.util.*;

public class Phonebook {
    private Map<Integer, String> phonebook;
    Phonebook() {
        phonebook = new HashMap<>();                                               // создали пустую коллекцию
    }
    public void add(int number, String surname) {                                  // метод для заполнения телефонной книги.
        phonebook.put(number, surname);                                            // обращение к членам класса
    }
    public void get(String surname){                                               // метод для обработки запрошеной информации
        if(phonebook.containsValue(surname)) {                                     //если есть хоть одно совпадение между запрашиваемой фамилией и фамилиями в телефонной книге то
            Set<Map.Entry<Integer, String>> set = phonebook.entrySet();            // не совсем понимаю что сдесь делпется, идет что то типа поочередного сравнения всех фамилий с запрашиваемой фамилией
            for (Map.Entry<Integer, String> temp : set) {                          // пробегаем по фамилиям нашей телефонной книги
                if(temp.getValue().equals(surname)) {                              // если есть одинаковые фамилии то возвращаем их все по очереди
                    System.out.println(temp.getValue() + " : " + temp.getKey());   // выводим в консоль фомилию и номер
                }
            }
        } else {
            System.out.println("Such a name is not on the list.");                  // если совпадений нет выводим такое сообщение
        }
    }
}
