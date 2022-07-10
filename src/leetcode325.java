import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class leetcode325 {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int preSum = 0;
        int len = 0;
        for (int i = 0; i < nums.length ; i++) {
            preSum+=nums[i];
            if(!map.containsKey(preSum)){
                map.put(preSum,i);
            }
            if(map.containsKey(preSum-k)){
                len=Math.max(len,i-map.get(preSum-k));
            }

        }
        return len;
    }
    @Test
    public void test(){
        System.out.println(maxSubArrayLen(new int[]{1,-1,5,-2,3},2));
    }
}
