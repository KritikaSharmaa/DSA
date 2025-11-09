package Medium;

public class DefuseBomb_slidingWindow {
    public static void main(String[] args) {
        //Test Case 1 --------> output: 0,0,0
        //int[] code={1,2,3}; int k=0; 

        //Test Case 2------------> 12, 16, 10, 13
        //int[] code = {5, 1, 7, 4}; int k=3; 

        //Test Case 3 --------> 12, 5, 6, 13
        int[] code = {2,4,9,3}; int k=-2;
        int[] res = decrypt(code, k);
        for(int r:res)
            System.out.print(r+" ");
    }

     public static int[] decrypt(int[] code, int k) {
        int[] res = new int[code.length];
        if (k == 0) return res;
        //Define the initial window and initial sum
        int start = 1, end = k, sum = 0;
        if (k < 0) {//If k < 0, the starting point will be end of the array.
            k = -k;
            start = code.length - k;
            end = code.length - 1;
        }
        for (int i = start; i <= end; i++) sum += code[i];
        //Scan through the code array as i moving to the right, update the window sum.
        for (int i = 0; i < code.length; i++) {
            res[i] = sum;
            sum -= code[(start++) % code.length];
            sum += code[(++end) % code.length];
        }
        return res;
    }
}
