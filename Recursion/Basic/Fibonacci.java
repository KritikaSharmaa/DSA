package Recursion.Basic;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("Fibonacci using Arrays- "+ Fibonacci_array(5));
        System.out.println("Fibonacci using Recursion- "+ Fibonacci_rec(5) );

    }

    //By Using Array
    //Time Complexity: O(N)
    public static int Fibonacci_array(int num){
        int[] r = new int[num+1];
        r[0]=0;
        r[1]=1;
        for(int i=2; i<=num;i++)
            r[i] = r[i-1]+r[i-2];

        return r[num];
    }

    //By Using Recursion
    //Time Complexity - O(2ⁿ)--->Exponential (repeats subproblems)
    //Each function call makes 2 more calls (except base cases). So the number of calls roughly doubles with each level of recursion.
    public static int Fibonacci_rec(int num){

        if(num<=1) return num; 
        
        return Fibonacci_rec(num-1) + Fibonacci_rec(num-2);
    }
}
