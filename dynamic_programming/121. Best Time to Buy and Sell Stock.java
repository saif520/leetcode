class Solution {
    public int maxProfit(int[] prices) {
        // Initialize 'maxProfit' to 0, which is the minimum profit that can be made.
        int maxProfit = 0;

        // Assume the first price is the minimum buying price.
        int minPrice = prices[0];
      
        // Loop through all the prices to find the maximum profit.
        for (int price : prices) {
            // Calculate the maximum profit by comparing the current 'maxProfit'
            // with the difference of the current price and the 'minPrice'.
            maxProfit = Math.max(maxProfit, price - minPrice);
          
            // Update the 'minPrice' if a lower price is found.
            minPrice = Math.min(minPrice, price);
        }
      
        // Return the maximum profit that can be achieved.
        return maxProfit;
    }
}