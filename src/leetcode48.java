public class leetcode48 {
    public static int[][] rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length/2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[i].length-j-1];
                matrix[i][matrix[i].length-j-1] = tmp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length-i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length-j-1][matrix.length-i-1];
                matrix[matrix.length-j-1][matrix.length-i-1] = tmp;
            }
        }
        return matrix;
    }
    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        int count = 0;
        System.out.println("---origin---");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = count;
                count++;
                System.out.print(matrix[i][j]+",");
            }
            System.out.println();
        }
        System.out.println("---rotation---");
        matrix = rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]+",");
            }
            System.out.println();
        }
    }
}
