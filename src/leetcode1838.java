import java.util.Arrays;

public class leetcode1838 {
    public static int maxFrequency(int[] nums, int k) {
        int frequency = 0,start=0,end=0,curSum = 0;
        Arrays.sort(nums);
        while(end<nums.length){
            while(nums[end]*(end-start+1) - curSum >k){
                curSum -= nums[start];
                start++;
            }
            curSum += nums[end];
            Math.max(frequency,end-start+1);
            end++;
        }
        return frequency;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,8,13};
        System.out.println(maxFrequency(nums,5));
    }
}
