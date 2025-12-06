package LinkedList;

class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class ReverseDLL {
    public static void main(String[] args) {
        int[] arr = {1, 7, 32, 14, 5};
        Node head = convertArrayToDoublyLinkedList(arr);
        printDoublyLinkedList(head);
        Node reversedHead = reverse(head);
        printDoublyLinkedList(reversedHead);
    }

    // Function to reverse a doubly linked list
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public static Node reverse(Node head){
        if(head == null || head.next == null) return head;

        Node currNode = head;
        Node prevNode = null;

        while(currNode != null){
            prevNode = currNode.prev;
            currNode.prev = currNode.next;
            currNode.next = prevNode;

            currNode = currNode.prev;
        }

        return prevNode.prev;
    }

    public static Node convertArrayToDoublyLinkedList(int[] arr){
        Node head = new Node(arr[0]);
        Node tail = head;

        for(int i=1;i<arr.length; i++){
            Node newNode = new Node(arr[i]);
            tail.next = newNode;
            newNode.prev = tail;
            tail = tail.next;
        }
        return head;
    }

    public static void printDoublyLinkedList(Node head){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
