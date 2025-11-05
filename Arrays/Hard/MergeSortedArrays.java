package Hard;

import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {0, 2, 6, 8, 9};
        merge(nums1, 4, nums2, 5);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i=m-1;
        int j=0;

        while(i<m && j<n){
            if(nums1[i]>nums2[j]){
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;

                i--;
                j++;
            }else break;
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        for(int a=0; a<m; a++){
            System.out.print(nums1[a]+" ");
        }

        for(int b=0; b<n; b++){
            System.out.print(nums2[b]+" ");
        }
    }
}
