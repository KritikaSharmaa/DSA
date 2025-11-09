package Recursion.Basic;

public class PrintLinear {
    public static void main(String[] args) {
      LinearPrint(5);
    }

    //public static int LinearPrint(int num){
    //    if(num==1) return num;
    //    LinearPrint(--num);
    //    System.out.println(num);
    //    return num+1;
    //}
    
    //Recursion + Backtracking
    public static void LinearPrint(int num){
        if(num<1) return;
        LinearPrint(num-1);
        System.out.println(num);

    }
}
