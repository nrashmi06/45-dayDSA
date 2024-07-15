package Arrays;

public class BestTimeToBuyAndSellStock2 {
    public static int maxProfit(int[] prices) {
        int res = 0;
        int n = prices.length;

        for( int i = 1 ; i< n; i++){
            if(prices[i] >  prices[i-1]){
                res += (prices[i] - prices[i-1]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

}
