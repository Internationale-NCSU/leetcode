import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class leetcode260 {
    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }else {
                set.add(nums[i]);
            }
        }
        result[0] = (int)set.toArray()[0];
        result[1] = (int)set.toArray()[1];
        return result;
    }
    @Test
    public void test(){
        System.out.println(singleNumber(new int[]{1,2,1,3,2,5}));
    }
}
