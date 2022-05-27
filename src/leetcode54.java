import java.util.LinkedList;
import java.util.List;

public class leetcode54 {

    public static List<Integer> spiralOrder(int[][] matrix) {
        int size = matrix.length * matrix[0].length;
        List<Integer> result = new LinkedList<>();
        //direct: 0 right, 1 down, 2 left, 3 up;
        int direct = 0;
        int i = 0;
        int j = 0;
        while (true) {
            if (result.size() == size) {
                break;
            }
            if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[i].length || matrix[i][j] == 101) {
                switch (direct) {
                    case 0: {
                        j = j-1;
                        direct = 1;
                        break;
                    }
                    case 1: {
                        i = i-1;
                        direct = 2;
                        break;
                    }
                    case 2: {
                        j = j+1;
                        direct = 3;
                        break;
                    }
                    case 3: {
                        i = i+1;
                        direct = 0;
                        break;
                    }
                }

            }
            switch (direct) {
                case 0: {
                    if(matrix[i][j]!=101) {
                        result.add(matrix[i][j]);
                    }
                    matrix[i][j] = 101;
                    j = j + 1;
                    break;
                }
                case 1: {
                    if(matrix[i][j]!=101) {
                        result.add(matrix[i][j]);
                    }
                    matrix[i][j] = 101;
                    i = i + 1;
                    break;
                }
                case 2: {
                    if(matrix[i][j]!=101) {
                        result.add(matrix[i][j]);
                    }
                    matrix[i][j] = 101;
                    j = j-1;
                    break;
                }
                case 3: {
                    if(matrix[i][j]!=101) {
                        result.add(matrix[i][j]);
                    }
                    matrix[i][j] = 101;
                    i = i-1;
                    break;
                }
            }
        }
            return result;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(spiralOrder(matrix));
    }
}
