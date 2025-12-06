package LinkedList;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class AddTwoNums {
    public static void main(String[] args) {
        Node head1 = convertArrayToLinkedList(new int[]{2, 8});
        Node head2 = convertArrayToLinkedList(new int[]{3, 8, 9, 9});
        Node resultHead = addTwoNumbers(head1, head2);
        printLinkedList(resultHead);
    }

    public static Node addTwoNumbers(Node l1, Node l2){
        int sum = 0;
        Node cnode1= l1;
        Node cnode2 = l2;
	    Node prevNode = null;
        Node head = null;

        while(cnode1 != null || cnode2 !=null){
         
            sum+= ((cnode1==null? 0 :cnode1.data) + (cnode2==null? 0 :cnode2.data));  
                
            Node newNode = new Node(sum % 10);

            if(sum>9)	sum = sum / 10;
		    else	sum = 0;

            if(prevNode == null){
                head = newNode;
                prevNode = newNode;
            }else{
                prevNode.next = newNode;
                prevNode = newNode;
            }
	        
            if(cnode1!=null) cnode1 = cnode1.next;
	        if(cnode2!=null) cnode2 = cnode2.next;
        }

        if(cnode1 ==null && cnode2==null && sum > 0){
            Node newNode = new Node(sum);
            prevNode.next = newNode;
        }

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
