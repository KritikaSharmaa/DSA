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

public class RemoveNthNode {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        Node head = convertArrayToLinkedList(arr);
        printLinkedList(head);
        Node newHead = removeNode(head, 1);
        printLinkedList(newHead);

    }

    public static Node removeNode(Node head, int n){
        if(head == null || n<=0){
            return head;
        }

        Node fast = head;
        Node slow = head;

        for(int i=0; i<n; i++){
            fast = fast.next;
        }

        if(fast == null){
            return head.next;
        }

        while (fast.next!=null) {
            slow = slow.next;
            fast = fast.next;
        }

        Node dlNode = slow.next;
        slow.next = slow.next.next;
        dlNode.next = null;

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
