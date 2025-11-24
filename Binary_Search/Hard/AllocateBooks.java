//Q- https://www.codingninjas.com/codestudio/problems/allocate-books_1090540?leftPanelTab=0
package Binary_Search.Hard;

public class AllocateBooks {
    public static void main(String[] args) {
        int[] arr={12, 34, 67, 90};
        int students=2;
        System.out.println(allocateBooks(arr, students));
    }

    public static int allocateBooks(int[] arr, int students){
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int val: arr){
        	low = Math.max(low, val);
        	high+=val;
        }

        while(low<=high){
        	int mid = low + (high - low) / 2;
        	if(canBookAllocated(arr, students, mid)){
        		high = mid - 1;
        	}else low = mid + 1;
        }
        return low;
    }

    public static Boolean canBookAllocated(int[] arr, int students, int maxpages){
	int countStudent = 1, totalpages=arr[0];

	for(int i = 1; i<arr.length; i++){
		if(totalpages+arr[i]<=maxpages){
			totalpages+=arr[i];
		}else{
			totalpages = arr[i];
			countStudent++;
		}
			
	} 

    if(countStudent==students) return true;
    return false;
    }
}
