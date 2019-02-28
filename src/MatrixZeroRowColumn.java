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
     * checks if first row in the matrix has zero
     *
     * @param   matrix is a 2D array
     *
     * @return  true if first row has zero
     *          false otherwise
     */
    private static boolean isFirstRowZero(int[][] matrix){
        for(int columnNumber = 0; columnNumber < matrix[0].length; columnNumber++){
            if(matrix[0][columnNumber] == 0){
                return true;
            }
        }

        return false;
    }

    /*
     * checks if first column in the matrix has zero
     *
     * @param   matrix is a 2D array
     *
     * @return  true if first column has zero
     *          false otherwise
     */
    private static boolean isFirstColumnZero(int[][] matrix) {

        for(int rowNumber = 0; rowNumber < matrix.length; rowNumber++){
            if(matrix[rowNumber][0] == 0) {
                return true;
            }
        }
        return false;
    }

    /*
     * Makes entire first row zero
     *
     * @param   matrix is a 2D array
     */
    private static void makeFirstRowZero(int[][] matrix) {
        for(int columnNumber = 0; columnNumber < matrix[0].length; columnNumber++){
            matrix[0][columnNumber] = 0;
        }
    }

    /*
     * Makes entire first column zero
     *
     * @param   matrix is a 2D array
     */
    private static void makeFirstColumnZero(int[][] matrix){
        for(int rowNumber = 0; rowNumber < matrix.length; rowNumber++){
            matrix[rowNumber][0] = 0;
        }
    }

    /*
     * if elements in the matrix are zero then with respective to its index
     * first row and first column are set to zero
     * Example:     input matrix    [ 1, 2, 4 ]
     *                              [ 3, 0, 5 ]
     *                              [ 6, 8, 1 ]
     *
     *              output matrix   [ 1, 0, 4 ]
     *                              [ 0, 0, 5 ]
     *                              [ 6, 8, 1 ]
     */
    private static void markZerosOnFirstRowColumn(int[][] matrix) {
        for(int rowNumber = 1; rowNumber < matrix.length; rowNumber++) {
            for(int columnNumber = 1; columnNumber < matrix[0].length; columnNumber++) {
                if(matrix[rowNumber][columnNumber] == 0) {
                    matrix[0][columnNumber] = 0;
                    matrix[rowNumber][0] = 0;
                }
            }
        }
    }

    /*
     * set elements to zero with respective to its marks zero row and column
     *
     * @param   matrix is a 2D array
     */
    private static void useMarkToSetElements(int[][] matrix){
        for(int rowNumber = 1; rowNumber < matrix.length; rowNumber++) {
            for(int columnNumber = 1; columnNumber < matrix[0].length; columnNumber++) {
                if(matrix[rowNumber][0] == 0 || matrix[0][columnNumber] == 0) {
                    matrix[rowNumber][columnNumber] = 0;
                }
            }
        }
    }

    /*
     * makes matrix entire row/column zero if there is any zero in that particular row/column
     *
     * @param   matrix is a 2D array
     *
     * @return  2D matrix with row/column set to zero if there is any zero
     *          in that particular row/column
     */
    public static int[][] setRowColumnZero(int[][] matrix){

        if(matrix == null){
            return null;
        }

        if(matrix[0].length == 0) {
            int[][] emptyMatrix = {{}};
            return emptyMatrix;
        }

        boolean firstRowIsZero = isFirstRowZero(matrix);
        boolean firstColumnZero = isFirstColumnZero(matrix);

        markZerosOnFirstRowColumn(matrix);
        useMarkToSetElements(matrix);

        if(firstRowIsZero){
            makeFirstRowZero(matrix);
        }

        if(firstColumnZero){
            makeFirstColumnZero(matrix);
        }

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

        int[][] matrixWithZeroedRowColumn = setRowColumnZero(matrix);

        displayMatrix(matrixWithZeroedRowColumn);

    }
}
