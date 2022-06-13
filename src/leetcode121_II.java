
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class leetcode121_II {
    public static int maxProfit(int[] prices) {
        int left=0,right=prices.length-1;
        int min = MAX_VALUE,max = MIN_VALUE;
        boolean flag = false;
        while(left<right){
            if(flag) {
                min = Math.min(min, prices[left]);
                left++;
                flag = false;
            }else {
                max = Math.max(max, prices[right]);
                right--;
                flag = true;
            }
        }
        int profit = prices[left] -prices[right];
        return 0>max-min? 0 : (max-min);
    }

    public static void main(String[] args) {
        int[] prices ={1,4,2};
        System.out.println(maxProfit(prices));
    }
}
