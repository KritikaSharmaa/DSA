package Recursion.Basic;

public class PrintName {
    public static void main(String[] args) {
        print_name(1, 5);
    }

    //Time Complexity - 
    //👉 Recursion = Repeated function calls (like loop iterations)
    //Each call does constant work (a print + one comparison) = And we make n such calls before stopping.
    //So total work = n × O(1) = O(n).

    //Space Complexity-
    //When you call a function recursively:
    //The current function pauses.
    //A new frame (memory block) is pushed to the call stack for the next call.
    //When the base case is hit, the functions return one by one (stack unwinds).
    //So even if you don’t declare any data structure,  
    //the recursion itself uses memory on the call stack.
    //Hence, for n recursive calls → O(n) stack space.
    
    public static void print_name(int counter, int num){
        if(counter>num) return;

        System.out.println("counter "+ counter +": "+"Kritika Sharma");
        print_name(++counter, num);
    }
}
