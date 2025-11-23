//Given an array arr of integers. A peak element is defined as an element greater than both of its neighbors.
//Formally, if arr[i] is the peak element, arr[i - 1] < arr[i] and arr[i + 1] < arr[i].
//Find the index(0-based) of a peak element in the array. If there are multiple peak numbers, return the index of any peak number.

//Constraints:
//1 <= arr.length <= 1000
//-231 <= arr[i] <= 231 - 1
// arr[i] != arr[i + 1] for all valid i.
//For arr[0], its left element can be considered as -∞
//For arr[n-1], its right element can be considered as -∞
package Binary_Search;

public class FindPeakElement {
    public static void main(String[] args) {
        int[] arr ={1, 2, 3, 4, 5, 6, 7, 8, 5, 1};
        System.out.println("idx: "+findPeakElement(arr));
    }

    public static int findPeakElement(int[] arr){
        if(arr[0]>arr[1]) return 0;
        if(arr[arr.length-1]>arr[arr.length-2]) return arr.length-1;

        int low = 1;
        int high = arr.length - 2;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(arr[mid] > arr[mid - 1] && arr[mid] > arr [mid + 1]){
                return mid;
            }

            if(arr[low] < arr[mid]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return -1;
    }

}
