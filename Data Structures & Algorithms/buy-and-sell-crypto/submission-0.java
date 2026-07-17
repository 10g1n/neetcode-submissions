class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = left + 1;

        int maxProfit = 0;

        while (right < prices.length) {
            if (prices[right] < prices[left]) {
                left = right;
            } else {
                int currProfit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, currProfit);
            }

            right++;
        }

        return maxProfit;
    }
}
