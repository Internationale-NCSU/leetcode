public class leetcode122 {
    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length;i++) {
            if(prices[i]>prices[i-1]){
                profit = profit + prices[i] - prices[i-1];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int prices[] = {7,6,5,4,3,2};
        System.out.println(maxProfit(prices));
    }
}
