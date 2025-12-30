package Stack;
import java.util.Stack;

// The next greater element for an element x is the first element greater than x 
// that we come across while traversing the array in a clockwise manner.
// Input:arr[3, 10, 4, 2, 1, 2, 6, 1, 7, 2, 9]
// Output:  [10, -1, 6, 6, 2, 6, 7, 7, 9, 9, 10]
public class NextGreaterElementII {
    public static void main(String[] args) {
        int[] arr = {3, 10, 4, 2, 1, 2, 6, 1, 7, 2, 9};
        int[] result = nextGreaterElements(arr);
        for (int val : result) {
            System.out.print(val + " ");
        }
    }

    //Time Complexity: O(2n) + O(2n) ~ O(n) -> for traversing the array twice and for popping elements from stack(at max each element will be popped once hence o(n))
    //Space Complexity: O(2n) + O(n) ~ O(n) -> for the stack O(2n) and result array O(n)
    public static int[] nextGreaterElements(int[] nums){
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 2 * n - 1; i >= 0; i--){    //TC: O(2n) 
            int index = i % n;
            while(!st.isEmpty() && st.peek() <= nums[index]){   //TC: O(2n) in total each element will be pushed and popped once
                st.pop();
            }
            if(i < n){
                res[index] = st.isEmpty() ? -1 : st.peek();
            }
            st.push(nums[index]);
        }

        return res;
    }


}
