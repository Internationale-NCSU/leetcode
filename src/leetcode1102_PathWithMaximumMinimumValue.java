import org.junit.Test;

import java.util.PriorityQueue;

public class leetcode1102_PathWithMaximumMinimumValue {
    public int maximumMinimumPath(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)->{
                return grid[b[0]][b[1]] - grid[a[0]][a[1]];
            }
        );
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int min = Integer.MAX_VALUE;
        pq.offer(new int[]{0,0});
        visited[0][0] = true;
        while (!pq.isEmpty()){
            int[] pos = pq.poll();
            int row = pos[0];
            int col = pos[1];
            min = Math.min(min, grid[row][col]);
            visited[row][col] = true;
            if(row == grid.length-1&&col == grid[0].length-1){
                break;
            }

            if(row+1<grid.length&&!visited[row+1][col]){
                pq.offer(new int[]{row+1,col});
            }
            if(col+1<grid[0].length&&!visited[row][col+1]){
                pq.offer(new int[]{row,col+1});
            }
            if(col-1>=0&&!visited[row][col-1]){
                pq.offer(new int[]{row, col-1});
            }
            if(row-1>=0&&!visited[row-1][col]){
                pq.offer(new int[]{row-1, col});
            }
        }
        return min;
    }
    @Test
    public void test(){
        System.out.println(maximumMinimumPath(new int[][]{
                {5,4,5},
                {1,2,6},
                {7,4,6}
        }));
    }
}
