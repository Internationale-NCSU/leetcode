public class leetcode55_II {

    public static boolean canJump(int[] nums) {
        if(nums.length==1){
            return true;
        }
        int[] position = new int[nums.length];
        int maxPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i>maxPos){
                break;
            }
            if(i==0){
                position[i] = nums[i];
                maxPos = position[i];
            }else {
                position[i] = Math.max(i + nums[i], position[i-1]);
                maxPos = position[i];
            }
            if(position[i]>=nums.length-1){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(canJump(nums));
    }
}
