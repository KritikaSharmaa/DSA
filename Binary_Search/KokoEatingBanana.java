package Binary_Search;

public class KokoEatingBanana {
    public static void main(String[] args) {
        int[] piles = {7,15, 6, 3};
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int[] piles, int h){

        int max = piles[0];

        //Calculate max pile
        for(int pile : piles)
            max = Math.max(max, pile);

        // Range of Koko's eating speed 1 to max pile
        int low = 1;
        int high = max;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(canEatAll(piles, h, mid)){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static boolean canEatAll(int[] piles, int h, int speed){
        int hoursNeeded = 0;

        for(int pile : piles){
           hoursNeeded += Math.ceil((double)pile / speed);
           //System.out.println("Pile: " + pile + ", Speed: " + speed + ", Hours for this pile: " + Math.ceil((double)pile / speed));
        }
        //System.out.println("Speed: " + speed + ", Hours Needed: " + hoursNeeded);

        return hoursNeeded <= h;
    }

}
