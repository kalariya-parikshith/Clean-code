import org.junit.Assert;
import org.junit.Test;

public class TestCases {
    @Test
    public void Test1() {
        int[][] inputMatrix = {{ 1, 0 }, { 1, 1 }, { 2, 5 }};

        int[][] expectedMatrix = {{ 0, 0 }, { 1, 0 }, { 2, 0 }};

        int[][] actualMatrix = MatrixZeroRowColumn.setRowColumnZero(inputMatrix);
        Assert.assertArrayEquals(expectedMatrix, actualMatrix);
    }

    @Test
    public void Test2() {
        int[][] inputMatrix = {{ 1, 1 }, { 1, 1 }, { 2, 5 }};

        int[][] expectedMatrix = {{ 1, 1 }, { 1, 1 }, { 2, 5 }};

        int[][] actualMatrix = MatrixZeroRowColumn.setRowColumnZero(inputMatrix);
        Assert.assertArrayEquals(expectedMatrix, actualMatrix);
    }

    @Test
    public void Test3() {
        int[][] inputMatrix = {{ 0, 0 }, { 1, 1 }, { 2, 5 }};

        int[][] expectedMatrix = {{ 0, 0 }, { 0, 0 }, { 0, 0 }};

        int[][] actualMatrix = MatrixZeroRowColumn.setRowColumnZero(inputMatrix);
        Assert.assertArrayEquals(expectedMatrix, actualMatrix);
    }

    @Test
    public void Test4() {
        int[][] inputMatrix = {{0}};

        int[][] expectedMatrix = {{0}};

        int[][] actualMatrix = MatrixZeroRowColumn.setRowColumnZero(inputMatrix);
        Assert.assertArrayEquals(expectedMatrix, actualMatrix);
    }

    @Test
    public void Test5() {
        int[][] inputMatrix = {{111}};

        int[][] expectedMatrix = {{111}};

        int[][] actualMatrix = MatrixZeroRowColumn.setRowColumnZero(inputMatrix);
        Assert.assertArrayEquals(expectedMatrix, actualMatrix);
    }

}
