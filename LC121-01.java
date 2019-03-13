// time:O(n)
// space:O(n)

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int[] dailyChanges = new int[prices.length];
        dailyChanges[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            dailyChanges[i] = prices[i] - prices[i - 1];
        }
        int local = dailyChanges[0];
        int global = local;
        for (int i = 1; i < dailyChanges.length; i++)
        {
            local = Math.max(dailyChanges[i], dailyChanges[i] + local);
            global = Math.max(global, local);
        }
        return global;
    }
}
