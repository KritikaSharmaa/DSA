package Stack;

import java.util.Stack;

public class PreviousSmallerElement {
    public static void main(String[] args) {
        int[] nums = {4, 12, 5, 3, 1, 2, 5, 3, 1, 2, 6, 8, 7};
        int[] result = previousSmallerElements(nums);
        for (int val : result) {
            System.out.print(val + " ");
        }
    }

    public static int[] previousSmallerElements(int[] nums){
        Stack<Integer> st = new Stack<>();

        int[] res = new int[nums.length];

        for(int i=0; i< nums.length; i++){
            while(!st.isEmpty() && st.peek() >= nums[i]){
                st.pop();
            }

            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(nums[i]);
        }

        return res;
    }
}
