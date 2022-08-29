import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode529_Minesweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        if(board[click[0]][click[1]]=='M'){
            board[click[0]][click[1]]='X';
            return board;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(click);
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int row=pos[0];
            int col=pos[1];
            visited[row][col] = true;
            char c = searchAround(board,row,col);
            if(c>='0'&&c<='8'){
                board[row][col] = c;
                continue;
            }else if(c=='B') {
                board[row][col] = c;
                int[] DIRECTION = {-1,0,1};
                for (int i1 : DIRECTION) {
                    for (int i2 : DIRECTION) {
                        int rrow = row+i1;
                        int ccol = col+i2;
                        if(rrow>=0&&ccol>=0&&rrow<board.length&&ccol<board[0].length&&!visited[rrow][ccol]){
                            queue.add(new int[]{rrow,ccol});
                        }
                    }
                }
            }else {
                continue;
            }
        }
        return board;
    }
    public char searchAround(char[][] board,int i,int j){
        int[] row = new int[3];
        int[] col = new int[3];
        for (int k = 0; k < 3; k++) {
            row[k] = i-1+k;
            col[k] = j-1+k;
        }
        int count = 0;
        for (int i1 : row) {
            for (int i2 : col) {
                if(i1>=0&&i2>=0&&i1<board.length&&i2<board[0].length){
                    if(board[i1][i2]=='M'){
                        count++;
                    }
                }
            }
        }
        return count==0?'B': (char) ('0' + count);
    }
    @Test
    public void test(){
        char[][] board = {{'E','E','E','E','E'},{'E','E','E','E','E'},{'E','E','E','E','E'},{'E','E','E','E','E'}};
        System.out.println(updateBoard(board,new int[]{1,1}));
    }
}
