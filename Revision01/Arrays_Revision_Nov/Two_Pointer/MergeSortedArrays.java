//Merge nums1 and nums2 into a single array sorted in non-decreasing order.
package Revision01.Arrays_Revision_Nov.Two_Pointer;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] nums1={4,0,0,0,0,0};
        int m = 1;
        int[] nums2={1,2,3,5,6};
        int n= 5;
        merge(nums1, m, nums2, n);
    }
    
    //We call it Two Pointer technique because:
    //The main logic — the comparison and decision-making — happens between two pointers (i and j).
    //The third one (k) is just a helper index used to write results in-place — not part of the logical comparison.
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int t = m+n-1;

        while(j>=0){
            if(i>=0 && nums1[i]>nums2[j])
                nums1[t--] = nums1[i--];
            else nums1[t--] = nums2[j--];
        }

        for(int k=0;k<nums1.length;k++){
            System.out.print(nums1[k]);
        }
    }
}
