package Revision01.Arrays_Revision_Nov.Two_Pointer;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] nums1={1,2,3,0,0,0};
        int m = 3;
        int[] nums2={2,5,6};
        int n= 3;
        merge(nums1, m, nums2, n);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m!=0 && n!=0){
            int i=0, j=0;
            while (i<m && j<n) {
                if(nums1[i]<=nums2[j]){
                    i++;
                    continue;
                }
                int temp = nums1[i];
                nums1[i]=nums2[j];
                nums2[j]=temp;
                i++;
                j++;
                System.out.println(i+" "+j);
            }

            int k=0;
            while(k<n){
                nums1[i]=nums2[k];
                i++;
                k++;
            }
        }else if(m==0){
            for(int j=0; j<n; j++){
                nums1[j]=nums2[j];
            }
        }
    
        print(nums1);

    }

    public static void print(int[] arr){
        for(int i =0 ;i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
