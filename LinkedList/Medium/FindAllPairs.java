package LinkedList.Medium;

import java.util.HashSet;

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

public class FindAllPairs {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Node head = convertArrayToDoublyLinkedList(arr);
        printDoublyLinkedList(head);

        int targetSum = 10;
        findAllPairsWithSum(head, targetSum);
    }

    //BRUTE FORCE APPROACH- TC: O(N) & SC: O(N)
    //public static void findAllPairsWithSum(Node head, int targetSum) {
    //    HashSet<Integer> set = new HashSet<>();
    //    Node curr = head;
//
    //    while (curr != null) {
    //        int complement = targetSum - curr.data;
//
    //        if (set.contains(complement)) {
    //            System.out.println("Pair Found: (" + curr.data + ", " + complement + ")");
    //        }
//
    //        set.add(curr.data);
    //        curr = curr.next;
    //    }
    //}

   //Optimal Approach- TC: O(N) & SC: O(1)
   public static void findAllPairsWithSum(Node head, int targetSum){
        Node left = head;
        Node right = head;

        while(right.next != null){
            right = right.next;
        }

        while(left != right && right.next != left){
            int currentSum = left.data + right.data;

            if(currentSum == targetSum){
                System.out.println("Pair Found: (" + left.data + ", " + right.data + ")");
                left = left.next;
                right = right.prev;
            }else if(currentSum < targetSum){
                left = left.next;
            }else{
                right = right.prev;
            }
        }
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
