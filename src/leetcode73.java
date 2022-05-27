import java.util.HashSet;
import java.util.Set;

public class leetcode73 {
    public static void setZeroes(int[][] matrix) {
        Set<Integer> col = new HashSet<>();
        Set<Integer> row = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j]==0){
                    col.add(i);
                    row.add(j);
                }
            }
        }
        for (Integer integer : col) {
            for (int i = 0; i < matrix[integer].length; i++) {
                matrix[integer][i] = 0;
            }
        }
        for (Integer integer : row) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][integer] = 0;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1,1},{1,0,1,0},{1,1,1,1}};
        setZeroes(matrix);
    }
}
