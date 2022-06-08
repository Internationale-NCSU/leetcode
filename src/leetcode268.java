import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class leetcode268 {
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= nums.length; i++) {
            set.add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            set.remove(nums[i]);
        }
        return (int)set.toArray()[0];
    }
    @Test
    public void test(){
        System.out.println(missingNumber(new int[]{1,2,3,4}));;
    }
}
