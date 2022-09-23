import org.junit.Test;

public class leetcode209_MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0,right = 0;
        int sum = 0;
        int len = -1;
        while(right<nums.length){
            sum = sum + nums[right];
            while(left<=right&&sum>=target){
                if(len==-1){
                    len = right-left+1;
                }else {
                    len = Math.min(len,right-left+1);
                }
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return len;
    }
    @Test
    public void test(){
        System.out.println(minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
    }
}
