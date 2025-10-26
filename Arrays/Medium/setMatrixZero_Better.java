package Medium;

public class setMatrixZero_Better {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 1, 1, 1},
            {1, 0, 1, 1},
            {1, 1, 0, 1},
            {0, 1, 1, 1}
        };
        printMatrix(matrix);
        setZeros(matrix);
        System.out.println("Matrix after setting zeros:");
        printMatrix(matrix);
    }
    //Better Approach - Time Complexity: 2*O(M*N) ~ O(M*N) , Space Complexity: O(M+N).
    //Time complexity best you can achieve for this problem is O(M*N) ~ O(N^2), as Need to traverse all elements of matrix at least once.
    //Next Optimal Approach will be optimizing the space complexity to O(1).
    public static void setZeros(int[][] matrix) {
        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];

        // First pass to find all rows and columns that need to be zeroed
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        // Second pass to set the zeros
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
