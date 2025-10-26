//Spiral traversal of a matrix
package Medium;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        System.out.println("Spiral Order Traversal of the Matrix:");
        printSpiral(matrix);
    }

    public static void printSpiral(int[][] matrix){
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while(top<=bottom && left<=right){
            //Traverse from left to right
            for(int j=left; j<=right;j++){
                System.out.print(matrix[top][j] + " ");
            }
            top++;

            //Traverse from top to bottom
            for(int i=top;i<=bottom;i++){
                System.out.print(matrix[i][right] + " ");
            }
            right--;

            //Traverse from right to left
            for(int j=right;j>=left;j--){
                System.out.print(matrix[bottom][j] + " ");
            }
            bottom--;

            //Traverse from bottom to top
            for(int i=bottom;i>=top;i--){
                System.out.print(matrix[i][left] + " ");
            }
            left++;

        }
    }
}
