//Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
package Medium;

import java.util.HashMap;

public class CountSubArrayWithKSum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,-3,1,1,1,4,2,-3};
        int k =3;
        System.out.println(subarraySum(arr, k));
    }

    //Brute Force Approach
    //Time Complexity: O(n^2)
    //Space Complexity: O(1)
    //public static int subarraySum(int[] nums, int k) {
    //    int count =0;
    //    for(int i=0; i<nums.length; i++){
    //        int sum =0;
    //        for(int j=i; j<nums.length; j++){
    //            sum += nums[j];
    //            if(sum == k){
    //                for(int p=i;p<=j;p++){//Print the subarrays for my understanding - do not consider this part while analyzing time complexity.
    //                    System.out.print(nums[p]+" ");
    //                }
    //                System.out.println();
    //                count++;
    //            }
    //        }
    //    }
    //    return count;
    //}

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];

            if((sum > k && map.containsKey(sum - k) )||(sum == k) ){
                count++;
            }

            if(!map.containsKey(sum)){
               map.put(sum, i);
            }
        }

        return count;
    }

}
