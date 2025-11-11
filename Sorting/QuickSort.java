package Sorting;

import java.util.Arrays;
//Quick Sort follows Divide and Conqur technique-->> pick a element from start or end(pivot) and place to its correct place.
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 6, 5, 3};
        quick_sort(0, nums.length-1, nums);
        System.out.println("sorted: "+Arrays.toString(nums));
    }

    //Time Complexity - O(N*logn)
    //Space Complexity - O(1)
    //why need quick sort --->> merge & quick both has nlogn time complexity but quick is better bcz here space complexity is O(1).
    public static void quick_sort(int low, int high, int[] nums){
        if(low >= high) return;

        int p = findPartition(low, high, nums);

        quick_sort(low, p-1, nums);
        quick_sort(p+1, high, nums);
    }

    public static int findPartition(int low, int high, int[] nums){
        int pivot = nums[low];

        int l=low+1, r=high;

        while (l<r) {
            while (nums[l]<=pivot) l++;

            while(nums[r]> pivot) r--;

            Swap(l,r, nums);
           l++; r--;
        }

        Swap(low, l-1, nums);
        return r;
    }

    public static void Swap(int left, int right, int[] nums){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
