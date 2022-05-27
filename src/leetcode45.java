public class leetcode45 {
    public static int jump(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int step = 0;
        int max = 0,curMax = 0;
        for (int i = 0; i < nums.length-1; i++) {
            max = Math.max(max,i+nums[i]);
            if(i>=curMax){
                step++;
                curMax = max;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,0,1,4};
        System.out.println(jump(nums));
    }
}
