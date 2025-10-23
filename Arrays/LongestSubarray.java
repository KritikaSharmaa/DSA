//Given an array nums of size n and an integer k, find the length of the longest sub-array that sums to k. 
//If no such sub-array exists, return 0.

import java.util.*;

public class LongestSubarray {
    public static void main(String[] args) {
        int[] nums = {-3, 2, 1};
        int k = 6;
        System.out.println(longestSubarray(nums, k)); // Output: 4
    }
    //Brute Force Approach
    // WOrst Case: O(n^2)
    //public static int longestSubarray(int[] nums, int k) {
    //    int i = 0;
    //    int maxLength = 0;
    //    while (i < nums.length) {
    //        int j = i;
    //        int sum = 0;
    //        while (j < nums.length) {
    //            sum += nums[j];
    //            if(sum > k){
    //                break;
    //            }
    //            if (sum == k) {
    //                maxLength = Math.max(maxLength, j - i + 1);
    //            }
    //            j++;
    //        }
    //        i++;
    //    }
    //    return maxLength;
    //}

    //Better Case: When nums contains positive.
    //Optimal Case: when nums contains both positive and negative integers
    // Time Complexity: 
    //Average - O(n), Each HashMap op ≈ O(1) → n × O(1) 
    //Worst - O(n logn) - if many keys have the same hash (poor hashing),a single bucket could grow long, making operations O(n).
    //However:Java 8+ converts long hash chains to balanced trees, giving O(log n) worst-case performance.
    //Space Complexity: O(n) - HashMap storing up to n prefix sums.
    //public static int longestSubarray(int[] nums, int k) {
    //    Map<Integer, Integer> prefixSumIndexMap = new HashMap<>();
    //    int sum=0;
    //    int maxLength=0;
//
    //    for(int i=0;i<nums.length;i++){
    //        sum+=nums[i];
    //        if(sum==k){
    //            maxLength=i+1;
    //        }
//
    //        if(sum>k && prefixSumIndexMap.containsKey(sum - k)){
    //            int len = i-prefixSumIndexMap.get(sum - k);
    //            maxLength = Math.max(maxLength, len);
    //        }
//
    //        if(!prefixSumIndexMap.containsKey(sum)){
    //            prefixSumIndexMap.put(sum, i);
    //        }
    //    }
//
    //    return maxLength;
    //}
    
    //Optimal : In Case if positive intergers only
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public static int longestSubarray(int[] nums, int k) {
        int j=0;
        int sum = 0;
        int maxLength = 0;

        for(int i=0;i<nums.length;i++){
            sum += nums[i];

            while(sum > k){
                sum -= nums[j];
                j++;
            }

            if(sum == k){
                maxLength = Math.max(maxLength, i - j + 1);
            }
        }

        return maxLength;
    }

}
