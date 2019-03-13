// time: O(n)
// space: O(1)

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int lastDayPrice = prices[0];
        prices[0] = 0;
        
        for (int i = 1; i < prices.length; i++) {
            prices[i] = prices[i] - lastDayPrice;
            lastDayPrice = prices[i] + lastDayPrice;
        }
        int local = prices[0];
        int global = local;
        for (int i = 1; i < prices.length; i++)
        {
            local = Math.max(prices[i], prices[i] + local);
            global = Math.max(global, local);
        }
        return global;
    }
}
