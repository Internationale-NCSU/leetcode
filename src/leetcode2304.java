import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class leetcode2304 {
    private Map<String,Integer> memo = new HashMap<>();
    public int minPathCost(int[][] grid, int[][] moveCost) {
        return backTracking(grid,moveCost,0,0,-1);
    }
    public int backTracking(int[][] grid,int[][] moveCost, int start, int index, int from){
        if(start==grid.length){
            return 0;
        }
        String key = keyMaker(start,index,from);
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        int min = Integer.MAX_VALUE;
        //current level: grid[start]
        //traverse node in this level:
        for (int i = 0; i < grid[start].length; i++) {
            // 'i' represent the i th node on this level will be assigned as index to next recursion.
            //grid[start][i]
            int tmp = 0;
            if(from!=-1) {
                for (int j = 0; j < grid[start].length; j++) {
                    int value = grid[start-1][from];
                    tmp = moveCost[value][i]+grid[start][index] + backTracking(grid,moveCost,start+1,j,i);
                }
            }else {
                for (int j = 0; j < grid[start].length; j++) {
                    tmp = grid[start][index] + backTracking(grid,moveCost,start+1,j,i);
                }
            }
            min = Math.min(tmp,min);
        }
        memo.put(key,min);
        return min;
    }
    String keyMaker(int start,int index,int from){
        return " "+start+"_"+index+"_"+from;
    }
    @Test
    public void test(){
        System.out.println(minPathCost(
                new int[][]{{5,1,2},{4,0,3}},
                new int[][]{{12,10,15},{20,23,8},{21,7,1},{8,1,13},{9,10,25},{5,3,2}}
                ));
    }
}
