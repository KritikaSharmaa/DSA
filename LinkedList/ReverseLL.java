package LinkedList;

import java.util.Stack;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class ReverseLL {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        Node head = convertArrayToLinkedList(arr);
        System.out.print("Original Linked List: ");
        printLinkedList(head);

        // System.out.print("\nReversed Linked List (Brute Force): ");
        // Node reversedHead = brute_reverseLinkedList(head);
        // printLinkedList(reversedHead);

        // System.out.print("\nReversed Linked List (Optimal): ");
        // Node reversedHead2 = brute_reverseLinkedList(head);
        // printLinkedList(reversedHead2);

        System.out.print("\nReversed Linked List (Recursion): ");
        Node reversedHead3 = reverseLL_recursive(head);
        printLinkedList(reversedHead3);
    }

    // Brute Force Approach: Using Stack
    //Time Complexity: O(N)
    //Space Complexity: O(N)
    public static Node brute_reverseLinkedList(Node head){
        Stack<Integer> stack = new Stack<>();
        Node temp = head;

        while(temp != null){
            stack.push(temp.data);
            temp = temp.next;
        }

        temp = head;

        while(!stack.isEmpty()){
            temp.data = stack.pop();
            temp = temp.next;
        }

        return head;
    }

    //Optimal Approach: Reversing Pointers
    public static Node optimal_reverseLL(Node head){
        Node temp = head;
        Node prev = null;
        
        while(temp != null){
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev;
    }

    public static Node reverseLL_recursive(Node head){
        if(head == null || head.next == null) return head;

        Node newHead = reverseLL_recursive(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }

    public static Node convertArrayToLinkedList(int[] arr){
        Node head = new Node(arr[0]);
        Node tail = head;

        for(int i=1;i<arr.length;i++){
        	Node node = new Node(arr[i]);
        	tail.next= node;
        	tail= node;
        }
        return head;
    }

    public static void printLinkedList(Node head) {
        Node temp = head;
        while(temp != null){
        	System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

}
