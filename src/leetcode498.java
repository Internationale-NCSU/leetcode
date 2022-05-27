import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class leetcode498 {

    public static void diagonalTraverse(int row, int col, int m, int n, boolean direct, List<Integer> path,int[][] mat){
        //direct = true: towards right up;
        //direst = false: towards left down;
        //right up: row-1 col+1;
        //left down: row+1 col-1;
        //upper bound: row = 0,lower bound: row = m;
        //left bound: col = 0, right bound: col = n;
        if(path.size()==m*n){
            return;
        }
        path.add(mat[row][col]);
        if(direct) {
            if (row - 1 < 0 && col + 1 < n) {
                //start from :(row,col+1)
                diagonalTraverse(row,col+1,m,n,!direct,path,mat);
            } else if (col + 1 >= n) {
                //start from :(row+1,col)
                diagonalTraverse(row+1,col,m,n,!direct,path,mat);
            } else {
                //straight forward
                diagonalTraverse(row-1,col+1,m,n,direct,path,mat);
            }
        }else {
            if(col - 1 < 0 && row + 1 < m){
                //start from : (row+1,col)
                diagonalTraverse(row+1,col,m,n,!direct,path,mat);
            }else if(row + 1 >= m){
                //start from : (row, col+1)
                diagonalTraverse(row,col+1,m,n,!direct,path,mat);
            }else {
                diagonalTraverse(row+1,col-1,m,n,direct,path,mat);
            }
        }
    }

    public static int[] findDiagonalOrder(int[][] mat) {
        List<Integer> list = new LinkedList<>();
        diagonalTraverse(0,0,mat.length,mat[0].length,true,list,mat);
        Object[] arr = list.toArray();
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = (int)arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,2,3,4},{5,6,7,8}};
        int[] result = findDiagonalOrder(mat);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+",");
        }
    }
}
