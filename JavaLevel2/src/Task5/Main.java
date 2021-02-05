package Task5;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Thread[] threads = new Thread[4]; //
        Object monitor = new Object();
        for (int i = 0; i < 4; i++){ //
            threads[i] =  new Thread(new IncrementsTask(monitor)); //
            threads[i].start(); // запуск итерации потока
            //threads[i].join(); //своеобразное горлышко, пока не пройдет итерация запущенного потока, следующая не пойдет. Многопоточность страдает
        }

        //threads[3].join(); // если закончился 3-й поток то и есть возможность что все остальные закончились, но не факт
       //TimeUnit.SECONDS.sleep(1); // таймер для выполнения команды
        boolean alive = true;
        while (alive) {
            boolean live = false;
            for (Thread thread : threads) {
                live |= thread.isAlive();
            }
            alive = live;

        }

        System.out.println(IncrementsTask.counter); // вывод в консоль результата
    }
}
