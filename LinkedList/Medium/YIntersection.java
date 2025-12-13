//https://takeuforward.org/plus/dsa/problems/find-the-intersection-point-of-y-ll
//Given the heads of two linked lists A and B, containing positive integers. Find the node at which the two linked lists intersect. 
//If they do intersect, return the node at which the intersection begins, otherwise return null.
package LinkedList.Medium;

import java.util.HashMap;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class YIntersection {
    public static void main(String[] args) {
        // Common part (intersection)
        Node common = new Node(4);
        common.next = new Node(5);

        // List A: 1 -> 2 -> 3 -> 4 -> 5
        Node headA = new Node(1);
        headA.next = new Node(2);
        headA.next.next = new Node(3);
        headA.next.next.next = common;

        // List B: 7 -> 8 -> 4 -> 5
        Node headB = new Node(7);
        headB.next = new Node(8);
        headB.next.next = common;

        System.out.print("BRUTE CASE: Intersection pt: ");
        Node iNode1 = findInterSection_brute(headA, headB);
        System.out.print(iNode1!=null? iNode1.data:"null");


        System.out.print("\nOPTIMAL CASE: Intersection pt: ");
        Node iNode2 = findInterSection(headA, headB);
        System.out.print(iNode2!=null? iNode2.data:"null");
    }

    public static Node findInterSection_brute(Node headA, Node headB){
        HashMap<Node, Integer> mpp = new HashMap<>();

        Node t1 = headA;
        while(t1 != null){
            mpp.put(t1, 1);
            t1 = t1.next;
        }

        Node t2 = headB;
        while(t2 != null){
            if(mpp.containsKey(t2)){
                return t2;
            }
            t2 = t2.next;
        }

        return null;
    }

    //Optimal Approach
    //Time Complexity: O(M+N)
    //Space Complexity: O(N)
    public static Node findInterSection(Node HeadA, Node HeadB){
        Node t1 = HeadA;
        Node t2 = HeadB;

        while(t1 != t2){

            t1 = t1.next;
            t2 = t2.next;
            
            if(t1 == t2) return t1;

            if(t1 == null) t1 = HeadB;
            if(t2 == null) t2 = HeadA;
           
        }

        return t1;
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
