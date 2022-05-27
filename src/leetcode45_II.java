import java.util.Deque;
import java.util.HashMap;

public class leetcode45_II {
    public static int jump(int[] nums) {
        int step = 0;
        int start = 0;
        int end = 0;
        int maxJump = 0;
        while (true){
            if(end>=nums.length-1){
                break;
            }
            int upperBound = end<nums.length?end:nums.length-1;
            for (int i = start; i <= upperBound; i++) {
                if(i+nums[i]>end){
                    maxJump = i;
                    end = i+nums[i];
                }
            }
            start = maxJump;


            step++;
        }

        return step;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(jump(nums));
    }
}
