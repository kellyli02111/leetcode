// time: O(n)
// space: O(n)

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        // local[i][j]: 到第i天发生最多j次交易所能得到的最大利润，并且最后一次交易必须在第i天卖
        int[][] local = new int[prices.length][3];
        // global[i][j]: 到第i天发生最多j次交易所能得到的最大利润，最后一次交易不一定在第i天卖
        int[][] global = new int[prices.length][3];
        for (int i = 0; i < local.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 0  || j == 0) {
                    local[i][j] = 0;
                    global[i][j] = 0;
                }
                else {
                    // daily change
                    int diff = prices[i] - prices[i - 1];
                    //  local[i][j]有两种可能：
                    //  1) 前i-1天里减少一次交易产生的最大利润 + 第i天如果涨了则交易，否则不交易
                    int case1 = global[i - 1][j - 1] + Math.max(diff, 0);
                    //  2) 把前一天(i-1)最后一次交易的卖出延后到当天(i)所产生的利润
                    int case2 = local[i - 1][j] + diff;
                    local[i][j] = Math.max(case1, case2);
                    // 以当天为最后一次交易（最多j次）的最大利润， 或在前n天最多j次交易的最大利润，取最大值
                    global[i][j] = Math.max(local[i][j], global[i-1][j]);
                }
            }
        }
        return global[prices.length - 1][2];
    }
}
