public class leetcode221 {
    public static int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if(matrix[i-1][j-1]=='0'){
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]) + 1;
                    max = Math.max(dp[i][j],max);
                }
            }
        }
        return max*max;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},{'a','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        char[][] matrix_2 = {{'0','1'},{'0','1'}};
        System.out.println(maximalSquare(matrix_2));
    }
}
