package Medium;

import java.util.HashMap;

public class Majority {
    public static void main(String[] args) {
        int nums[] = {1, 2, 1, 2, 1, 3, 3,3,3};
        System.out.println(majorityElement(nums)); 
    }

    //Brute Force Approach
    // Time Complexity: O(n^2) - Single pass through the array + Nested loop to count occurrences.
    //Space Complexity: O(1) - No extra space used.

    //Better Approach using HashMap
    // Time Complexity: O(n) - Single pass through the array + O(N) For verification = overall O(2N) ~ o(N).
    //Space Complexity: O(n) - HashMap storing up to n elements.
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums[0],1);
        for(int i=1;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }else{
                map.put(nums[i], 1);
            }
        }

        // Verify Majority Element
        for (int key : map.keySet()) {
            if(map.get(key) >= nums.length/2){
                return key;
            }
        }

        return -1;
    }


    //Optimal : Boyer-Moore Voting Algorithm
    //Time Complexity: O(n) - Single pass through the array + O(N) For verification = overall O(2N) ~ o(N).
    //Space Complexity: O(1) - No extra space used.
    //public static int majorityElement(int[] nums) {
    //    int element=-1;
    //    int count = 0;
    //    for (int i = 0; i < nums.length; i++) {
    //        if(count == 0){
    //            element = nums[i];
    //            count = 1;
    //        } else if (nums[i] == element) {
    //            count++;
    //        } else {
    //            count--;
    //        }
    //    }
        // Verify if it is actually a majority element
    //    count = 0;
    //    for (int num : nums) {
    //        if (num == element) {
    //            System.out.println("couting verifying..");
    //            count++;
    //        }
    //    }
//
//        if(count> nums.length/2){
//            return element;
//        }else return -1;
//    }
}
