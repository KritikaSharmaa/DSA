package Medium;

public class MaxSubarraySum {
    public static void main(String[] args) {
        int[] nums = {-1, -2, -3, -4};
        int maxSum = maxSubArray(nums);
        System.out.println("Maximum Subarray Sum: " + maxSum);
    }

    //Brute Force Approach - O(n^2) time complexity & O(1) space complexity
    //public static int maxSubArray(int[] nums){
    //    int currentSum = nums[0];
    //    int maxSum = nums[0];
    //    for(int i=0;i<nums.length;i++){
    //        currentSum = 0;
    //        for(int j=i;j<nums.length;j++){
    //            currentSum+=nums[j];
    //            if(currentSum>maxSum){
    //                maxSum = currentSum;
    //            }
    //        }
    //    }
    //    return maxSum;
    //}

    //Optimal Approach - Kadane's Algorithm - O(n) time complexity & O(1) space complexity
    public static int maxSubArray(int[] nums){
        int currentSum = 0;
        int maxSum =  Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            currentSum += nums[i];
            if(currentSum>maxSum){
                maxSum = currentSum;
            }
            if(currentSum<0){
                currentSum = 0;
            }
        }
        return maxSum;
    }
}
