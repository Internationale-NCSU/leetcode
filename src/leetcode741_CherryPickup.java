import org.junit.Test;

public class leetcode741_CherryPickup {
    int[][] memo;
    boolean[][] cherryMap;
    boolean reachDestination = false;
    public int cherryPickup(int[][] grid) {
        memo = new int[grid.length][grid.length];
        cherryMap = new boolean[grid.length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if(grid[i][j]==1){
                    cherryMap[i][j] = true;
                }
            }
        }
        dfs(grid,0,0,0);
        return memo[grid.length-1][grid.length-1];
    }
    public void dfs(int[][] grid,int cherryCount,int row,int col){
        if(row==grid.length-1&&col==grid.length){
            reachDestination = true;
        }
        if(row>=grid.length||col>=grid.length||grid[row][col]==-1){
            return;
        }
        if(cherryCount>=memo[row][col]){
            if(grid[row][col]==1){
                memo[row][col] = cherryCount+1;
                grid[row][col]=0;
                dfs(grid,cherryCount+1,row+1,col);
                dfs(grid,cherryCount+1,row,col+1);
            }else {
                memo[row][col] = cherryCount;
                dfs(grid,cherryCount,row+1,col);
                dfs(grid,cherryCount,row,col+1);
            }
        }else {
            return;
        }
    }
    @Test
    public void test(){
        int[][] grid = new int[][]{
                {0,1,-1},
                {1,0,-1},
                {1,1,1}
        };
        System.out.println(cherryPickup(grid));
    }
}
