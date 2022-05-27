import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.regex.Matcher;

public class LeetCode542 {
    public static void main(String[] args) {
        int a[][] = {{0, 0, 0, 0, 0}};
        int result[][] = Solution542.updateMatrix(a);
        for (int[] i : result) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}

class Solution542 {
    public static int[][] updateMatrix(int[][] matrix) {
        /*Map<int[],Integer> zero_Map = new HashMap<>();
        for(int i =0;i<matrix.length;i++){
            for(int j =0; j<matrix[i].length;j++){
                if(matrix[i][j]==0) {
                    int[] location = {i,j};
                    zero_Map.put(location,0);
                }
            }
        }
        for(int i =0;i<matrix.length;i++){
            for(int j =0; j<matrix[i].length;j++){
                if(matrix[i][j]==0) continue;
                else{
                   matrix[i][j] = findZero(i,j,matrix);
                }
            }
        }
         */
        int row = matrix.length;
        int col = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] MarkList = new int[row * col][2];
        int distance = 0;
        for (int[] i : matrix) {
            for (int j : i) {

            }
        }


        return matrix;
    }

    /*
    public static int findZero(int x,int y,int[][] matrix){

        int min_x = 99;
        int min_y = 99;
        //x axis traverse elements:
        //System.out.println("x axis: "+matrix[x].length);
        for(int i = 0 ;i < matrix[x].length;i++){
            if(matrix[x][i]==0&&Math.abs(y-i)<min_x) min_x = Math.abs(y-i);
        }
        //y axis traverse elements:
       // System.out.println("y axis:" +matrix.length);
        for(int i = 0 ;i < matrix.length;i++){
            if(matrix[i][y]==0&&Math.abs(x-i)<min_y) min_y = Math.abs(x-i);
        }
        int result = Math.min(min_x,min_y);
        return  result;
    }*/
}
