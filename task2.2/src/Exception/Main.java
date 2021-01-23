package Exception;

public class Main {
    public static void main(String[] args) throws MyArrayDataException {
        int row = 4;
        int column = 4;
        String[][] array = {
                {"1", "2", "10", "3"},
                {"1", "2", "10", "3"},
                {"1", "2", "10", "3"},
                {"1", "2", "10", "5"}
        };

        try {
            createArr(array, row, column);
            printArr(array);
            calcArr(array, row, column);
            System.out.println("Sum is " + +calcArr(array, row, column));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }
    }

    public static void createArr(String[][] array, int row, int column) {
        if (array.length != 4) throw new MyArraySizeException("Incorrect number of rows");
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4)
                throw new MyArraySizeException(String.format("Invalid number of columns in %d" + " to line", i));
            for (int j = 0; j < array[i].length; j++) {
            }
        }
    }

    private static int calcArr(String[][] array, int row, int column) {
        int sum = 0;
        int[][] arrayInt = new int[row][column];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    arrayInt[i][j] = Integer.parseInt(array[i][j]);
                    sum += arrayInt[i][j];
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }

    private static void printArr(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

    private static void printArrInt(int[][] array) {
        System.out.println("This is arr Int ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
            }
        }
    }
}
