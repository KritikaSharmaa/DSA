package Medium;

import java.util.HashMap;

public class Sort012 {
    public static void main(String[] args) {
        int nums[] = {0, 1, 2, 0, 1, 2, 1, 0};
        sortNumbers(nums);

        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i] + " ");
        }
    }

    //Brute Force Approach: Any Sorting Algorithm - N*logn

    //Better Approach: Counting Sort
    // Time Complexity: O(n) - Single pass through the array to count 0s, 1s and 2s + another pass to overwrite the array.
    //Space Complexity: O(1) - Only three integer variables used for counting.
    //*****O(2n) (linear) is better than O(n log n) for large inputs. *******
    //public static void sortNumbers(int[] nums) {
    //    int count0 = 0;
    //    int count1 = 0;
    //    int count2 = 0;
//
    //    for(int i=0;i<nums.length;i++){
    //        if(nums[i]==0){
    //            count0++;
    //        } else if (nums[i]==1) {
    //            count1++;
    //        } else {
    //            count2++;
    //        }
    //    }
//
    //    int index = 0;
    //    for(int i=0;i<count0;i++){
    //        nums[index++] = 0;
    //    }
    //    for(int i=0;i<count1;i++){
    //        nums[index++] = 1;
    //    }
    //    for(int i=0;i<count2;i++){
    //        nums[index++] = 2;
    //    }     
    //}

    //Optimal Approach: Dutch National Flag Algorithm - It’s specifically designed for 3 categories (like colors on the Dutch flag).
    // Time Complexity: O(n) - Single pass through the array.
    //Space Complexity: O(1) - Only three integer variables used for indexing.
    public static void sortNumbers(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap nums[low] and nums[mid]
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                // Swap nums[mid] and nums[high]
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }

}
