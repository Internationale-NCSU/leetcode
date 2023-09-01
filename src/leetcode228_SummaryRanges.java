import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class leetcode228_SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if(nums.length == 0){
            return result;
        }
        if(nums.length == 1){
            result.add(String.valueOf(nums[0]));
        }
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            while(i+1<nums.length&&nums[i+1]==nums[i]+1){
                i++;
            }
            if(nums[i]!=start){
                result.add(""+start+"->"+nums[i]);
            }else {
                result.add(""+start);
            }
        }
        return result;
    }
    @Test
    public void test(){
        System.out.println(summaryRanges(new int[]{0,1,2,4,5,7}));
    }
}
