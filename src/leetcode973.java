import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class leetcode973 {

    public static int[][] kClosest(int[][] points, int k) {
        Map<Integer,Integer> map =new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            map.put(i,points[i][0]*points[i][0]+points[i][1]*points[i][1]);
        }
        Queue<Integer> queue = new PriorityQueue<>((a,b)->{return map.get(a)-map.get(b);});
        int[][] result = new int [k][];
        for (int i = 0; i < points.length; i++) {
            queue.offer(i);
        }
        for (int i = 0; i < k; i++) {
            int index = queue.poll();
            result[i] = points[index];
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{
                {1,3},{-2,2},{0,0},{3,2}
        };
        int[][] result = kClosest(points,3);
        for (int i = 0; i < result.length; i++) {
            System.out.println("["+result[i][0]+","+result[i][1]+"]");
        }
    }
}
