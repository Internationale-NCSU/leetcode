import java.util.Arrays;

public class leetcode63 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            if(obstacleGrid[i][0]==0) {
                dp[i][0] = 1;
            }else {
                break;
            }
        }
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if(obstacleGrid[0][i]==0) {
                dp[0][i] = 1;
            }else {
                break;
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if(obstacleGrid[i][j]==0){
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    public static void main(String[] args) {
        int[][] matrix = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(matrix));
    }
}
