package Hard;

import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {0, 2, 6, 8, 9};
        merge(nums1, 4, nums2, 5);
    }

    //******************************************Optimal Solution -1**********************************************************
    //Time Complexity - O(Max(m, n)) + O(nLogn) + O(mLogm)
    //Space Complexity -  O(1)
    //public static void merge(int[] nums1, int m, int[] nums2, int n) {
//
    //    int i=m-1;
    //    int j=0;
//
    //    while(i<m && j<n){
    //        if(nums1[i]>nums2[j]){
    //            int temp = nums1[i];
    //            nums1[i] = nums2[j];
    //            nums2[j] = temp;
//
    //            i--;
    //            j++;
    //        }else break;
    //    }
    //    Arrays.sort(nums1);
    //    Arrays.sort(nums2);
//
    //    for(int a=0; a<m; a++){
    //        System.out.print(nums1[a]+" ");
    //    }
//
    //    for(int b=0; b<n; b++){
    //        System.out.print(nums2[b]+" ");
    //    }
    //}


    //******************************************Optimal Solution -2 (Using Gap Method) ******************************************************** */
    //Time Complexity - O(log base 2 n+m) * O(n+m) [log base 2 bcaz length/2 each time thats why base 2 if divided by 3 log base 3]
    //Space Complexity - O(1)
    public static void merge(int[] nums1, int n, int[] nums2, int m){
        int len = n+m;
        int gap = len/2 + len%2;

        while(gap>0){
            int left=0;
            int right = left + gap;

            while (right<len) {
                System.out.println(left+" --> "+right);
                if(left<n && right>=n){
                    if(nums1[left]>nums2[right-n]){
                        SwapIfGreater(nums1, left, nums2, right-n);
                    }
                }else if(left>=n){
                    if(nums2[left-n]>nums2[right-n]){
                        SwapIfGreater(nums2, left-n, nums2, right-n);
                    }
                }
                    left++;
                    right++;
            }

            if(gap==1)
                break;

            gap = gap/2 + gap%2;
        }

        for(int i=0;i<nums1.length;i++){
            System.out.print(nums1[i]+" ");
        }
        for(int j=0; j<nums2.length; j++){
            System.out.print(nums2[j]+" ");
        }
    }

    public static void SwapIfGreater(int[] arr1, int left, int[] arr2, int right){
        int temp = arr1[left];
        arr1[left] = arr2[right];
        arr2[right] = temp;
    }
}
