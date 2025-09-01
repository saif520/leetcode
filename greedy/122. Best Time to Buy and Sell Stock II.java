class Solution {
    public int maxProfit(int[] prices) {
         int totalProfit = 0;
      
        // Iterate through each day starting from day 1
        for (int day = 1; day < prices.length; day++) {
            // Calculate profit if we bought yesterday and sold today
            int dailyProfit = prices[day] - prices[day - 1];
          
            // Only add positive profits (equivalent to buying before price increases)
            // If profit is negative, we simply don't trade (add 0)
            totalProfit += Math.max(0, dailyProfit);
        }
      
        return totalProfit;
    }
}