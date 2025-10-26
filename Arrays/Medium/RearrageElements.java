//Given an integer array nums of even length consisting of an equal number of positive and negative integers.
//Return the answer array in such a way that the given conditions are met:
//Every consecutive pair of integers have opposite signs.
//For all integers with the same sign, the order in which they were present in nums is preserved.
//The rearranged array begins with a positive integer.

package Medium;

import java.util.ArrayList;

public class RearrageElements {
    public static void main(String[] args) {
        int[] nums = {9, -4, -5, 6, -7, 8, -9, 10};
        rearrangeArray(nums);
        System.out.print("Rearranged Array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    //Brute Force Approach- Time Complexity: O(2n) ~ O(n) & Space Complexity: O(n)
    //public static void rearrangeArray(int[] nums) {
    //    ArrayList<Integer> pos = new ArrayList<>();
    //    ArrayList<Integer> neg = new ArrayList<>();
    //    for (int num : nums) {
    //        if (num >= 0) {
    //            pos.add(num);
    //        } else {
    //            neg.add(num);
    //        }
    //    }
    //    int p=0, n=0;
    //    for (int i = 0; i < nums.length; i++) {
    //        if (i % 2 == 0) {
    //            nums[i] = pos.get(p++);
    //        } else {
    //            nums[i] = neg.get(n++);
    //        }
    //    }
    //}

    //Optimal Approach - Time Complexity: O(n) & Space Complexity: O(1)
    public static void rearrangeArray(int[] nums) {
        int p=0, n=1;
        while(p<nums.length && n<nums.length){
            if(nums[p]>=0){
                p+=2;
            } else if(nums[n]<0){
                n+=2;
            } else {
                //swap
                int temp = nums[p];
                nums[p] = nums[n];
                nums[n] = temp;
                p+=2;
                n+=2;
            }
        }
    }
}
