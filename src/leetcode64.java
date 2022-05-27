import java.util.Arrays;

public class leetcode64 {
    public static int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        if(grid.length>1){
            for (int i = 1; i < grid.length; i++) {
                dp[i][0] = dp[i-1][0]+grid[i][0];
            }
        }
        if(grid[0].length>1) {
            for (int i = 1; i < grid[0].length; i++) {
                dp[0][i] = dp[0][i-1] + grid[0][i];
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(i==0||j==0){
                    continue;
                }
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        int[][] matrix = {{1},{1},{4}};
        System.out.println(minPathSum(matrix));
    }
}
