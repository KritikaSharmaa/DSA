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

public class DeleteKeyDLL {
    public static void main(String[] args) {
        int[] arr = {10, 4, 10, 10, 6, 10};
        Node head = convertArrayToDoublyLinkedList(arr);
        printDoublyLinkedList(head);

        Node newHead = DeleteKey(head, 10);
        printDoublyLinkedList(newHead);

    }

    public static Node DeleteKey(Node head, int key){
        Node current = head;

        while(current!=null){
            if(current.data == key){
                if(current == head){
                    head = head.next;
                    if(head != null){
                        head.prev = null;
                    }
                    current = head;
                }else{
                    current.prev.next = current.next;
                    if(current.next != null){
                        current.next.prev = current.prev;
                    }
                    current = current.next;
                }
            }else{
                current = current.next;
            }
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
