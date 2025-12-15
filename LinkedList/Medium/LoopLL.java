package LinkedList.Medium;

import java.util.HashMap;
import java.util.HashSet;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LoopLL {
    public static void main(String[] args) {
       // Creating nodes
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Creating loop: 5 -> 3
        head.next.next.next.next.next = head.next.next;

    //DETECT CYCLE--------------------------------------
    //     System.out.println(hasCycle_brute(head));
    //     System.out.println(hasCycle_optimal(head));

    //FIND LENGTH OF LOOP-------------------------------
        //System.out.println(findLoopLength_brute(head));
        //System.out.println(findLoopLength_optimal(head));

    //FIRST NODE OF A LOOP------------------------------
        //Node res = findFirstNodeInLoop_brute(head);
        Node res2 = findFirstNodeInLoop_optimal(head);
        System.out.println(res2.data);

    //CASE: No loop present
        int[] arr = {1, 2, 3, 4, 5};
        Node head2 = convertArrayToLinkedList(arr);

        //Detect LL has Cycle?
        //System.out.println(hasCycle_brute(head));
        //System.out.println(hasCycle_optimal(head2));
    }
    
    //1. Detect if loop exists -----------------------------------------------------------------------------
    //BRUTE FORCE ----> TC: O(N) + O(1){Hashmap op} ~ O(N) & SC: O(N)
    public static Boolean hasCycle_brute(Node head){
        HashMap<Node, Integer> mpp = new HashMap<>();

        Node temp = head;

        while(temp.next != null){
            if(mpp.containsKey(temp)){
                return true;
            }
            mpp.put(temp, 1);
            temp = temp.next;
        }

        return false;
    }

    //OPTIMAL APPROACH ----> TC: O(N) & SC: O(1)
    public static Boolean hasCycle_optimal(Node head){
        Node slow = head;
        Node fast = head;

        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return true;
        }

        return false;
    }


    //2. Find Length of the loop in the LL ---------------------------------------------------------------
    //BRUTE FORCE----> TC: O(N) + O(1){Hashmap ops} ~ O(N) & SC: O(N)
    //Using HashSet, we find the any node present in cycle and then calculate the length
    public static int findLoopLength_brute(Node head){
        HashSet<Node> hset = new HashSet<>();
        Node temp = head;

        while(temp != null){
            if(hset.contains(temp)){
                Node start_pt = temp;
                int count = 0;
                do{
                    temp = temp.next;
                    count++;
                }while(temp!=start_pt);

                return count;
            }

            hset.add(temp);
            temp = temp.next;
        }

        return -1;
    }

    public static int findLoopLength_optimal(Node head){
        Node slow = head;
        Node fast = head;

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                int count = 1;
                fast = fast.next;
                while(fast != slow){
                    count++;
                    fast= fast.next;
                }
                return count;
            }
        }
        return -1;
    }
    
    //3. Find First Node of a LL --------------------------------------------------------------------------
    //BRUTE FORCE ----> TC: O(N)+O(1){Hashset ops} ~ O(N) & SC: O(N)
    public static Node findFirstNodeInLoop_brute(Node head){
        HashSet<Node> hset = new HashSet<>();
        Node temp = head;

        while(temp!=null){
            if(hset.contains(temp)){
                return temp;
            }
            hset.add(temp);
            temp = temp.next;
        }
        return null;
    }

    public static Node findFirstNodeInLoop_optimal(Node head){
        Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow ==  fast){
                slow = head;
                while(slow != fast){
                    slow= slow.next;
                    fast= fast.next;

                    if(slow == fast) return slow;
                }
                return slow;
            }
        }

        return null;
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
