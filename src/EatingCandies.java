import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class EatingCandies {
    public int maximumCandies(int[] candies){
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < candies.length; i++) {
            sum+=candies[i];
            map.put(sum,i);
        }
        sum = 0;
        int count = 0;
        for (int i = candies.length-1; i >= 0 ; i--) {
            sum += candies[i];
            if(map.containsKey(sum)){
                if(i > map.get(sum)) {
                    int cur = candies.length - 1 - i + 1 + map.get(sum) + 1;
                    count = Math.max(count, cur);
                }
            }
        }
        return count;
    }
    @Test
    public void test(){
        int[] candies = {0,0,1,2,1,1,1};
        System.out.println(maximumCandies(candies));
    }
}
