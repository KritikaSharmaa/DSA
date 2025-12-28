package LinkedList.Medium;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SortLL {
    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 2, 5};
        Node head = convertArrayToLinkedList(arr);
        printLinkedList(head);
        Node newHead = sortLL(head);
        printLinkedList(newHead);
    }

    public static Node sortLL(Node head){
        if(head == null || head.next == null) return head;

        Node fast = head.next;
        Node slow = head;

        while (fast!=null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
        }

        Node rightHead = slow.next;
        slow.next = null;  

        Node left = sortLL(head);
        Node right = sortLL(rightHead);

        return merge2LL(left, right);
    }

    public static Node merge2LL(Node head1, Node head2){
        Node dummy = new Node(-1);
        Node tail = dummy;

        Node h1 = head1;
        Node h2 = head2;

        while (h1!=null && h2!=null) {
            if(h1.data<h2.data){
                tail.next = h1;
                h1 = h1.next;
            }else{
                tail.next = h2;
                h2 = h2.next; 
            }
            tail = tail.next;
        }
        if(h1!=null) tail.next = h1;
        if(h2!=null) tail.next = h2;

        return dummy.next;
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
