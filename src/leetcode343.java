import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leetcode343 {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <=n ; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(i,dp[j]*dp[i-j]);
            }
        }
        return dp[n];
    }
    @Test
    public void test(){
        System.out.println(integerBreak(5));
    }
}
