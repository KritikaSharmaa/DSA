package Binary_Search;

public class CapacityToShipPackages {
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println(shipWithinDays(weights, days));
    }

    public static int shipWithinDays(int[] weights, int days) {
        int totalWeight = 0;
        //total weight of all packages
        for (int weight : weights) 
            totalWeight += weight;
        
        int low = 1;
        int high = totalWeight;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(canShip(weights, days, mid))
                high = mid - 1;
            else
                low = mid + 1;
        }

        return low;
    }

    public static boolean canShip(int[] weights, int days, int capacity){
        int daysNeeded = 1;
        int currentLoad = 0;
        for(int weight : weights){
            if(currentLoad + weight > capacity){
                daysNeeded++;
                currentLoad = 0;
            }
            currentLoad += weight;      
        } 

        return daysNeeded <= days; //+1 for the last day
    }
}
