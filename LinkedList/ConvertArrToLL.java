package LinkedList;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ConvertArrToLL {
    public static void main(String[] args) {
        int[] arr = {1, 7, 32, 14, 5};
        Node head = convertArrayToLinkedList(arr);
        // System.out.println("Head of the linked list: " + head.data);
        // printLinkedList(head);
        // printLength(head);
        // boolean isfound = searchInLinkedList(head, 3);
        // System.out.println("Is value found in linked list? " + isfound);
        // Node newHead = DeleteKthNode(head, 5);
        // printLinkedList(newHead);
        // Node newHead2 = DeleteElement(head, 14);
        // printLinkedList(newHead2);
        Node insertHead = InsertAtPosition(head, 0, 99);
        printLinkedList(insertHead);
    }

    //Convert Array to Linked List
    //Time Complexity: O(N)
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

    //Traverse and print linked list
    //Time Complexity: O(N)
    public static void printLinkedList(Node head) {
        Node temp = head;
	    while(temp != null){
	    	System.out.print(temp.data+" ");
            temp = temp.next;
	    }
        System.out.println();
    }

    //Calculate and print length of linked list
    //Time Complexity: O(N)
    public static void printLength(Node head) {
        Node temp = head;
        int length = 0;
        while(temp != null){
            length++;
            temp = temp.next;
        }
        System.out.println("Length of linked list: " + length);
    }

    //Search for a value in linked list
    //Time Complexity: O(N)
    public static boolean searchInLinkedList(Node head, int search) {
        Node temp = head;
        while(temp != null){
            if(temp.data == search){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    //Delete Kth Node from linked list
    //Time Complexity: O(N)
    public static Node DeleteKthNode(Node head, int k){
	    if(k==1){
	    	Node temp = head;
	    	head = temp.next;
	    	temp.next=null;
	    	return head;
	    }

	    int cnt = 0;
	    Node curr = head;
	    Node prev = null;

	    while(curr != null){
            cnt++;
	    	if(cnt == k){
	    		prev.next = curr.next;
	    		curr.next = null;
                break;
	    	}
	    	prev=curr;
	    	curr = curr.next;
	    }
        return head;
    }

    public static Node DeleteElement(Node head, int el){
	    if(head.data==el){
	    	Node temp = head;
	    	head = temp.next;
	    	temp.next=null;
	    	return head;
	    }

	    Node curr = head;
	    Node prev = null;

	    while(curr != null){
	    	if(curr.data == el){
	    		prev.next = curr.next;
	    		curr.next = null;
                break;
	    	}
	    	prev=curr;
	    	curr = curr.next;
	    }
        return head;
    }

    //Insert element at given position in linked list
    //Time Complexity: O(N)
    public static Node InsertAtPosition(Node head, int position, int element){
        Node newNode = new Node(element);

        if(position == 0){
            newNode.next = head;
            return newNode;
        }
        Node curr = head;
        int cnt = 1;
        while(curr != null){
            if(cnt == position - 1){
                newNode.next = curr.next;
                curr.next = newNode;
                break;
            }
            curr = curr.next;
            cnt++;
        }
        if(cnt == position - 1){
            curr.next = newNode;
        }

        return head;
    }
}
