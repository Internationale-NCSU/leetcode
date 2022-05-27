import java.util.Arrays;

public class leetcode97_II {
    public static boolean isInterleave(String s1, String s2, String s3) {
        boolean dp[][] = new boolean[s1.length()+1][s2.length()+1];
        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }
        dp[0][0] = true;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if(j==0&&i==0){
                    continue;
                }
                if(i==0){
                    dp[i][j] = s2.substring(0,j).equals(s3.substring(0,j));
                    continue;
                }
                if(j==0){
                    dp[i][j] = s1.substring(0,i).equals(s3.substring(0,i));
                    continue;
                }
                dp[i][j] = (dp[i-1][j]&&s2.charAt(j-1)==s3.charAt(i+j-1))||
                        (dp[i][j-1]&&s1.charAt(i-1)==s3.charAt(i+j-1));

//                (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1))
//                        || (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1));
            }
        }

        return dp[s1.length()][s2.length()];

    }
    public static void main(String[] args) {
        System.out.println(isInterleave("bce","ab","babce"));
    }
}
