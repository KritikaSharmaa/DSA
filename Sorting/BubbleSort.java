package Sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        int[] res = sort(arr);
        for(int r: res){
            System.out.print(r+" ");
        }
    }

    //Bubble Sort - Repeatedly place the largest element at the end
    //Time Complexity - O(N²) Explained below.
    //Space Complexity - O(1)
    public static int[] sort(int[] arr){
        for(int i = 0; i<arr.length-1; i++){
            for(int j = 0; j<arr.length-i-1; j++){
                if(arr[j]>arr[j+1])
                    Swap(arr, j, j+1);
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

//Inner loop
//Runs less each time:
//When i = 0 → runs n - 1 times
//When i = 1 → runs n - 2 times
//When i = 2 → runs n - 3 times
//...
//When i = n-2 → runs 1 time
//total → (n-1)+(n-2)+(n-3)+(n-4)+..+1 => (n * (n - 1))/2 => n^2/2 - n/2 =>  ~ O(N²)
