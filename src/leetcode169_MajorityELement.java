import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class leetcode169_MajorityELement {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            if(integerIntegerEntry.getValue()>nums.length/2){
                result = integerIntegerEntry.getKey();
            }
        }
        return result;
    }
    @Test
    public void test(){
        System.out.println(majorityElement(new int[]{3,3,4}));
    }
}
