// time: O(n)
// space: O(1)

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int maxProfit = 0;
        int buy = 0;
        int sell = 0;
        while (sell < prices.length) {
            if (prices[sell] >= prices[buy]) {
                maxProfit += prices[sell] - prices[buy];
            }
            buy = sell;
            sell++;
        }
        return maxProfit;
    }
}
