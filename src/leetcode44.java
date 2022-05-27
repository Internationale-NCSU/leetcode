import java.util.Arrays;

public class leetcode44 {
    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length()+1][s.length()+1];
        dp[0][0] = true;
        if(s.length()==0){
            for (int i = 0; i < p.length(); i++) {
                if(p.charAt(i)!='*'){
                    return false;
                }
            }
            return true;
        }
        for (int i = 1; i < p.length()+1; i++) {
            for (int j = 1; j < s.length()+1; j++) {
                if(p.charAt(i-1)=='*'){
                    if(dp[i-1][j-1]){
                        Arrays.fill(dp[i],j-1,s.length()+1,true);
                        break;
                    }
                    if(dp[i-1][j]){
                        dp[i][j] = true;
                    }
                }else if(p.charAt(i-1)=='?'){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                dp[i][j] = p.charAt(i-1)==s.charAt(j-1);
                    if(i>0&&p.charAt(i-1)!='*'){
                        dp[i][j] = dp[i][j]&&dp[i-1][j-1];
                    }
                }
            }
        }
        return dp[p.length()][s.length()];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("abcabczzzde","*abc???de*"));
    }
}
