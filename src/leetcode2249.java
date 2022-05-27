import org.junit.Test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class leetcode2249 {
    public int countLatticePoints(int[][] circles) {
        Set<String> set = new HashSet<>();
        for (int[] circle : circles) {
            int x = circle[0];
            int y = circle[1];
            int r = circle[2];
            for (int yy = y-r; yy <= y+r; yy++) {
                for (int xx = x-r; xx <= x+r; xx++) {
                    if((xx-x)*(xx-x)+(yy-y)*(yy-y)<=r*r){
                        set.add(xx+","+yy);
                    }
                }
            }
        }
        return set.size();
    }
    @Test
    public void test(){
        int[][] circles = {{2,2,2},{3,4,1}};
        System.out.println(countLatticePoints(circles));
    }
}
