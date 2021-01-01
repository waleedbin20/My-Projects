package java_assignment;

public class Exercise1 {
    public static void main(String[] args) {
        int[][] arrays = {{3, -1, 4, 0}, {5, 9, -2, 6}, {5, 3, 7, -8}, {2, 1, 6, -2}};
        int rows = 4;
        int columns = 4;
        int i, j;
        for (i = 0; i < rows; i++) {
            for (j = 0; j < columns; j++) {
                System.out.print(arrays[i][j] + " ");
            }
            System.out.println("   ");

        }

        System.out.println("\n" + "Left Diagonal Sum = " + mainDiagonalElementSum(arrays));
        System.out.println("\n" + "Maximum value of a row in array = " + maxRowAbsSumValue(arrays));
        System.out.println("\n" + "Maximum value of column in array = " + maxColumnAbsSumValue(arrays));


    }

    public static int mainDiagonalElementSum(int[][] array) {
        // calculating  sum of the left diagonal in the array
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j)
                    sum = sum + array[i][j];
            }

        }
        return sum;
    }

    public static int maxRowAbsSumValue(int[][] array) {
        int maxRow = 0;

        // finding the maximum sum among the rows
        for (int row = 0; row < array.length; row++) {
            int totalOfRow = 0;
            for (int column = 0; column < array[row].length; column++) {
                if (array[row][column] > 0) {
                    totalOfRow += array[row][column];
                }
                else {
                    totalOfRow -= array[row][column];
                }
            }
            if (totalOfRow > maxRow) {
                maxRow = totalOfRow;
            }
        }
        return maxRow;
    }

    public static int maxColumnAbsSumValue(int[][] array) {
        int maxSum = 0;
        for (int row = 0; row < array.length; row++)
        {
            int sum = 0;

            // calculate sum of column
            for (int column = 0; column < array.length; column++)
            {
                if (array[column][row] > 0){
                    sum += array[column][row];
                }
                else {
                    sum -= array[column][row];
                }
            }

            if (sum > maxSum){
                maxSum = sum;
            }
        }
        return maxSum;
    }
}





