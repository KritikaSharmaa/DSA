package Hard;

public class MaxProductSubarray {
    public static void main(String[] args) {
        int[] nums = {0, -2, -3, 0, -2, -40, 0};
        System.out.println(CalculateMaxProductSubarray(nums));
    }

    //Brute Force Approach
    //Time Complexity - O(n^2)
    //Space Complexity - (1)
    //public static int CalculateMaxProductSubarray(int[] nums){
    //    int res =0;
    //    for(int i=0; i<nums.length; i++){
    //        int prod=1;
    //        for(int j=i; j<nums.length; j++){
    //            prod*= nums[j];
    //        }
    //        res= Math.max(res, prod);
    //    }
    //    return res;
    //}

    //Better Approach ---> Observations 1) -ve*-ve = +ve  2) 0 will make subarray product as 0
    //Time Complexity - O(n)
    //Space Complexity - O(1)
    public static int CalculateMaxProductSubarray(int[] nums){
        int res=0;
        int p=1;
        for(int i=0; i<nums.length; i++){
            if(p*nums[i]==0){
                p=1;
                continue;
            }
            p*=nums[i];
            res = Math.max(res, p);
        }

        return res;
    }
}
