import org.junit.Test;

import java.util.Arrays;

public class leetcode128_LongestConsequenceSequence_Sort {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0||nums.length==1){
            return 0;
        }
        Arrays.sort(nums);
        int consecutive = 1;
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==nums[i-1]+1){
                consecutive++;
                result = Math.max(result,consecutive);
            }else if(nums[i]==nums[i-1]){
                continue;
            } else {
                consecutive = 1;
            }
        }
        return result;
    }
    @Test
    public void test(){
        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
}
