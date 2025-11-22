package Binary_Search;

public class MinInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4, 0, 1, 2, 3};
        System.out.println(findMinNum(nums));
    }

    public static int findMinNum(int[] nums){
        int low = 0;
        int high = nums.length - 1;

        int res = Integer.MAX_VALUE;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(nums[low] <= nums[mid]){
                res = Math.min(res, nums[low]);
                low = mid + 1;
            }else{
                res = Math.min(res, nums[mid]);
                high = mid - 1;
            }
            
        }

        return res;
    }
}
