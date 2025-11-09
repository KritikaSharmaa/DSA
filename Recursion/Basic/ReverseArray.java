package Recursion.Basic;

public class ReverseArray {
    public static void main(String[] args) {
        int[] nums ={1, 2, 3, 4, 5};
        reverse(0, nums.length-1, nums);
    }

    public static void reverse(int left, int right, int[] nums){
        if(left>=right){
            for(int r:nums) System.out.print(r+" ");
            return;
        }
        swap(left, right, nums);
        reverse(left+1, right-1, nums);
    }

    public static void swap(int left, int right, int[] nums){
        int temp = nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }
}
