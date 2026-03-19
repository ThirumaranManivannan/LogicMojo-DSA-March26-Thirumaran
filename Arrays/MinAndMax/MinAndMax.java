package Arrays.MinAndMax;

public class MinAndMax {

    public static void main(String[] args) {
        // System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfitWithMultipleTrans(new int[]{1, 5, 2, 3, 7, 6, 4, 5}));
    }

    /**
     * Given an array prices[] of length N, representing the prices of the stocks on different
     * days, the task is to find the maximum profit possible for buying and selling the stocks on
     * different days using transactions where at most one transaction is allowed.
     * Note: Stock must be bought before being sold.
     * Input: prices[] = {7, 1, 5, 3, 6, 4}
     * Output: 5
     * Explanation:
     * The lowest price of the stock is on the 2nd day, i.e. price = 1. Starting from the 2nd day,
     * the highest price of the stock is witnessed on the 5th day, i.e. price = 6.
     * Therefore, maximum possible profit = 6 – 1 = 5.
     */
    private static int maxProfit(int[] prices) {

        int maxProfit = 0, currentMinimum = prices[0];

        for(int price : prices) {

            if(price > currentMinimum) {
                maxProfit = Math.max(maxProfit, price - currentMinimum);
            }
            currentMinimum = Math.min(currentMinimum, price);
        }
        return maxProfit;
    } // T -> O(n) S -> O(1)

    /**
     * Given a list containing future prediction of share prices, find the maximum profit earned
     * by buying and selling shares any number of times with the constraint, a new transaction
     * can only start after the previous transaction is complete, i.e., we can only hold at most
     * one share at a time.
     * For example:
     * Stock Prices: {1, 5, 2, 3, 7, 6, 4, 5}
     * Total profit earned is 10
     * Buy on day 1 and sell on day 2
     * Buy on day 3 and sell on day 5
     * Buy on day 7 and sell on day 8
     */
    private static int maxProfitWithMultipleTrans(int[] prices) {

        int maxProfit = 0, n = prices.length;
        int currentMin = 0;

        for(int i = 1; i < n; i++) {

            if(prices[i] < prices[i - 1]) {
                currentMin = i;
            }
            if(prices[i] >= prices[i - 1] && (i + 1 == n || prices[i] > prices[i+1])) {
                maxProfit += (prices[i] - prices[currentMin]);
            }
        }

        return maxProfit;
    }
}
