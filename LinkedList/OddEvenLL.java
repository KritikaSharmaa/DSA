package LinkedList;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class OddEvenLL {
    public static void main(String[] args) {
        int[] arr = {1, 7, 32, 14, 5, 8, 10};
        Node head = convertArrayToLinkedList(arr);
        printLinkedList(head);
        Node newHead = oddEvenList(head);
        printLinkedList(newHead);
    }

    public static Node oddEvenList(Node head){
        Node oddTail = head; // tail of odd list
        Node evenHead = head.next; // head of even list
        Node evenTail = head.next; // tail of even list

        while(evenTail != null && evenTail.next != null){
            oddTail.next = oddTail.next.next;
            evenTail.next = evenTail.next.next;

            oddTail = oddTail.next;
            evenTail = evenTail.next;
        }

        oddTail.next = evenHead;

        return head;
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
