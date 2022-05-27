import java.util.Arrays;

public class leetcode561 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {6, 2, 6, 5, 1, 2};
        System.out.println(s.arrayPairSum(nums));
    }

    static class Solution {
        public int arrayPairSum(int[] nums) {
            Arrays.sort(nums);
            int sum = 0;
            for (int i = 0; i < nums.length; i = i + 2) {
                int min = nums[i] < nums[i + 1] ? nums[i] : nums[i + 1];
                sum = sum + min;
                //System.out.println("["+nums[i]+" "+nums[i+1]+"]");
                //System.out.println("sum:"+sum);
            }
            return sum;
        }
    }
}
