//Given an integer array nums, sorted in ascending order (with distinct values) and a target value k. 
//The array is rotated at some pivot point that is unknown. Find the index at which k is present and if k is not present return -1.
package Binary_Search;

public class SearchInRotatedArray {
    public static void main(String[] args) {
        int[] nums = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        int k = 1;
        System.out.println(SearchTarget(nums, k));
    }

    public static int SearchTarget(int[] nums, int k){
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] == k)
                return mid;
            else if(nums[low]<=nums[mid]){  //Left space sorted
                if(nums[low]<= k && k < nums[mid])
                    high = mid - 1;
                else low = mid + 1;
            }
            else if(nums[mid]<nums[high]){  //Right space sorted
                if(nums[mid]<k && k<=nums[high])
                    low = mid + 1;
                else high = mid - 1;
            }
        }

        return -1;
    }
}
