//Given an array of integers nums and an integer limit as the threshold value, 
//find the smallest positive integer divisor such that upon dividing all the elements of the array by this divisor, 
//the sum of the division results is less than or equal to the threshold value.
//After dividing each element by the chosen divisor, take the ceiling of the result (i.e., round up to the next whole number).

package Binary_Search;

public class SmallestDivisor {
    public static void main(String[] args) {
        int[] nums = {8, 4, 2, 3};
        int threshold = 10;
        System.out.println(smallestDivisor(nums, threshold));
    }

    public static int smallestDivisor(int[] nums, int threshold) {
        int max = nums[0];

        // Calculate max element in the array
        for (int num : nums)
            max = Math.max(max, num);

        // Range of possible divisors from 1 to max element
        int low = 1;
        int high = max;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canDivide(nums, threshold, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static boolean canDivide(int[] nums, int threshold, int divisor) {
        int total = 0;

        for (int num : nums) {
            total += Math.ceil((double) num / divisor);
        }

        return total <= threshold;
    }
}
