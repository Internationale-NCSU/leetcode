import java.util.Arrays;
import java.util.Map;

public class leetcode300 {
    public static int lengthOfLIS(int[] nums) {
       int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int longest = 0;
        for (int i:dp) {
            longest = Math.max(longest,i);
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS(arr));
    }
}
