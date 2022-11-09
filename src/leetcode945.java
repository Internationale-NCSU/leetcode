import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class leetcode945 {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int nextVal = nums[0]+1;
        int step = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]<=nums[i-1]){
                step += nextVal - nums[i];
                nums[i] = nextVal;
                nextVal++;
            }else {
                nextVal = Math.max(nextVal+1,nums[i]++);
            }
        }
        return step;

    }
}
