
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class leetcode289 {
    private final List<int[]> DIRECTION = Arrays.asList(
            new int[] {0,1},
            new int[] {1,0},
            new int[] {1,1},
            new int[] {1,-1},
            new int[] {-1,1},
            new int[] {-1,-1},
            new int[] {-1,0},
            new int[] {0,-1}
    );
    public void gameOfLife(int[][] board) {

        int[][] tmpBoard = new int[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                int countLive = 0;
                for (int[] direction : DIRECTION) {
                    int xOffset = row+direction[0];
                    int yOffset = col+direction[1];
                    if(xOffset<0||yOffset<0||xOffset>=board.length||yOffset>=board[0].length){
                        continue;
                    }else if(board[xOffset][yOffset] == 1){
                        countLive++;
                    }
                }
                if(board[row][col]==1&&countLive<2){
                    tmpBoard[row][col] = 0;
                }else if(board[row][col]==1&&countLive>=2&&countLive<=3){
                    tmpBoard[row][col] = 1;
                }else if(board[row][col]==1&&countLive>3){
                    tmpBoard[row][col] = 0;
                }else if(board[row][col]==0&&countLive==3){
                    tmpBoard[row][col] = 1;
                }else {
                    tmpBoard[row][col] = 0;
                }
            }
        }
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
              board[row][col] = tmpBoard[row][col];
            }
        }
    }

}
