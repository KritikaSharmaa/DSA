package Hard;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int nums[] = {-2, 0, 1,1,2};
        System.out.println(threeSum(nums));
    }

    //Brute Force Approach
    //Time Complexity: O(n^3) - Triple nested loop to check all triplets
    //Space Complexity: O(k) - List to store the result, where k is the number of triplets found. (To Store Results only not using it for solving the problem)
    //public static List<List<Integer>> threeSum(int[] nums){
    //    List<List<Integer>> res = new ArrayList<>();
    //    for(int i=0; i< nums.length; i++){
    //        for(int j=i+1; j<nums.length; j++){
    //            for(int k=j+1; k< nums.length; k++){
    //                if(nums[i] + nums[j] + nums[k] ==0){
    //                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
    //                    Collections.sort(triplet);
    //                    if(!res.contains(triplet)){
    //                        res.add(triplet);
    //                    }
    //                }
    //            }
    //        }
    //    }
    //    return res;
    //}

    //Better Approach
    //public static List<List<Integer>> threeSum(int[] nums){
    //HashMap<Integer, Integer> map;
    //List<List<Integer>> res = new ArrayList<>();
    //
    //    for(int i=0;i<nums.length; i++){
    //        map = new HashMap<>();
    //        for(int j=i+1; j< nums.length; j++){
    //            int complement = - (nums[i] + nums[j]);
    //            if(map.containsKey(complement)){
    //                List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
    //                Collections.sort(triplet);
    //                if(!res.contains(triplet)){
    //                    res.add(triplet);
    //                }
    //            }
    //            map.put(nums[j], j);
    //        }
    //    }
    //    return res;
    //}

    //Optimal Approach using Sorting and Two Pointers
    //Time Complexity: Sorting the array O(n log n) + O(n^2) for two nested loops.
    //Space Complexity: O(k) - List to store the result, where k is the number of triplets found. (To Store Results only not using it for solving the problem)
    public static List<List<Integer>> threeSum(int[] nums){
       List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int total = nums[i] + nums[j] + nums[k];

                if (total > 0) {
                    k--;
                } else if (total < 0) {
                    j++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;

                    while (nums[j] == nums[j-1] && j < k) {
                        j++;
                    }
                }
            }
        }
        return res;
    }
}
