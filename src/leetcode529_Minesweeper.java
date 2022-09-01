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
        int[] DIRECTION = {-1,0,1};
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int row=pos[0];
            int col=pos[1];
            visited[row][col] = true;
            char c = searchAround(board,row,col,DIRECTION);
            if(c>='0'&&c<='8'){
                board[row][col] = c;
                continue;
            }else if(c=='B') {
                board[row][col] = c;
                for (int i1 : DIRECTION) {
                    for (int i2 : DIRECTION) {
                        int rrow = row+i1;
                        int ccol = col+i2;
                        if(rrow>=0&&ccol>=0&&rrow<board.length&&ccol<board[0].length&&!visited[rrow][ccol]){
                            queue.offer(new int[]{rrow,ccol});
                            visited[rrow][ccol]=true;
                        }
                    }
                }
            }
        }
        return board;
    }
    public char searchAround(char[][] board,int i,int j,int[] DIRECTION){
        int count = 0;
        for (int i1 : DIRECTION) {
            for (int i2 : DIRECTION) {
                int rrow = i+i1;
                int ccol = j+i2;
                if(rrow>=0&&ccol>=0&&rrow<board.length&&ccol<board[0].length){
                    if(board[rrow][ccol]=='M'){
                        count++;
                    }
                }
            }
        }
        return count==0?'B': (char) ('0' + count);
    }
    @Test
    public void test(){
        char[][] board = {{'E','E','E','E','E'},{'E','E','M','E','E'},{'E','E','E','E','E'},{'E','E','E','E','E'}};
        System.out.println(updateBoard(board,new int[]{0,0}));
    }
}
