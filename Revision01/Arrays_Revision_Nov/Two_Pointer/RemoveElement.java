//Q- https://leetcode.com/problems/remove-element/description/?envType=problem-list-v2&envId=two-pointers
package Revision01.Arrays_Revision_Nov.Two_Pointer;

public class RemoveElement {
    public static void main(String[] args) {
        int[] arr ={0,1,2,2,3,0,4,2};
        int val = 2;
        int l= removeElement(arr, val);
        System.out.println(l);
        for(int p=0; p<l; p++){
            System.out.print(arr[p]+" ");
        }
    }

    //Time Complexity - O(N)
    //Space Complexity - O(1)
    public static int removeElement(int[] nums, int val) {
        int i=0;
        int j=i;
        int count=0;
        while(i<=j && j<nums.length){
            if(i==j && nums[i]!=val){
                i++;
                count++;
            }else if(i!=j && nums[j]!=val){
                nums[i] = nums[j];
                i++;
                count++;
            }
            j++;
        }
        return count;
    }
}
