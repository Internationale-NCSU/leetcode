import org.junit.Test;

public class leetcode6189_LongestSubarrayWithMaximumBitwiseAnd {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int curMax = 1;
        int curRes = 1;
        while(right<nums.length){
            int curNum = nums[right];
            curRes = curRes & nums[right];

            if(curRes>=curMax){
                curMax = curRes;
                maxLen = right-left+1;
                right++;
            }else if(curNum>curRes){
                right++;
                left = right;
                curRes = curNum;
            }else {
                curRes = 1;
                right++;
                left = right;
            }
        }
       return maxLen;
    }
    @Test
    public void test(){
        System.out.println(longestSubarray(new int[]{311155,311155,311155,311155,311155,311155,311155,311155,201191,311155}));
    }
}
