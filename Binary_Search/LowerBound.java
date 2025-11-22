//Smallest index such that arr[idx]>=X
//Logic[IMP] --> Here we go in the direction of the result ******************
package Binary_Search;

public class LowerBound {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 5, 8, 8, 10, 10, 11}; 
        int x = 9;
        System.out.println(findLowerBound(arr, x));
    }

    public static int findLowerBound(int[] arr, int x){
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

}
