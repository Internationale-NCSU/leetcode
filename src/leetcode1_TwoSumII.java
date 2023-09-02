import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class leetcode1_TwoSumII {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target-nums[i];
            if(map.containsKey(diff)){
                return new int[]{map.get(diff),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
    @Test
    public void test(){
        System.out.println(twoSum(new int[]{2,7,11,15},9));
    }
}
