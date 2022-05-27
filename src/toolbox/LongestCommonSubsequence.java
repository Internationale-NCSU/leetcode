package toolbox;

import org.junit.Test;

public class LongestCommonSubsequence {
    public int findTheLongestCommonSubsequence(String s1,String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s1.length()+1; i++) {
            for (int j = 1; j < s2.length()+1; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1]+1);
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int i = s1.length(),j = s2.length();
        while(dp[i][j]!=0){
            int cur = dp[i][j];
            int up = dp[i-1][j];
            int left = dp[i][j-1];
            if(cur>up&&cur>left){
                sb.append(s1.charAt(i-1));
                i = i-1;
                j = j-1;
                continue;
            }else if(cur>up){
                j = j-1;
                continue;
            }else  {
                i = i-1;
                continue;
            }
        }
        System.out.println(sb.reverse());
        return dp[s1.length()][s2.length()];
    }
    @Test
    public void test(){
        System.out.println(findTheLongestCommonSubsequence("ababeaa","bcaeada"));
    }
    public static void main(String[] args) {
        String a = "abc";
        String b = "def";
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }
}
