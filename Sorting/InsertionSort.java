package Sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        int[] res = sort(arr);
        for(int r: res){
            System.out.print(r+" ");
        }
    }

    //Insertion Sort - Insertion Sort inserts the card (element) into the correct place among sorted cards/Place element in sorted prefix
    //Time Complexity - ~ O(N²) --> 1 + 2 + 3 + ... + (n−1) = n²/2
    //Space Complexity - O(1)
    public static int[] sort(int[] arr){
        for(int i=0; i<arr.length; i++){
            int j=i;
            while(j>0 && arr[j]<arr[j-1]){
                int temp = arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
                j--;
            }
        }
        return arr;
    }

     public static void Swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
