package Binary_Search;

public class KthMissingNumber {
    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        int k = 5;
        System.out.println(findKthMissingNumber(arr, k));
    }

    public static int findKthMissingNumber(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int missingCount = arr[mid] - (mid + 1);

            if (missingCount < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low + k;
    }
}

//HOW LOW + K WORKS:
//arr[high] + more
//arr[high] + [k - missingCount]
//arr[high] + [k - (arr[high] - (high + 1))]
//arr[high] + k - arr[high] + high + 1
//k + high + 1
//k + low