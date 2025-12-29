package Stack;

import java.util.Stack;

public class PostFixToInfix {
    public static void main(String[] args) {
        String postfix = "ABCD^E-*+";
        System.out.println("Postfix: " + postfix);
        String infix = postfixToInfix(postfix);
        System.out.println("Infix: " + infix);
    }

    //Time Complexity: O(n) + O(n^2) for string concatenation in worst case --> O(n^2)
    //Space Complexity: O(n)
    public static String postfixToInfix(String postfix){
        Stack<String> st = new Stack<>();

        for(int i=0; i<postfix.length(); i++){
            char ch = postfix.charAt(i);

            if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9'))
                st.push(ch + "");   //push → O(1)
            else{
                String op1 = st.pop();  //pop → O(1)
                String op2 = st.pop();
                String exp = "(" + op2 + ch + op1 + ")";    //O(N1 + N2) --> N1 = length of first string, N2 = length of second string
                //BUT string concatenation is NOT O(1)--> Each time you concatenate strings: A new string is created & Cost depends on length of op1 + op2
                
                st.push(exp);
            }
        }
        return st.pop();
    }
}
