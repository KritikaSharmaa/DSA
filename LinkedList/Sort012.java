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

public class Sort012 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 0, 1, 2, 1, 0};
        Node head = convertArrayToLinkedList(arr);
        printLinkedList(head);
        Node b_sortedHead = brute_sort012(head);
        printLinkedList(b_sortedHead);

        Node opt_sortedHead = optimal_sort012(head);
        System.out.println("Optimal Approach:");
        printLinkedList(opt_sortedHead);
    }


    //Optimal Approach: Create 3 dummy linked lists for 0s, 1s and 2s.
    //Traverse the given linked list and attach nodes to respective lists.
    //Finally, connect these 3 lists.
    //Time Complexity: O(N)
    public static Node optimal_sort012 (Node head){
        Node zeroHead= new Node(-1);
        Node oneHead= new Node(-1);
        Node twoHead= new Node(-1);

        Node zerotail = zeroHead;
        Node onetail = oneHead;
        Node twotail = twoHead;
        
        Node temp = head;

        while(temp != null){
            if(temp.data == 0){
                zerotail.next = temp;
                zerotail = zerotail.next;
            }else if(temp.data == 1){
                onetail.next = temp;
                onetail = onetail.next;
            }else{
                twotail.next = temp;
                twotail = twotail.next;
            }
            temp = temp.next;
        }

        zerotail.next = oneHead.next;
        onetail.next = twoHead.next;
        twotail.next = null;

        return zeroHead.next;

    }

    //Brute Approach: Count number of 0s, 1s and 2s in first traversal.
    //In second traversal, update the linked list with 0s, then 1s and then 2s.
    //Time Complexity: O(2N) ~ O(N)
    //Space Complexity: O(1)
    public static Node brute_sort012 (Node head){
        
        int count0 = 0, count1 = 0, count2 = 0;

	    Node temp = head;

	    while(temp != null){
	    	if(temp.data == 0) count0++;
	    	else if(temp.data == 1) count1++;
	    	else count2++;

	    	temp = temp.next;
	    }
    
	    temp = head;
	    while(temp != null){
	    	if(count0>0){
	    		temp.data = 0;
	    		count0--;
	    	}else if(count1>0){
	    		temp.data = 1;
	    		count1--;
	    	}else{
	    		temp.data = 2;
	    		count2--;
	    	}
            temp = temp.next;
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
