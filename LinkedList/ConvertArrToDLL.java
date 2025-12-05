package LinkedList;

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

public class ConvertArrToDLL {
    public static void main(String[] args) {
        int[] arr = {1, 7, 32, 14, 5};
        Node head = convertArrayToDoublyLinkedList(arr);
        printDoublyLinkedList(head);
        Node newHead = DeletionAtKthPosition(head, 5);
        printDoublyLinkedList(newHead);
        Node insertHead = InsertAtPosition(head, 5, 99);
        printDoublyLinkedList(insertHead);
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

    public static Node DeletionAtKthPosition(Node head, int k){
        if(head == null ) return null;

        if(k == 1){
            head = head.next;
            if(head != null){
                head.prev = null;
            }
            return head;
        }
        Node current = head;
        int cnt = 1;
        while(current != null){
            if(cnt == k){
                if(current.next == null){
                    current.prev.next = null;
                }else{
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
            }
            current = current.next;
            cnt++;        
        }
        return head;
    }

    public static Node InsertAtPosition(Node head, int position, int element){
        Node newNode = new Node(element);

        if(position == 0){
            if(head != null){
                newNode.next = head;
                head.prev = newNode;
            }
            head = newNode;
            return head;
        }
        Node current = head;
        int cnt = 0;
        while(current.next != null){
            if(cnt == position){
                current.prev.next = newNode;
                newNode.prev = current.prev;
                newNode.next = current;
                current.prev = newNode;
                return head;
            }
            current = current.next;
            cnt++;
        }
        current.next = newNode;
        newNode.prev = current;

        return head;
    }
}
