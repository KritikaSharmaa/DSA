package Medium;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int nums[] = {1, 3, 5, -7, 6, -3};
        int target = 0;
        int[] res = twoSum(nums, target);
        if(res.length > 1){
            System.out.println("Indices: [" + res[0] + ", " + res[1] + "]");
        } else {
            System.out.println("No two sum solution found.");
        }
    }

    //Brute Force Approach
    // Time Complexity: O(n^2)
    //public static int[] twoSum(int[] nums, int target) {
    //    for(int i=0;i<nums.length;i++){
    //        int j=1;
    //        while(j<nums.length){
    //            if(nums[i]+nums[j]==target && i!=j){
    //                return new int[]{i,j};
    //            }
    //            j++;
    //        }
    //    }
    //    return new int[]{-1};
    //}

    //Better Approach using HashMap
    // Time Complexity: O(n)
   // public static int[] twoSum(int[] nums, int target) {
   //     HashMap<Integer, Integer> map = new HashMap<>();
//
   //     for(int i=0; i< nums.length; i++){
   //         if(map.containsKey(target-nums[i])){
   //             return new int[]{map.get(target-nums[i]), i};
   //         }
//
   //         if(!map.containsKey(nums[i])){
   //             map.put(nums[i], i);
   //         }
   //     }
   //     return new int[]{};
    //}

    //Optimal Approach using Two Pointers (Only works for sorted arrays)
    public static int[] twoSum(int[] nums, int target) {

        nums = java.util.Arrays.stream(nums).sorted().toArray(); // Sorting the array for two-pointer technique
    
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i] + " ");
        }

         //-7 -3 1 3 5 6
        // Output- Indices: [1, 3]
        
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            
            int sum = nums[left] + nums[right];

            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1};
    }
}
