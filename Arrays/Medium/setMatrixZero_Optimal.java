package Medium;
public class setMatrixZero_Optimal {
    public static void main(String[] args) {
        int[][] matrix = {

            {0, 1, 2, 0},
            {3, 4, 5, 2},
            {1, 3, 1, 5},
        };
        printMatrix(matrix);
        setZeros(matrix);
        System.out.println("Matrix after setting zeros:");
        printMatrix(matrix);
    }
    //Optimal Approach
    public static void setZeros(int[][] matrix) {
       int col0 = 1;
       //First Pass - Mark 1st Row and 1st Column zeros if any zero found in respective row/column
       for(int i=1;i<matrix.length;i++){
           for(int j=1;j<matrix[1].length;j++){
               if(matrix[i][j]==0){
                matrix[i][0]=0;
                matrix[0][j]=0;
               }
           }
       }

       //Check if 1st Row needs to be zeroed
       for(int j=1;j<matrix[0].length;j++){
            if(matrix[0][j]==0){
                col0=0;
            }
       }

       //Check if Oth Column needs to be zeroed
        for(int i=1;i<matrix.length;i++){
              if(matrix[i][0]==0){
                matrix[0][0]=0;
              }
        }

        //Set Zeros based on marks in 1st Row and 1st Column
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }

        //if 1st Row needs to be zeroed
        if(col0==0){
            for(int j=1;j<matrix[0].length;j++){
                matrix[0][j]=0;
            }
        }

        //if 1st Column needs to be zeroed
        if(matrix[0][0]==0){
            for(int i=1;i<matrix.length;i++){
                matrix[i][0]=0;
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
