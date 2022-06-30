import org.junit.Test;

import java.util.Arrays;

public class leetcode279 {
    public int numSquares(int n) {
        int[] bucket = new int[100];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = (i+1)*(i+1);
        }
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if(i-bucket[j]<0){
                    break;
                }
                dp[i] = Math.min(dp[i],dp[i-bucket[j]]+1);
            }
        }
        return dp[n];
    }
    @Test
    public void test(){
        System.out.println(numSquares(1));
    }
}
