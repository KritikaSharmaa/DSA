package Hard;

import java.util.HashMap;

public class SubarrayWithXORK {
    public static void main(String[] args) {
        int[] nums = {5, 6, 7, 8, 9};
        int k = 5;
        System.out.println(countSubarraysWithXOR_K(nums, k));
    }

    //Brute force Approach
    //Time complexity - O(N^2)
    //Space complexity - O(1)
    //public static int countSubarraysWithXOR_K(int[] nums, int k){
    //    int count=0;
    //    for(int i=0; i<nums.length; i++){
    //        int xor=nums[i];
    //        for(int j=i; j<nums.length; j++){
    //            xor^=nums[j];
    //            if(xor == k){
    //                System.out.println(i + " -- "+j);
    //                count++;
    //            }
    //        }
    //    }
    //    return count;
    //}

    //Better Approach
    //Time Complexity - 0
    public static int countSubarraysWithXOR_K(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int count=0;
        int prefix_xor=0;
        for(int i=0; i<nums.length; i++){
            // Find prefix_xor of current prefix
            prefix_xor^=nums[i];
        
             // If this prefix subarray has XOR equal to K
            if(prefix_xor == k){
                count++;
            }
            //If prefXOR ^ k exists in mp then there is a subarray ending at i with XOR equal to k
            count+= map.getOrDefault(prefix_xor^k, 0);
        
            //if xor exists then add 1 else, add xor with frequency 1.
            map.put(prefix_xor, map.getOrDefault(prefix_xor, 0) + 1);
            
        }
    
        return count;
    }

}