import org.junit.Test;

public class leetcode5_LongestPalindromicSubstring_II {
    public String longestPalindrome(String s) {
        boolean[][] dp = new  boolean[s.length()][s.length()];
        String result = s.substring(0,1);
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int i = 1; i < s.length(); i++) {
            for (int j = i-1; j >=0 ; j--) {
                if(s.charAt(i)!=s.charAt(j)){
                    dp[j][i] = false;
                }else if(s.charAt(i)==s.charAt(j)){
                    if(i-j==1) {
                        dp[j][i] = true;
                    }else {
                        dp[j][i] = dp[j+1][i-1];
                    }
                    if(dp[j][i]){
                        if(i-j+1>result.length()) {
                            result = s.substring(j, i + 1);
                        }
                    }
                }
            }
        }
        return result;
    }
    @Test
    public void test(){
        System.out.println(longestPalindrome("dadb"));
    }
}
