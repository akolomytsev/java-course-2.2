package Task5;

public class ImplementsTask implements Runnable{

    public static int counter = 0;


    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++){
            counter++;
        }
    }
}
