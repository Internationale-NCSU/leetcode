import java.util.HashMap;
import java.util.Map;

public class leetcode2201 {
    public static int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        Map<Integer,Integer> distribution = new HashMap<>();
        int[][] board = new int[n][n];
        int count = 1;
        for (int[] artifact : artifacts) {
            int[] topLeft = {artifact[0],artifact[1]};
            int[] bottomRight = {artifact[2],artifact[3]};
            int area = 0;
            for (int i = topLeft[0]; i <= bottomRight[0]; i++) {
                for (int j = topLeft[1]; j <= bottomRight[1]; j++) {
                    board[i][j] = count;
                    area++;
                }
            }
            distribution.put(count,area);
            count++;
        }
        int result = 0;
        for (int[] ints : dig) {
            int row = ints[0];
            int col = ints[1];
            if(board[row][col]!=0){
                if(distribution.get(board[row][col])-1==0){
                    result++;
                    continue;
                }
                distribution.replace(board[row][col],distribution.get(board[row][col])-1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        digArtifacts(2,new int[][]{{0,0,0,0},{0,1,1,1}},new int[][]{{0,0},{0,1},{1,1}});
    }
}
