import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class leetcode2357_MakeArrayZeroBySubtractingEqualAmounts {
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(num!=0){
                set.add(num);
            }
        }
        return set.size();
    }
    @Test
    public void test(){
        System.out.println(minimumOperations(new int[]{1,5,0,3,5}));
    }
}
