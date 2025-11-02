//Return the length of the longest sequence of consecutive integers. The integers in this sequence can appear in any order.

package Medium;
import java.util.*;
public class LongestConsecutiveSeq {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int longestSeqLength = longestConsecutive(nums);
        System.out.println("Length of Longest Consecutive Sequence: " + longestSeqLength);
    }

    //Brute Force Approach
    //Time Complexity: O(n^2) in worst case and Space Complexity: O(1)
    //public static int longestConsecutive(int[] nums) {
    //  int longest = 0;
//
    //    for (int i = 0; i < nums.length; i++) { // Outer loop → O(n)
    //        int currentNum = nums[i];
    //        int currentStreak = 1;
//
    //        // check for next consecutive numbers
    //        while (exists(nums, currentNum + 1)) {  
    //            currentNum++;
    //            currentStreak++;
    //        }
//
    //        longest = Math.max(longest, currentStreak);
    //    }
//
    //    return longest;
    //}

    // Helper method: checks if a number exists in the array
    //private static boolean exists(int[] nums, int target) {
    //    for (int num : nums) {       // Linear search → O(n)
    //        if (num == target) return true;
    //    }
    //    return false;
    //}

    //Better Approch using Sorting
    //Time Complexity: O(n log n) - Sorting the array + O(n) Single pass through the array.
    //Space Complexity: O(1) - No extra space used.
    //public static int longestConsecutive(int[] nums){
    //    int[] sorted_array=java.util.Arrays.stream(nums).sorted().toArray();
    //    int longestStreak=1;
    //    int currentStreak=1;
    //    for(int i=1;i<sorted_array.length;i++){
    //        if(sorted_array[i]==sorted_array[i-1]){
    //            continue;
    //        }else if(sorted_array[i]==sorted_array[i-1]+1){
    //            currentStreak++;
    //        }else{
    //            longestStreak=Math.max(longestStreak,currentStreak);
    //            currentStreak=1;
    //        }
//
    //    }
    //    return longestStreak;
    //}

    //Optimal Approach using HashSet
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public static int longestConsecutive(int[] nums){
        //Store all numbers in a HashSet for O(1) access
        HashSet<Integer> numSet = new HashSet<>();
        for(int num: nums){
            numSet.add(num);
        }

        int longestStreak=0;
        for(int num: nums){                                 //Runs n times. -Outer loop + while loop combined ->Each element visited once
            if (!numSet.contains(num-1)) {
                int currentNum=num;
                int currentStreak=1;
                while (numSet.contains(currentNum+1)) {     //Each contains() call → O(1) average.
                    currentNum++;
                    currentStreak++;
                }
                longestStreak=Math.max(currentStreak, longestStreak);
            }  
        }

        return longestStreak;
    }
}
