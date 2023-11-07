package leetcode.medium._122;

public class Solution {

    public int maxProfit(int[] prices) {
        int ans = 0;
        int N = prices.length;
        for (int i = 1; i < N; i++) {
            if (prices[i] - prices[i - 1] > 0)
                ans += prices[i] - prices[i - 1];
        }
        return ans;
    }
}
