package Stack;

import java.util.Stack;

public class InfixToPrefixAndPostFix {
    public static void main(String[] args) {
        String infix = "A+B*(C^D-E)";
        System.out.println("Infix: " + infix);
        String prefix = infixToPrefix(infix);
        String postfix = infixToPostfix(infix);
        System.out.println("Prefix: " + prefix);
        System.out.println("Postfix: " + postfix);
    }

    public static String infixToPrefix(String infix){
        //STEP 1: REVERSE THE INFIX EXPRESSION
        String reverseInfix = "";

        for(int i=infix.length()-1; i>=0; i--){
            char ch = infix.charAt(i);
            if(ch == '('){
                reverseInfix += ')';
            }else if(ch == ')'){
                reverseInfix += '(';
            }else{
                reverseInfix += ch;
            }
        }
        System.out.println("Reversed Infix: " + reverseInfix);

        //STEP 2: GET THE POSTFIX OF REVERSED INFIX
        String postfix = infixToPostfix(reverseInfix);
        System.out.println("Postfix of Reversed Infix: " + postfix);

        //STEP 3: REVERSE THE POSTFIX TO GET PREFIX
        String prefix = "";
        for(int i=postfix.length()-1; i>=0; i--){
            prefix += postfix.charAt(i);
        }
        System.out.println("Reversed Postfix (Prefix): " + prefix);
        return prefix;

    }

    public static String infixToPostfix(String infix){
        Stack<Character> operands = new Stack<>();
        String res = "";
        // Implementation goes here
        for(int i=0; i<infix.length();i++){
            char ch = infix.charAt(i);

            if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')){
                res += ch;
            }else{
                if(operands.isEmpty()){
                    operands.push(ch);
                }else if(ch == '('){
                    operands.push(ch);
                }else if(ch == ')'){
                    while(!operands.isEmpty()){
                        char top = operands.pop();
                        if(top == '(') break;
                        res += top;
                    }
                }else if(getPrecedence(ch) <= getPrecedence(operands.peek())&& operands.peek() != '('){
                    char top = operands.pop();
                    res += top;
                    operands.push(ch);
                }else{
                    operands.push(ch);
                }
            }
        }

        while(!operands.isEmpty()){
            char top = operands.pop();
            res += top;
        }

        return res;
    }

    public static int getPrecedence(char ch){
        switch(ch){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
}
