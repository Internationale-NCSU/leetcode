import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class leetcode2261 {
    private static int subarray = 0;
    public int countDistinct(int[] nums, int k, int p) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            String s = "";
            for (int j = i; j < nums.length; j++) {
                if(nums[j]%p==0){
                    count++;
                }
                if(count>k){
                    break;
                }
                s = s+Integer.toString(nums[j])+"_";
                set.add(s);
            }
        }
        return set.size();
    }
    @Test
    public void test(){
        System.out.println(countDistinct(new int[]{2,3,3,2,2},2,2));
    }
}
