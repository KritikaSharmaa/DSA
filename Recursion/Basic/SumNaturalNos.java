//Sum of First N Natural Numbers.
package Recursion.Basic;

public class SumNaturalNos {
    public static void main(String[] args) {
        //Pattern 1
        findSum(0, 3);

        //Pattern 2
        System.out.println(findSum(3));
    }   

    //Pattern 1 - Parametrized way
    public static void findSum(int sum, int num){
        if(num==0){
            System.out.println(sum);
            return;
        }
        findSum(sum+num, num-1);
    }

    //Pattern 2 - Fuctional way
    public static int findSum(int num){
        if(num==0) return 0;
        return num + findSum(num-1);
    }
}
