package Task5;

import java.util.Arrays;

public class MyMultithreading {
    private static final int size = 10000000;
    private static final int h = size / 2;

    public static void main(String[] args){
        MyMultithreading multithreading = new MyMultithreading();
        multithreading.methodOne();
        multithreading.methodTwo();
    }

    private void methodOne(){
        System.out.println("Start 1");
        float[] arr = new float[size]; // наш массив
//        for (int i = 0; i < arr.length; i++) {
        //          arr[i] = 1;
//        }

        Arrays.fill(arr, 1.0f); // вместо for заполняем массив единицами
        long start = System.currentTimeMillis(); // Засекаем время старта
        for(int i = 0; i < arr.length; i++){  //бежим по массиву
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2)); // и заполняем каждое следующее число по этой формуле
        }
        long end = System.currentTimeMillis();  // Засекаем время окончания
        System.out.println("Stop 1. Execution time " + (end - start)); // выводим в консоль вместе с временем
    }

    private void methodTwo(){
        System.out.println("Start 2"); // Просто запись старта
        float[] arr = new float[size]; // массив весь
        float[] arr1 = new float[h]; // половина массива
        float[] arr2 = new float[h]; // вторая половина массива
        Arrays.fill(arr, 1.0f); //вместо for заполняем массив единицами
        long start = System.currentTimeMillis();  // Засекаем время старта деления
        System.arraycopy(arr, 0, arr1, 0, h); // Откуда копируем, с чего начинаем копирование из источника, куда копируем, окуда начинаем в пункте назначения, сколько копируем. Первый поток
        System.arraycopy(arr, h, arr2, 0, h);  // Откуда копируем, с чего начинаем копирование из источника, куда копируем,окуда начинаем в пункте назначения, сколько копируем. Второй поток
        long split = System.currentTimeMillis(); // Засекаем время окончания деления
        System.out.println("Array split execution time " + (split - start));  // Выводим получившееся время деления

        Thread thread1 = new Thread(() ->this.methodTwoInternal(arr1, 1)); // Создаем массивы что бы можно было их подтянуть где надо
        Thread thread2 = new Thread(() ->this.methodTwoInternal(arr2, 2));  //

        thread1.start();  // старт первого потока
        thread2.start();  // старт второго потока

        try{
            thread1.join(); //
            thread2.join(); //
        } catch (InterruptedException e){ // прокидываем исключение если они возникают в потоках
            System.out.println("Exception in Threads. " + e.getMessage()); // После исключения выводим сообщение
        }


        long connect = System.currentTimeMillis(); // Засекаем время начала слияния потоков
        System.arraycopy(arr1, 0, arr, 0, h); // Так же как и в делении: берем из первого потока, начинаем с нулевого места, вставляем в основной поток, в основном потоке начинаем втавлять с 0, и вставляем весь первый поток
        System.arraycopy(arr2, 0, arr, h, h); // так же как и выше но начинаем запись не с 0 а с h тоесть после первого потока
        long end = System.currentTimeMillis(); // Засекаем время окончания слияния потоков
        System.out.println("Array glue execution time " + (end - connect)); // выводим время склейки потоков
        System.out.println("Stop 2. Execution time " + (end - start)); // Выводим общее время выполнения второго метода
    }

    private void methodTwoInternal(float[] arr, int number){ // Создаем метод который будет нам заполнять массивы по странной формуле
        long start = System.currentTimeMillis(); // засекаем время старта
        for(int i = 0; i < arr.length; i++){ // пробегаем
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2)); // заполняем
        }
        long end = System.currentTimeMillis(); // Засекаем врямя финиша
        System.out.printf("Thread execution time %d equally %s%n", number, (end - start)); // выводим в консоль с именами потока и их временем
    }
}
