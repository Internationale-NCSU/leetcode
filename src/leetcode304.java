import org.junit.Test;

public class leetcode304 {
    class NumMatrix {
        int[][] preSumMatrix;
        public NumMatrix(int[][] matrix) {
            preSumMatrix = new int[matrix.length][matrix[0].length+1];
            for (int i = 0; i < preSumMatrix.length; i++) {
                for (int j = 1; j < preSumMatrix[i].length; j++) {
                    preSumMatrix[i][j] = preSumMatrix[i][j-1]+matrix[i][j-1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for (int i = row1; i <=row2 ; i++) {
                sum = sum+preSumMatrix[i][col2+1]-preSumMatrix[i][col1];
            }
            return sum;
        }
    }
    @Test
    public void test(){
        NumMatrix matrix = new NumMatrix(new int[][]{{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}});
        System.out.println(matrix.sumRegion(1,2,2,4));
    }
}
