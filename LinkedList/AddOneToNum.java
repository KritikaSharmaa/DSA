package LinkedList;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class AddOneToNum {
    public static void main(String[] args) {
        int[] arr = {9, 9, 9};
        Node head = convertArrayToLinkedList(arr);
        System.out.print("Original Linked List: ");
        printLinkedList(head);

        // Node newHead = addOneToNum(head);
        // System.out.print("Linked List after adding one: ");
        // printLinkedList(newHead);

        Node newHead2 = recursion_addOneToNum(head);
        System.out.println("\nLinked List after adding one using recursion: ");
        printLinkedList(newHead2);
    }

    //Better Approach --> Using Recursion to add one from the end of linked list in O(N). We'll take help from backtrack to move in LL in opp direction in O(N)
    //During recursion:Going down (function calls):
    //At each step you move from head → head.next
    //You do this exactly N times
    //Coming up (returning):
    //The call stack unwinds
    //But it does NOT revisit the nodes again via pointers
    //It only returns through already-created stack frames
    //The “return phase” does not traverse the list.
    //It only pops from the call stack, which is O(1) per frame.
    public static Node recursion_addOneToNum(Node head){
        int carry = helper(head);

	    if(carry == 1){
	    	Node newnode = new Node(carry);
	    	newnode.next = head;
	    	head = newnode;
	    }  
    
	    return head;
    }

    public static int helper(Node head){
	if(head == null) return 1;

	int carry = helper(head.next);
	int sum = head.data + carry;
	head.data= sum % 10;
	return sum / 10;

    }

    //Brute Force Approach --> Carrying out addition from the end of linked list is not possible directly. So, we reverse the linked list first, 
    //then add one to the number, and again reverse the linked list to restore original order.
    //Time Complexity: O(N) + O(N) + O(N) = O(3N)
    //Space Complexity: O(1)
    public static Node addOneToNum(Node head){
        Node newhead = reverseLL(head);     //Reversing the linked list --> TC: O(N)
	    Node temp = newhead;
	    int carry = 1;
        
	    while(carry != 0 && temp!=null){    //TC: O(N)
	    	int sum = temp.data + carry;
	    	carry = sum / 10;
	    	temp.data = sum % 10;
	    	temp = temp.next;
        
	    }
        
	    Node newhead2 = reverseLL(newhead);  //Reversing back the linked list to restore original order --> TC: O(N)
    
        if(carry == 0) return newhead2;

	    Node newNode = new Node(carry);
	    newNode.next = newhead2;
	    head = newNode;
    
	    return head;

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
    }


}
