import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class leetcode560SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int result = 0 ;
        int sum = 0;
        map.put(sum,1);
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if(map.containsKey(sum-k)) {
                result+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return result;
    }
    @Test
    public void test(){
        System.out.println(subarraySum(new int[]{1,2,3},3));
    }
}

