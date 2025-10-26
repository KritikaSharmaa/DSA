package Medium;

public class BuySellStocks {
    public static void main(String[] args) {
        int[] prices = {5, 4, 3, 2, 1};
        int maxProfit = maxProfit(prices);
        System.out.println("Maximum Profit: " + maxProfit);
    }
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxPrice = Integer.MIN_VALUE;
        int l = 0, h=prices.length-1;
        while(l<h){
            if(prices[l]<minPrice){
                minPrice = prices[l];
            }
            if(prices[h]>maxPrice){
                maxPrice = prices[h];
            }
            l++;
            h--;
        }
        return Math.max(0, maxPrice - minPrice);
    }
}
