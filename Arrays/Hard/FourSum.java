package Hard;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target= 0;
        List<List<Integer>> res = fourSum(nums, target);
        System.out.println(res);
    }

    //Brute Force Approach
    //Time Complexity - O(N)^4
    //Time Complexity - O(No. of Quadruples) X 2 for 2 lists
    //public static List<List<Integer>> fourSum(int[] nums, int target) {
    //    List<List<Integer>> res = new ArrayList<>();
    //    List<Integer> sublist;
    //    for(int i=0;i<nums.length;i++){
    //        for(int j=i+1; j<nums.length; j++){
    //            for(int k=j+1; k<nums.length; k++){
    //                for(int l=k+1; l<nums.length; l++){
    //                    long sum = nums[i]+nums[j]+nums[k]+nums[l];
    //                    if(sum==target){
    //                        sublist= new ArrayList<>();
    //                        sublist.add(nums[i]);
    //                        sublist.add(nums[j]);
    //                        sublist.add(nums[k]);
    //                        sublist.add(nums[l]);
    //                        res.add(sublist.stream().sorted().toList());
    //                    }
    //                }
    //            }
    //        }
    //    }
    //    return res;
    //}

    //Better Approach
    //Time Complexity: Average case total: O(n³) & Worst case total: O(n³ log n) (because of collision-induced tree lookup)
    //Space Complexity(including output): O(n + m), where m = number of valid quadruplets, n= hashmap.
    //public static List<List<Integer>> fourSum(int[] nums, int target) {
    //    HashMap<Integer, Integer> map;
    //    List<List<Integer>> res = new ArrayList<>();
//
    //    for(int i=0; i<nums.length; i++){
    //        for(int j=i+1; j<nums.length; j++){
    //            map = new HashMap<>();
    //            for(int k=j+1; k<nums.length; k++){
    //                int complement = target-(nums[i]+nums[j]+nums[k]);
    //                if(map.containsKey(complement)){
    //                    List<Integer> quad = Arrays.asList(nums[i], nums[j], nums[k], complement);
    //                    Collections.sort(quad);
    //                    if(!res.contains(quad)){
    //                        res.add(quad);
    //                    }
    //                }
    //                map.put(nums[k],k);
    //            }
    //        }
    //    }
//
    //    return res;
    //}

    //Optimal Approch
    //Time Complexity - O(N^3)
    //Space Complexity - O(M), where M= no.of quads - its just to store ans not used for solving question.
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        int i=0;
        while(i<nums.length){
            int j=i+1;
            while(j<nums.length){
                int k=j+1;
                int l=nums.length-1;
                while(k<l){
                    int sum=nums[i]+nums[j]+nums[k]+nums[l];
                    if(sum==target){
                        List<Integer> quadList = Arrays.asList(nums[i],nums[j],nums[k],nums[l]);
                        if(!res.contains(quadList))
                            res.add(quadList);
                        k++;
                        l--;
                        while(nums[k]==nums[k-1]) k++;
                        while(nums[l]==nums[l+1])  l--;

                    }else if(sum<target){
                        k++;
                    }else{
                        l--;
                    }
                }
                j++;
            }
            i++;
        }

        return res;
    }

}
