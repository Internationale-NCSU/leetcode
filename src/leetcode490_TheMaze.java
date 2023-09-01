import org.junit.Test;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class leetcode490_TheMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int R = maze.length;
        int C = maze[0].length;
        boolean result = false;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                int row = pos[0];
                int col = pos[1];
                if(row+1<R&&!visited[row+1][col]){
                    int r=row+1;
                    for (; r<maze.length ; r++) {
                        visited[r][col] = true;
                        if(maze[r][col]==1){
                            break;
                        }
                    }
                    if(r-1==destination[0]&&col==destination[1]){
                        result = true;
                        break;
                    }
                    queue.offer(new int[]{r-1,col});
                }
                if(row-1>=0&&!visited[row-1][col]){
                    int r = row-1;
                    for (; r >=0; r--) {
                        visited[r][col] = true;
                        if(maze[r][col]==1){
                            break;
                        }
                    }
                    if(r+1==destination[0]&&col==destination[1]){
                        result = true;
                        break;
                    }
                    queue.offer(new int[]{r+1,col});
                }
                if(col+1<C&&!visited[row][col+1]){
                    int c = col+1;
                    for (; c < C; c++) {
                        visited[row][c] = true;
                        if(maze[row][c]==1){
                            break;
                        }
                    }
                    if(row==destination[0]&&c-1==destination[1]){
                        result = true;
                        break;
                    }
                    queue.offer(new int[]{row,col-1});
                }
                if(col-1<C&&!visited[row][col-1]){
                    int c = col-1;
                    for (;c>=0;c--){
                        visited[row][c] = true;
                        if(maze[row][c]==1){
                            break;
                        }
                    }
                    if(row==destination[0]&&c+1==destination[1]){
                        result = true;
                        break;
                    }
                    queue.offer(new int[]{row, col+1});
                }
            }
        }
        return result;
    }
    @Test
    public void test(){
        System.out.println(hasPath(new int[][]{
                {0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}},
                new int[]{0,4}, new int[]{4,4}));
    }
}
