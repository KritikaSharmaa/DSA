//Remove Duplicate from Sorted Doublly Linked List
package LinkedList.Medium;
class Node {
    int data;
    Node prev;
    Node next;

    Node(int data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class RemoveDuplicate {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 5};
        Node head = convertArrayToDoublyLinkedList(arr);        
        System.out.println("Original Doubly Linked List:");
        printDoublyLinkedList(head);
        head = removeDuplicates(head);
        System.out.println("Doubly Linked List after removing duplicates:");
        printDoublyLinkedList(head);
    }

    //Time Complexity: O(N) --> Each node is visited at most ONCE by nextNode and ONCE by curr.
    //Space Complexity: O(1)
    public static Node removeDuplicates(Node head){
       if(head == null) return null;

       Node curr = head;

       while(curr !=null && curr.next != null){
            Node nextNode = curr.next;

            while(nextNode != null && curr.data == nextNode.data){
                nextNode = nextNode.next;
            }

            curr.next = nextNode;
            if(nextNode != null){
                nextNode.prev = curr;
            }

            curr = curr.next;
       }

       return head;
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
