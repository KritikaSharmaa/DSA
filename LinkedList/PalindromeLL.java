package LinkedList;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class PalindromeLL {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 1, 2, 1};
        Node head = convertArrayToLinkedList(arr);
        System.out.print("Linked List: ");
        printLinkedList(head);

        boolean isPalindrome = checkPalindrome(head);
        System.out.println("Is Palindrome: " + isPalindrome);
    }

    public static boolean checkPalindrome(Node head){
        Node slow = head;
	    Node fast = head;
        
	    while(fast.next!=null && fast.next.next!=null){
	    	slow = slow.next;
	    	fast = fast.next.next;
	    } 
    
	    Node newHead = reverseLL(slow.next);
	    Node first = head;
        Node sec = newHead;

	    while(sec != null){
	    	if(sec.data != first.data)
	    		return false;
	    	newHead = newHead.next;
            sec = sec.next;
            first = first.next;
	    }

	    reverseLL(newHead);

	    return true;
    }

    public static Node reverseLL(Node head){
        if(head == null || head.next == null) return head;
        Node newHead = reverseLL(head.next);
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
