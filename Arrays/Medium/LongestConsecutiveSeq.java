//Return the length of the longest sequence of consecutive integers. The integers in this sequence can appear in any order.

package Medium;
public class LongestConsecutiveSeq {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int longestSeqLength = longestConsecutive(nums);
        System.out.println("Length of Longest Consecutive Sequence: " + longestSeqLength);
    }

    //Brute Force Approach
    //Time Complexity: O(n^2) in worst case and Space Complexity: O(1)
    public static int longestConsecutive(int[] nums) {
      int longest = 0;

        for (int i = 0; i < nums.length; i++) { // Outer loop → O(n)
            int currentNum = nums[i];
            int currentStreak = 1;

            // check for next consecutive numbers
            while (exists(nums, currentNum + 1)) {  
                currentNum++;
                currentStreak++;
            }

            longest = Math.max(longest, currentStreak);
        }

        return longest;
    }

    // Helper method: checks if a number exists in the array
    private static boolean exists(int[] nums, int target) {
        for (int num : nums) {       // Linear search → O(n)
            if (num == target) return true;
        }
        return false;
    }
}
