//Same as part one, only thing is - duplicates are allowed here.
//Also here we dont need to send index, instead true if k exists else false.
package Binary_Search;

public class SearchInRotatedArrayII {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 3, 3, 3, 3, 3};  //Rotated + Sorted
        int k = 1;  //element to be searched
        System.out.println(SearchElement(nums, k));
    }

    public static boolean SearchElement(int[] nums, int k){
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == k){
                return true;
            }
            if(nums[low]==nums[mid] && nums[mid]==nums[high]){
                low++;
                high--;
                continue;
            }

            if(nums[low]<=nums[mid]){
                if(nums[low] <= k && k<=nums[mid]) high = mid - 1;
                else low = mid + 1;
            }else if(nums[mid]<=nums[high]){
                if(nums[mid]>= k && nums[high]>=nums[mid]) low = mid + 1;
                else high = mid - 1;
            }
        }

        return false;
    }
}
