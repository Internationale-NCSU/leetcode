import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CollisionCount {
    class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    public void solution(int[][] centers){
        int[][] directions = new int[][]{
                {1,0},{1,1},{1,-1},{0,1},{0,-1},{-1,1},{-1,0},{-1,-1}
        };
        Map<Point,Integer> map = new HashMap<>();
        for (int i = 0; i < centers.length; i++) {
            Point p = new Point(centers[i][0],centers[i][1]);
            if(!map.containsKey(p)){
                map.put(p,1);
            }else {
                map.put(p,map.get(p)+1);
            }
        }
        int collision = 0;
        for (int i = 0; i < centers.length; i++) {
            Point p = new Point(centers[i][0],centers[i][1]);

        }
    }
}
