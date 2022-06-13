import org.junit.Test;

public class leetcode240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int index =0;
        for (int i = 0; i < matrix.length; i++) {
            if(i!=0&&matrix[i][i]>target){
                for (int j = i; j < matrix[i].length; j++) {
                    if(target==matrix[i-1][j]){
                        return true;
                    }
                }
                for (int j = 0; j < i; j++) {
                    if(target==matrix[i][j]){
                        return true;
                    }
                }
                break;
            }
        }
        return false;
    }
}
