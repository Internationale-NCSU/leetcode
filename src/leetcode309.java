import org.junit.Test;

public class leetcode309 {
    public int maxProfit(int[] prices) {
        int sold = 0;
        int rest = 0;
        int hold = Integer.MIN_VALUE;
        for (int price : prices) {
            int pre_sold = sold;
            sold = hold+price;
            hold = Math.max(hold,rest-price);
            rest = Math.max(rest, pre_sold);
        }
        return Math.max(rest,sold);
    }
    @Test
    public void test(){
        System.out.println(maxProfit(new int[]{1,2,3,0,2}));
    }
}
