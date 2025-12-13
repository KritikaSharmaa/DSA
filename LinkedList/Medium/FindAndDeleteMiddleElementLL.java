package LinkedList.Medium;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class FindAndDeleteMiddleElementLL {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Node head = convertArrayToLinkedList(arr);
        System.out.print("Original Linked List: ");
        printLinkedList(head);

        Node resNode = findMiddleElement(head);
        System.out.println("\nMiddle Element: "+resNode.data);

        Node newNode = deleteMiddleElement(head);
        System.out.print("Linked List post deletion: ");
        printLinkedList(newNode);
    }

    //OPTIMAL APPROACH : tortoise–hare technique
    //Time Complexity: O(N/2) ----> In each loop iteration, fast advances by 2 nodes, So the loop runs roughly n / 2 times.
    //Space Complexity: O(1)
    public static Node findMiddleElement(Node head){
        Node slow = head;   //will move by 1 pointer
        Node fast = head;   //will move by 2 pointer

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    //OPTIMAL APPROACH
    //Time Complexity: O(N/2)
    //Space Complexity: O(1)
    public static Node deleteMiddleElement(Node head){
        Node slow = head;
        Node fast = slow.next.next;

        //Doing above 2 steps -- we'll skip a slow's step and doing that will give us a node just before the middle node
        while (fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node temp = slow.next;
        slow.next = slow.next.next;
        temp.next = null;

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
    }


}
