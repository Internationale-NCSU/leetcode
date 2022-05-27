public class leetcode695 {
    static int maxArea = 0;
    static int area = 0;
    static int[][] DIRECTION = new int[][]{
        {1,0},
        {0,1},
        {-1,0},
        {0,-1}
    };
    public static void dfs(int[][] grid,int i,int j,int width,int height){
        if(i>=0&&i<height&&j>=0&&j<width&&grid[i][j]==1){
            grid[i][j] = 0;
            area = area+1;
            maxArea = Math.max(area,maxArea);
            for (int[] ints : DIRECTION) {
                dfs(grid,i+ints[0],j+ints[1],width,height);
            }
        }else {
            return;
        }
    }
    public static int maxAreaOfIsland(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j <width; j++) {
                if(grid[i][j]==1){
                    dfs(grid,i,j,width,height);
                }
                area = 0;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
            {0,0,1,0,0,0,0,1,1,0,0,0,0},
            {0,0,0,0,0,0,0,1,0,0,0,0,0},
            {0,1,1,0,1,0,0,1,0,0,0,0,0},
            {0,1,0,0,1,1,0,0,1,0,1,0,0},
            {0,1,0,0,1,1,0,0,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        System.out.println(maxAreaOfIsland(grid));
    }
}
