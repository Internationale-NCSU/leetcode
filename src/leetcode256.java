import org.junit.Test;

import java.util.*;

public class leetcode256 {
    public int minCost(int[][] costs) {
        int cost = backTracking(costs,0,-1,new HashMap<>());
        return cost;
    }
    int backTracking(int[][]costs, int start, int colorIndex, Map<String,Integer> costByCombination){
        if(start==costs.length){
            return 0;
        }

        String key = keyMaker( start,colorIndex);
        if(costByCombination.containsKey(key)){
            return costByCombination.get(key);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < costs[0].length; i++) {
            if(i!=colorIndex){
                int temp = costs[start][i]+backTracking(costs,start+1,i,costByCombination);
                min = Math.min(min, temp);
            }
        }
        costByCombination.put(key,min);
        return min;
    }

    String keyMaker(int start,int colorIndex){
        return ""+start+"_"+colorIndex;
    }
    @Test
    public void test(){
        System.out.println(minCost(new int[][]{{17,2,17},{16,16,5},{14,3,19}}));
    }
}
