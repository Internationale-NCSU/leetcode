import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;

public class leetcode130 {
    static final int[][] DIRECTION = new int[][]{
        {1,0},
        {-1,0},
        {0,1},
        {0,-1}
    };
    public static void dfs(char[][] board,int row,int col){
        if(row<0||col<0||row>board.length-1||col>board[0].length-1||board[row][col]!='O'){
            return;
        }
        board[row][col] = 'P';
        for (int i = 0; i < DIRECTION.length; i++) {
            int[] offset = DIRECTION[i];
            dfs(board,row+offset[0],col+offset[1]);
        }
    }
    public static void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        List<Pair<Integer,Integer>> border = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            if(board[i][0]=='O'){
                border.add(new Pair<>(i,0));
            }
            if(board[i][col-1]=='O'){
                border.add(new Pair<>(i,col-1));
            }
        }
        for (int i = 0; i < col; i++) {
            if(board[0][i]=='O'){
                border.add(new Pair<>(0,i));
            }
            if(board[row-1][i]=='O'){
                border.add(new Pair<>(row-1,i));
            }
        }
        for (Pair<Integer, Integer> pair : border) {
            dfs(board,pair.getKey(),pair.getValue());
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j]=='P'){
                    board[i][j]='O';
                }else if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'O','X','X','X'},
                {'O','O','X','X'},
                {'O','X','X','X'}
        };
        solve(board);
    }
}
