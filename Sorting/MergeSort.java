package Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 6, 5, 3};
        Sort(0, nums.length-1, nums);
        System.out.println("Sorted: "+ Arrays.toString(nums));
    }

    //Time Complexity - O(N * LogN)
    //Space Complexity  - O(N)
    public static void Sort(int low, int high, int[] nums){
        if(low>=high) return;

        int mid = (low + high)/2;

        // Step 1: Divide (recursively sort two halves)
        Sort(low, mid, nums);
        Sort(mid+1, high, nums);
        
        // Step 2: Conquer (merge the two sorted halves)
        Merge(nums, low, mid, high);
    }

    public static void Merge(int[] nums, int left, int mid, int right){
        //calculate length for creating temp arrays - L & R.
        int n1= mid-left+1;
        int n2= right-mid;

        //temp arrays created.
        int[] L = new int[n1];
        int[] R = new int[n2];

        //copy the element from num to these new temp arrays
        for(int i=0; i<n1; i++)
            L[i]=nums[left+i];

        for(int j=0; j<n2; j++)
            R[j]=nums[mid+1+j];
        
        // Merge the temp arrays back into arr[]
        int p1=0, p2=0, k=left;
        while (p1<n1 && p2<n2) {
            if(L[p1]<=R[p2])
                nums[k++] = L[p1++];
            else nums[k++] = R[p2++];
        }

        //copying remaining elements
        while(p1<n1)
            nums[k++]=L[p1++];
        
        while (p2<n2) 
            nums[k++]=R[p2++];

    }
}
