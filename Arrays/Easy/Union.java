package Easy;
//Given two sorted arrays nums1 and nums2, return an array that contains the union of these two arrays. 
//The elements in the union must be in ascending order.
//The union of two arrays is an array where all values are distinct and are present in either the first array, the second array, or both.
import java.util.*;
class Union {
    public int[] unionArray(int[] arr1, int[] arr2) {
        List<Integer> union = new ArrayList<>();
        int i = 0, j = 0;
        
        while (i < arr1.length && j < arr2.length) {
            // Skip duplicates within same array
            if (i > 0 && arr1[i] == arr1[i - 1]) {
                i++;
                continue;
            }
            if (j > 0 && arr2[j] == arr2[j - 1]) {
                j++;
                continue;
            }

            if (arr1[i] < arr2[j]) {
                union.add(arr1[i++]);
            } else if (arr2[j] < arr1[i]) {
                union.add(arr2[j++]);
            } else { // equal
                union.add(arr1[i]);
                i++;
                j++;
            }
        }

        // Add remaining elements
        while (i < arr1.length) {
            if (i == 0 || arr1[i] != arr1[i - 1])
                union.add(arr1[i]);
            i++;
        }

        while (j < arr2.length) {
            if (j == 0 || arr2[j] != arr2[j - 1])
                union.add(arr2[j]);
            j++;
        }

        int[] res = new int[union.size()];

        for(int r=0;r<union.size();r++){
            res[r]=union.get(r);
        }

        return res;
    }

    public static void main(String[] args) {
        Union u = new Union();
        int[] arr1 = {1, 2, 2, 3, 4};
        int[] arr2 = {2, 3, 5, 6};
        int[] result = u.unionArray(arr1, arr2);
        System.out.println(Arrays.toString(result)); // Output: [1, 2, 3, 4, 5, 6]
    }
}