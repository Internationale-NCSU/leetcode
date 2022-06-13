
import java.util.Arrays;

public class leetcode62 {
    public static int dfs(int i,int j,int m,int n){
        if(i==m-1&&j==n-1){
            return 1;
        }
        if(i>m-1||j>n-1) {
            return 0;
        }
        return dfs(i+1,j,m,n)+dfs(i,j+1,m,n);
    }
    public static int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        Arrays.fill(dp[0],1);
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        if(m==1||n==1){
            return 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3,7));
    }
}
