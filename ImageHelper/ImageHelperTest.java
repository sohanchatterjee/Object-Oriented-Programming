
//Sohan Chatterjee
//SSW 315 Image Helper Test
//October 5, 2022
import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;

public class ImageHelperTest {
    @Test
    public void testValidMatrix() {
        int[][] matrix = { { 2, 3, 4 }, { 2, 3, 4 }, { 2, 3, 4 } };
        assertTrue("This is a valid matrix", ImageHelper.validMatrix(matrix));
    }

    @Test
    public void testInvalidMatrix() {
        int[][] matrix = { { 2, 3, 4 }, { 2, 3, 4 } };
        assertFalse("This is an invalid matrix", ImageHelper.validMatrix(matrix));
    }

    @Test
    public void testClockwise() {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        ImageHelper.rotateClockwise(matrix);
        int[][] desiredMatrix = { { 7, 4, 1 }, { 8, 5, 2 }, { 9, 6, 3 } };
        assertTrue("The matrix has been converted clockwise", Arrays.deepEquals(desiredMatrix, matrix));
    }

    @Test
    public void testCCW() {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        ImageHelper.rotateCounterClockwise(matrix);
        int[][] desiredMatrix = { { 3, 6, 9 }, { 2, 5, 8 }, { 1, 4, 7 } };
        assertTrue("The matrix has been converted counterclockwise", Arrays.deepEquals(desiredMatrix, matrix));
    }

    @Test
    public void testFlipHorizontal() {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        ImageHelper.flipHorizontal(matrix);
        int[][] desiredMatrix = { { 7, 8, 9 }, { 4, 5, 6 }, { 1, 2, 3 } };
        assertTrue("The matrix has been flipped horizontally", Arrays.deepEquals(desiredMatrix, matrix));
    }

    @Test
    public void testFlipVertical() {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        ImageHelper.flipVertical(matrix);
        int[][] desiredMatrix = { { 3, 2, 1 }, { 6, 5, 4 }, { 9, 8, 7 } };
        assertTrue("The matrix has been flipped vertically", Arrays.deepEquals(desiredMatrix, matrix));
    }
}
