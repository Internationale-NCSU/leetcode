import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class leetcode2266 {
    int mod = 1000000007;
    public int countTexts(String s) {
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        for (int i = 1; i < s.length()+1; i++) {
            int index = i-1;
            char c = s.charAt(index);
            dp[i]=dp[i-1];
            int limit = getLimit(c-'0');
            for (int l = 1; l < limit; l++) {
                if(index-l>=0&&c==s.charAt(index-l)){
                    dp[i]= (dp[i]+dp[i-l-1])%mod;
                }else {
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    public int getLimit(int n){
        if(n==7||n==9){
            return 4;
        }else {
            return 3;
        }
    }
    @Test
    public void test(){
        System.out.println(countTexts("344644885"));
    }


}
