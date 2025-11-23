package Binary_Search;

public class NRoot {
    public static void main(String[] args) {
        int num = 69;
        int n = 3;
        System.out.println("NRoot: "+N_Root(num, n));
    }

    public static int N_Root(int num, int n){
        if(num == 0 || num == 1) return num;
	    int low = 1;
	    int high = num;
        
	    while(low<=high){
	    	int mid = low + (high - low) / 2;
	    	int mult = mid*mid*mid;
	    	if(mult==num) return mid;
	    	else if(mult<num) low = mid + 1;
	    	else high = mid - 1;
	    }
    
	    return -1;

    }
}
