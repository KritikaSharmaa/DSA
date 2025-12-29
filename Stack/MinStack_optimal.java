package Stack;

import java.util.Stack;

public class MinStack_optimal {
    Stack<Integer> st;

    int minEle;

    public MinStack_optimal() {
        st = new Stack<>();
    }

    public void push(int val){
        if(st.isEmpty()){
            st.push(val);
            minEle = val;
        }else{
            if(val>=minEle)
                st.push(val);
            else{
                int stValue = 2 * val - minEle;
                st.push(stValue);
                minEle = val;
            }
        }
    }

    public void pop(){
        if(st.isEmpty())
            return;

        int top = st.pop();

        if(top < minEle){
            minEle = 2 * minEle - top;
        }
    }

    public int top(){
        if(st.isEmpty())
            return -1;

        int top = st.peek();

        if(top >= minEle)
            return top;
        else
            return minEle;
    }

    public int getMin(){
        if(st.isEmpty())
            return -1;

        return minEle;
    }
    public static void main(String[] args) {
        MinStack_optimal minStack = new MinStack_optimal();
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
