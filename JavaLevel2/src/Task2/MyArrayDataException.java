package Task2;

public class MyArrayDataException extends RuntimeException {

    public MyArrayDataException(int i, int j) {
        super("Wrong data. You have: row " + i + ", column " + j);
      }
}
