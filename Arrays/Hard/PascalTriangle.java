//In Pascal's Triangle, each number is the sum of the two numbers directly above it.

// Generally asked question-
//(A) Given row & col, return the value at that position in Pascal's Triangle.
//(B) Given row, return the entire row as an array.
//(C) Print complete Pascal's Triangle up to given number of rows.
package Hard;

public class PascalTriangle {
    public static void main(String[] args) {
        //Part (A)
        int rowA = 6;
        int colA = 4;
        //System.out.println(find_nCr(rowA-1, colA-1));

        //Part (B)
        //int rowB = 7;
        //int[] resultRow = getRow(rowB-1);
        //for(int val: resultRow){
        //    System.out.print(val+" ");
        //}
    
        //Part (C)
        int numRows = 5;
        System.out.println();
        //printPascalTriangle(numRows);

        //printPascalTriangleOptimal
        printPascalTriangleOptimal(numRows);
    }

    //(A) Given row & col, return the value at that position in Pascal's Triangle.
    //Time Complexity: O(r)
    //Space Complexity: O(1)
    public static int find_nCr(int n, int r) {
        int res=1;
        for(int i=1; i<=r; i++){
            res = res * n;
            res = res / i;
            n--;
        }
        return res;
    }

    //(B) Given row, return the entire row as an array.
    //Brute Force Approach - Time Complexity: O(r^2), Space Complexity: O(r)
    public static int[] getRow(int row){
        int[] result = new int[row+1];
        for(int col=0; col<=row; col++){
            result[col] = find_nCr(row, col);
        }
        return result;
    }

    //(B) Optimal Approach - Time Complexity: O(r), Space Complexity: O(r)
    public static int[] getRowOptimal(int row){
        int[] result = new int[row+1];
        result[0] =1;
        for(int col=1; col<=row; col++){
            result[col]= (int)((long)result[col-1] * (row - col + 1) / col); 
        }

        return result;
    }

    //(C) Print complete Pascal's Triangle up to given number of rows.
    //Brute Force Approach - Time Complexity: O(r^3), Space Complexity: O(1)
    public static void printPascalTriangle(int numRows){
        for(int row=0; row<numRows; row++){
            for(int col=0; col<=row; col++){
                System.out.print(find_nCr(row, col)+" ");
            }
            System.out.println();
        }
    }

    //(C) Optimal Approach - Time Complexity: O(r^2), Space Complexity: O(r^2)
    public static void printPascalTriangleOptimal(int numRows){
        int[][] triangle = new int[numRows][numRows];
        for(int row=0; row<numRows; row++){
            triangle[row][0] =1;
            triangle[row][row] =1;

            for(int col=1; col<row; col++){
                triangle[row][col] = triangle[row-1][col-1] + triangle[row-1][col];
            }
        }

        //Printing the triangle
        for(int row=0; row<numRows; row++){
            for(int col=0; col<=row; col++){
                System.out.print(triangle[row][col]+" ");
            }
            System.out.println();
        }
    }
}
