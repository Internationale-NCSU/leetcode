
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class leetcode787 {
    int[][] map ;
    final static int INDEX = 0;
    final static int COST = 1;
    final static int INTERMEDIATE = 2;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i],10000000);
            map[i][i]=0;
        }
        for (int[] flight : flights) {
            map[flight[0]][flight[1]] = flight[2];
        }
    return 0;
    }
    int dijkstra(int n, int[][] map,int src,int dst,int k){
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b)->{return a[COST]-b[COST];});
        boolean[] visited = new boolean[n];
        int[] cost = new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        int[] departure = new int[3];
        departure[INDEX] = src;
        departure[COST] = 0;
        departure[INTERMEDIATE] = 0;
        priorityQueue.add(departure);
        while(!priorityQueue.isEmpty()){
            int[] curPosition = priorityQueue.poll();
            int curIndex = curPosition[INDEX];
            int curCost = curPosition[COST];
            int curInter = curPosition[INTERMEDIATE];
            for (int i = 0; i < n; i++) {
                if(i==curIndex){
                    continue;
                }else {
                    int costToI = map[curIndex][i];
                    if(cost[curIndex]+costToI<cost[i]){
                        cost[i] = costToI;
                    }
                }
            }
            visited[curIndex] = true;
        }
        return 0;
    }
    @Test
    public void test(){
        int[][] flights = new int[4][3];
        flights[0] = new int[] {0,1,1};
        flights[1] = new int[] {0,2,5};
        flights[2] = new int[] {1,2,1};
        flights[3] = new int[] {2,3,1};
        System.out.println(findCheapestPrice(4,flights,0,3,1));
    }
}
