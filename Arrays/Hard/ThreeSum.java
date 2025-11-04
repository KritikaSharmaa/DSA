package Hard;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int nums[] = {-4 -2, -2, -2, 0, 1, 2, 2, 2, 3, 4};
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
        int p1=0;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // Sorting the array
        while(p1 < nums.length -2){
            int p2 = p1+1;
            int p3 = nums.length -1;
            while(p2 < p3){
                int sum = nums[p1] + nums[p2] + nums[p3];
                if(sum ==0){
                    res.add(Arrays.asList(nums[p1], nums[p2], nums[p3]));
                    p2++;
                    p3--;
                    //Skipping duplicates for p2
                    while(p2 < p3 && nums[p2] == nums[p2 +1]) p2++;
                    //Skipping duplicates for p3
                    while(p2 < p3 && nums[p3] == nums[p3 -1]) p3--;
                    
                } else if(sum <0){
                    p2++;
                } else{
                    p3--;
                }
            }
            //Skipping duplicates for p1
            while(p1 < nums.length -2 && nums[p1] == nums[p1 +1]) p1++;
            p1++;
        }
        return res;
    }
}
