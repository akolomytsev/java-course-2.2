package Task5;

public class IncrementsTask implements Runnable{

    public static int counter = 0;

    private final Object monitor; // точка синхронизации одинаковая для всех потоков

    public IncrementsTask(Object monitor) { //  и передаем в конструкторе
        this.monitor = monitor;
    }


    @Override
    public void run() {
        for (int i = 0; i < 10000000; i++){
            synchronized (monitor) { // говорит всем потокам что в процессе работы кто то есть и надо ждать
                counter++;

            }
        }
    }
}
