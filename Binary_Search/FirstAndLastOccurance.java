//Find First and Last Occurance of a given number in a sorted array
//To find the first and last occurrence of a target in a sorted array, we use Binary Search twice:
// First binary search → find the first (leftmost) index
// Second binary search → find the last (rightmost) index

package Binary_Search;

import java.util.Arrays;

public class FirstAndLastOccurance {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 8, 8, 11, 13};
        int x = 8;
        System.out.println(Arrays.toString(findFirstAndLastIdx(arr, x)));
    }

    public static int[] findFirstAndLastIdx(int[] arr, int x){
        int firstIdx = findFirstIdx(arr, x);
        int lastIdx = findLastIdx(arr, x);
        return new int[] {firstIdx, lastIdx};
    }

    public static int findFirstIdx(int[] arr, int x){
        int low = 0;
        int high = arr.length-1;
        int res = arr.length;

        while(low<=high){
            int mid = low + (high-low)/2;

            if(arr[mid]>=x){
                res=mid;
                high=mid-1;
            }else low = mid + 1;

        }

        return res;
    }

    public static int findLastIdx(int[] arr, int x){
        int low = 0;
        int high = arr.length-1;
        int res = arr.length;

        while(low<=high){
            int mid = low + (high-low)/2;

            if(arr[mid]<=x){
                res=mid;
                low=mid + 1;
            }else high = mid - 1;

        }

        return res;
    }
}
