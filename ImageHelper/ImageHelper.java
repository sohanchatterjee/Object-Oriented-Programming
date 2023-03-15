//Sohan Chatterjee
//SSW 315 Image Helper
//October 5, 2022
public class ImageHelper {
    static boolean validMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix.length != matrix[i].length)
                return false;
        }
        return true;
    }

    static void flipVertical(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                int temp = matrix[i][matrix[i].length - j - 1];
                matrix[i][matrix[i].length - j - 1] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    static void flipHorizontal(int[][] matrix) {
        if (validMatrix(matrix)) {
            int size = matrix.length - 1;
            for (int i = size / 2; i >= 0; i--) {
                int[] temp = matrix[i];
                matrix[i] = matrix[size - i];
                matrix[size - i] = temp;
            }
        }
    }

    static void rotateClockwise(int[][] matrix) {
        if (validMatrix(matrix)) {
            transpose(matrix);
            reflect(matrix);
        }
    }

    static void rotateCounterClockwise(int[][] matrix) {
        if (validMatrix(matrix)) {
            reflect(matrix);
            transpose(matrix);
        }
    }

    static void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    static void reflect(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - j - 1];
                matrix[i][matrix.length - j - 1] = temp;
            }
        }
    }
}
