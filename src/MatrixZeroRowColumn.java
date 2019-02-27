/*
 * Practices used are as follows
 * 1) Functions should be small
 * 2) Functions should do only one thing
 * 3) Function name should describe what it is ment for
 * 4) Arguments should be less in number(may be < 2) or
 *      probably your function is doing more than one thing
 * 5) Should not use output arguments
 * 6) Function at most should have one return statement
 * 7) Statements in a function should be at same level of abstraction
 * 8) Descriptive names
 *
 * space complexity is O(M x N)
 * time  complexity is O(M x N)
 ** where M is number of rows and N is number of columns
 */


import java.util.logging.Logger;
import java.util.Scanner;

public class MatrixZeroRowColumn {
    private static final Logger logger = Logger.getLogger("Row column zero");

    /*
     * Displays the given matrix
     *
     * @param   matrix is a 2D array
     */
    private static void displayMatrix(int[][] matrix) {
        for(int rowNumber = 0; rowNumber < matrix.length; rowNumber++) {
            for(int columnNumber = 0; columnNumber < matrix[0].length; columnNumber++) {
                //System.out.print is used instead of logger so that 2D array is visible in matrix form
                System.out.print(matrix[rowNumber][columnNumber] + " ");
            }
            System.out.println(); //break line
        }
    }

    /*
     * Makes entire row zero if matrix has any zero in that row
     *
     * @param   matrix is a 2D array
     * @param   rowZero array contains information about which rows should
     *          be made entirely zero
     */
    private static void makeRowsZero(int[][] matrix, boolean[] rowZero) {
        for(int rowNumber = 0; rowNumber < matrix.length; rowNumber++) {
            if(rowZero[rowNumber]) {
                for(int columnIndex = 0; columnIndex < matrix[0].length; columnIndex++) {
                    matrix[rowNumber][columnIndex] = 0;
                }
            }
        }
    }

    /*
     * Makes entire column zero if matrix has any zero in that column
     *
     * @param   matrix is a 2D array
     * @param   colZero array contains information about which columns should
     *          be made entirely zero
     */
    private static void makeColumnsZero(int[][] matrix, boolean[] colZero){
        for(int colNumber = 0; colNumber < matrix[0].length; colNumber++) {
            if(colZero[colNumber]) {
                for(int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
                    matrix[rowIndex][colNumber] = 0;
                }
            }
        }
    }

    /*
     * makes matrix entire row/column zero if there is any zero in that perticular row/column
     *
     * @param   matrix is a 2D array
     *
     * @return  2D matrix with row/column set to zero if there is any zero
     *          in that particular row/column
     */
    public static int[][] setRowColumnZero(int[][] matrix){
        boolean[] rowZero = new boolean[matrix.length];
        boolean[] colZero = new boolean[matrix[0].length];
        for(int rowNumber = 0; rowNumber < matrix.length; rowNumber++) {
            for(int columnNumber = 0; columnNumber < matrix[0].length; columnNumber++) {
                if(matrix[rowNumber][columnNumber] == 0) {
                    rowZero[rowNumber] = true;
                    colZero[columnNumber] = true;
                }
            }
        }

        makeRowsZero(matrix, rowZero);
        makeColumnsZero(matrix, colZero);

        return matrix;

    }

    /*
     * main function takes input from console and passes arguments to
     * setRowColumnZero() method to get matrix with zeroed rows and
     * columns if that particular row or column has zero and displays
     * matrix in the console
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfRows = scanner.nextInt();
        int numberOfColumns = scanner.nextInt();
        int[][] matrix = new int[numberOfRows][numberOfColumns];

        for(int rowNumber = 0; rowNumber < numberOfRows; rowNumber++) {
            for(int columnNumber = 0; columnNumber < numberOfColumns; columnNumber++) {
                matrix[rowNumber][columnNumber] = scanner.nextInt();
            }
        }

        int[][] matrixWithZeroedRowColumn = setRowColumnZero(matrix.clone());

        displayMatrix(matrixWithZeroedRowColumn);

    }
}
