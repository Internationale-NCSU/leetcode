import org.junit.Test;

public class leetcode518_CoinChangeII {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int coin : coins) {
            for(int x = coin;x<amount+1;++x){
                dp[x] += dp[x-coin];
            }
        }
        return dp[amount];
    }
    @Test
    public void test(){
        System.out.println(change(5,new int[]{1,2,5}));
    }
}
