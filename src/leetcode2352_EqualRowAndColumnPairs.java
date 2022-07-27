import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class leetcode2352_EqualRowAndColumnPairs {
    public int equalPairs(int[][] grid) {
        Map<String,Integer> map = new HashMap<>();
        for (int[] ints : grid) {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < ints.length; i++) {
                s.append(ints[i]+",");
            }
            if(map.containsKey(s.toString())){
                map.put(s.toString(),map.get(s.toString())+1);
            }else {
                map.put(s.toString(),1);
            }
        }
        int count = 0;
        for(int col=0; col<grid[0].length; col++){
            StringBuilder s = new StringBuilder();
            for(int row=0; row<grid.length;row++){
                s.append(grid[row][col]+",");
            }
            if(map.containsKey(s.toString())){
                count=count+map.get(s.toString());
            }
        }
        return count;
    }
    @Test
    public void test(){
        System.out.println(equalPairs(new int[][]{{11,1},{1,11}}));
    }
}
