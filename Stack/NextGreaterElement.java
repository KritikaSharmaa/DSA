package Stack;

import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] nums = {4, 12, 5, 3, 1, 2, 5, 3, 1, 2, 6, 8, 7};
        int[] result = nextGreaterElements(nums);
        for (int val : result) {
            System.out.print(val + " ");
        }
    }

    //Time Complexity: O(n) + O(n) ~ O(n) -> for traversing the array and for popping elements from stack(at max each element will be popped once hece o(n))
    //Space Complexity: O(n) + O(n) ~ O(n) -> for the stack and result array
    public static int[] nextGreaterElements(int[] nums){
        Stack<Integer> st = new Stack<>();
        int[] res = new int[nums.length];

        for(int i = nums.length - 1; i >= 0; i--){
           if(st.isEmpty()){
            res[i] = -1;
            }else{
                while(!st.isEmpty() && st.peek() <= nums[i]){
                     st.pop();
                }
                if(st.isEmpty()) res[i] = -1;
                else res[i] = st.peek();
            }
            st.push(nums[i]);
        }

        return res;
    }
}
