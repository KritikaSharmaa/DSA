//Calculate how many times a sorted array is rotated
package Binary_Search;

public class CountRotations {
    public static void main(String[] args) {
        int[] arr = {15, 18, 19, 2, 3, 6, 12};
        System.out.println(count_rotations(arr));
    }

    public static int count_rotations(int[] arr){
        int low = 0;
	    int high = arr.length - 1;
	    int ridx = 0;
	
	    while(low<=high){
	        int mid = low + (high - low) / 2;

	        if(arr[low]<=arr[mid]){	    //left sorted
                if(arr[ridx]>arr[low])  ridx = low;
	    	    low = mid + 1;
	        }else{			            //right sorted
                if(arr[ridx]>arr[mid])  ridx = mid;
	    	    high =  mid - 1;
 	        }
	    }
	        return ridx;
    }

}
