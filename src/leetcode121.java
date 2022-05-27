public class leetcode121 {
    public static void main(String[] args) {
        int[] input = {7, 1, 5, 3, 6, 4};
        Solution s = new Solution();
        System.out.println(s.maxProfit(input));
    }

    public static class Solution {
        public int maxProfit(int[] prices) {
            int profit = 0;
            int min = prices[0];
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < min) min = prices[i];
                if (prices[i] - min > profit) profit = prices[i] - min;
            }
            return profit;
        }
    }
}
