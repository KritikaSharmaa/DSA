package LinkedList.Medium;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6,7,8};
        Node head = convertArrayToLinkedList(arr);
        int k = 3;
        System.out.println("Original Linked List:");
        printLinkedList(head);
        head = reverseKGroup(head, k);
        System.out.println("Linked List after reversing in groups of " + k + ":");
        printLinkedList(head);
    }

    public static Node reverseKGroup(Node head, int k){
        Node start = head;
        Node prevLast = null;

        while (start != null) {
            Node KthNode = getKthNode(start, k);
            if (KthNode == null) {
                if(prevLast != null){
                    prevLast.next = start;
                }
                break; // Less than k nodes remaining
            }

            Node nextNode = KthNode.next;
            KthNode.next = null; // Temporarily terminate the current group

            reverseLL(start, KthNode);
            
            if(start == head){
                head = KthNode; // Update head for the first group
            }else{
                prevLast.next = KthNode; // Connect previous group to current
            }

            prevLast = start; // 'start' is now the last node of the reversed group
            start = nextNode; // Move to the next group
        }

        return head;
    }

    public static Node getKthNode(Node start, int k){
        Node curr = start;
        for(int i=1; i<k; i++){
            if(curr == null) return null;
            curr = curr.next;
        }
        return curr;
    }

    public static Node reverseLL(Node start, Node end){
        Node prev = null;
        Node curr = start;
        Node stop = end.next;   // important

        while(curr != stop){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev; // new head of reversed group
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
