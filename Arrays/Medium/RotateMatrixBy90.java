package Medium;

public class RotateMatrixBy90 {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        System.out.println("Original Matrix:");
        printMatrix(matrix);
        //int[][] res = rotateMatrixBy90(matrix);
        rotateMatrixBy90(matrix);
        System.out.println("Matrix after rotating by 90 degrees:");
        //printMatrix(res);
        printMatrix(matrix);
    }

    //Brute Force Approach
    //Time Complexity: O(N^2) , Space Complexity: O(N^2)
    //public static int[][] rotateMatrixBy90(int[][] matrix) {
    //    int[][] rotated = new int[matrix.length][matrix[0].length];
    //    for (int i = 0; i < matrix.length; i++) {
    //        for (int j = 0; j < matrix[0].length; j++) {
    //            rotated[j][matrix.length - 1 - i] = matrix[i][j];
    //        }
    //    }
    //    return rotated;
    //}

    //Optimal Approach
    //Time Complexity: O(N^2) , Space Complexity: O(1)
    public static void rotateMatrixBy90(int[][] matrix) {
        //Step 1: Transpose the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] =  matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //Step 2: Reverse each row
        for (int i = 0; i < matrix.length; i++) {
            int left = 0;
            int right = matrix[0].length - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
