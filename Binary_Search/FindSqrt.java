package Binary_Search;

public class FindSqrt {
    public static void main(String[] args) {
        int num = 47;
        System.out.println("Sqrt: "+Calc_Sqrt(num));
    }

    public static int Calc_Sqrt(int num){
        if(num == 0 || num == 1) return num;
	    int low = 1;
	    int high = num;

	    int res = -1;

	    while(low <=  high){
	    	int mid = low + (high-low)/2;
	    	if(mid*mid ==num) res = mid;
	    	else if(mid*mid<num){
	    		res = mid;
	    		low = mid + 1;
	    	}else high = mid - 1;
	    }

	    return res;

        
    }
}
