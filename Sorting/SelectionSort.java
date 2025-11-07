package Sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        int[] res = sort(arr);
        for(int r: res){
            System.out.print(r+" ");
        }
    }

    //Selection Sort -> select/find smallest & place it to the right place
    //Time Complexity - O(N²) Explained below
    //Space Complexity - O(1)
    public static int[] sort(int[] arr){
        //Outer loop → picks each index i as the current position to fill.
        for(int i=0;i<arr.length-1;i++){    // 0 →  n-2 bcz n-1 will already be sorted until i reaches n-2.
            int min=i;
            for(int j=i+1;j<arr.length; j++){   //Inner loop → finds the minimum element’s index (min) in the remaining unsorted part.
               if(arr[min]>arr[j]){
                min=j;
               }
            }
            if(min!=i)  //Swap that minimum with the element at i.
                Swap(arr, i, min);
        }
        return arr;
    }

    public static void Swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

}

//| i   | Inner loop runs (j = i+1 → n-1) |
//| --- | ------------------------------- |
//| 0   | (n-1) times                     |
//| 1   | (n-2) times                     |
//| 2   | (n-3) times                     |
//| …   | …                               |
//| n-2 | 1 time                          |
//| n-1 | 0 times                         |

//sum up:  (n-1)+(n-2)+(n-3)+(n-4)+..+1 => (n * (n - 1))/2 => n^2/2 - n/2 => ~ O(N^2)