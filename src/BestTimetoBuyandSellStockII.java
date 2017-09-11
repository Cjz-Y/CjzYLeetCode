public class BestTimetoBuyandSellStockII {

    public int maxProfit(int[] prices) {

        int profit = 0;

        int now = prices[ 0 ];

        for (int i = 1; i < prices.length; i++) {
            if ( prices[ i ] > now ){
                profit = prices[ i ] - now;
            }
            now = prices[ i ];
        }

        return profit;

    }
}
