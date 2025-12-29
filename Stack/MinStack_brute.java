package Stack;

import java.util.Stack;

class Pair {
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

public class MinStack_brute {
    Stack<Pair> st;

    public MinStack_brute() {
        st = new Stack<>();
    }

    //Time Complexity: O(1)
    //Space Complexity: O(2N) --> O(n) for n elements in stack + O(n) for storing min values
    public void push(int val){
        if(st.isEmpty()){
            st.push(new Pair(val, val));
        }else{
            st.push(new Pair(val, Math.min(val, getMin())));
        }
    }    

    //Time Complexity: O(1)
    //Space Complexity: O(1)
    public void pop(){
        if(!st.isEmpty()){
            st.pop();
        }
    }

    //Time Complexity: O(1)
    //Space Complexity: O(1)
    public int top(){
        if(!st.isEmpty()){
            return st.peek().first;
        }
        return -1; //or throw exception
    }

    //Time Complexity: O(1)
    //Space Complexity: O(1)
    public int getMin(){
        if(!st.isEmpty()){
            return st.peek().second;
        }
        return -1; //or throw exception
    }

    public static void main(String[] args) {
        MinStack_brute minStack = new MinStack_brute();
        minStack.push(3);
        minStack.push(5);
        System.out.println("Top: " + minStack.top());      // Returns 5
        System.out.println("Min: " + minStack.getMin());   // Returns 3
        minStack.push(2);
        minStack.push(1);
        System.out.println("Min: " + minStack.getMin());   // Returns 1
        minStack.pop();
        System.out.println("Min: " + minStack.getMin());   // Returns 2
        minStack.pop();
        System.out.println("Top: " + minStack.top());      // Returns 5
        System.out.println("Min: " + minStack.getMin());   // Returns 3
    }
}
