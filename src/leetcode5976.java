import java.util.HashSet;
import java.util.Set;

public class leetcode5976 {
    public static boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> checkValid = new HashSet<>();
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j]>=1&&matrix[i][j]<=n){
                    checkValid.add(matrix[i][j]);
                }else {
                    return false;
                }
            }
            if(checkValid.size()!=n){
                return false;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> checkValid = new HashSet<>();
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[j][i]>=1&&matrix[j][i]<=n){
                    checkValid.add(matrix[j][i]);
                }else {
                    return false;
                }
            }
            if(checkValid.size()!=n){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
