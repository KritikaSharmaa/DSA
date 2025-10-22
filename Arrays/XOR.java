//Find the number that appears once, and other numbers twice.
public class XOR {
    public static void main(String[] args) {
        int nums[] = {1,3,10,3,5,1,5};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        return xor;
    }
}
