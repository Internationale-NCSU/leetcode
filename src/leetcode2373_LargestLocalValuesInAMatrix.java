import org.junit.Test;

public class leetcode2373_LargestLocalValuesInAMatrix {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length-2;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = scanMatrix(grid,i,j);
            }
        }
        return result;
    }
    public int scanMatrix(int[][]grid,int indexI,int indexJ){
        int max = Integer.MIN_VALUE;
        for (int i = indexI; i < indexI+3; i++) {
            for (int j = indexJ; j < indexJ+3; j++) {
                max = Math.max(max,grid[i][j]);
            }
        }
        return max;
    }
    @Test
    public void test(){
        int[][] matrix = new int[][]
                {
                        {9,9,8,1},
                        {5,6,2,6},
                        {8,2,6,4},
                        {6,2,2,2}
                };
        int[][] result = largestLocal(matrix);
        System.out.println(largestLocal(matrix));
    }
}
