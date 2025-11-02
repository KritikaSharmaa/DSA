//Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

package Hard;

import java.util.*;

public class MajorityElementsII {
    public static void main(String[] args) {
        int nums[] = {2, 2, 1, 1, 1, 2, 2};
        List<Integer> result = majorityElement(nums);
        System.out.println(result);
    }

    //Brute Force Approach
    //Time Complexity: O(n^2) - Single pass through the array + Nested loop to count occurrences.
    //Space Complexity: O(k) - List to store the result, where k is the number of majority elements found. (To Store Results only not using it for solving the problem)
    //public static List<Integer> majorityElement(int[] nums) {
    //    List<Integer> res = new ArrayList<>();
    //    for(int i=0; i< nums.length; i++){
    //        int count =0;
    //        for(int j=0; j< nums.length; j++){
    //            if(nums[i] == nums[j]){
    //                count++;
    //                if(count > nums.length/3 && !res.contains(nums[i])){
    //                    res.add(nums[i]);
    //                }
    //            }
    //        }
    //    }
//
    //    return res;
    //}
    
    //Better Approach using HashMap
    //Time Complexity: O(n) - Single pass through the array + O(N) Iterating over the map = overall O(2N) ~ o(N).
    //Space Complexity: O(n) - HashMap storing up to n elements.
    //public static List<Integer> majorityElement(int[] nums) {
    //    HashMap<Integer, Integer> map = new HashMap<>();
	//    List<Integer> res = new ArrayList<>();
//
	//    for(int i=0; i< nums.length; i++){  //⚠️ Worst case: if many hash collisions happen, operations can degrade to O(n²) —but in practice (with a good hash function), we consider it O(n).
	//   	    if(map.containsKey(nums[i])){
	//		    map.put(nums[i], map.get(nums[i])+1);
	//	    }else{
	//		    map.put(nums[i], 1);
	//	    }
	//    }
	//
	//    for(Map.Entry<Integer, Integer> entry : map.entrySet()){
	//	    if(entry.getValue()> nums.length/3)
	//		    res.add(entry.getKey());
	//    }
//
	//    return res;
    //}

    //Optimal : Extended Boyer-Moore Voting Algorithm
    //Time Complexity: O(n) - Single pass through the array + O(N) Iterating over the array again for counting = overall O(2N) ~ o(N).
    //Space Complexity: O(1) - No extra space used.
    public static List<Integer> majorityElement(int[] nums){
        int minOccurences = nums.length / 3;
        int count1 =0, count2=0;
        int candidate1 = -1, candidate2 = -1;
        //Finding Candidates
        for(int num : nums){
            if(count1 == 0 && num != candidate2){
                candidate1 = num;
                count1 = 1;
            }else if(count2 == 0 && num != candidate1){
                candidate2 = num;
                count2 = 1;
            }else if(num == candidate1){
                count1++;
            }else if(num == candidate2){
                count2++;
            }else{
                count1--;
                count2--;
            }   
        }

        //Counting actual occurrences, as its count might be changed during the process due to cancelling out different elements
        count1 =0;
        count2 =0;
        for(int n : nums){
            if(n == candidate1){
                count1++;
            }else if(n== candidate2){
                count2++;
            }
        }

        //Now count1 & count2 have actual occurrences of candidate1 & candidate2 respectively. We can verify them if > n/3.
        List<Integer> res = new ArrayList<>();
        if(count1 > minOccurences){
            res.add(candidate1);
        }
        if(count2 > minOccurences){
            res.add(candidate2);
        }

        return res;
    }

}