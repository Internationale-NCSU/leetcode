import org.junit.Test;

public class leetcode276 {
    public int numWays(int n, int k) {
        int[] dp = new int[n];
        int[] dup = new int[n];
        dup[0] = 0;
        dp[0] = k;
        for (int i = 1; i < n; i++) {
            dup[i] = dp[i-1]-dup[i-1];
            dp[i] = dp[i-1]*k - dup[i-1];
        }
        return dp[n-1];
    }
    @Test
    public void test(){
        System.out.println(numWays(7,2));
    }
}
