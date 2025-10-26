package Medium;

public class SetMatrixZero_brute {
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
    //Brute Force Approach
    public static void setZeros(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length; j++){
                if(matrix[i][j]==0){
                    //Set entire row to -1
                    for(int col=0; col<matrix[0].length; col++){
                        matrix[i][col]=-1;
                    }
                    //set entire column to -1
                    for(int row=0; row<matrix.length; row++){
                        matrix[row][j]=-1;
                    }
                }
            }
        }

        //Convert all -1 to 0
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length; j++){
                if(matrix[i][j]==-1){
                    matrix[i][j]=0;
                }
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
