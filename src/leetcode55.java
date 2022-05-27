public class leetcode55 {
    public static boolean canJump(int[] nums) {
        int furthestLoc = 0;
        boolean reachable = false;

        for (int i = 0; i < nums.length; i++) {
            int loc = i + nums[i];
            if(loc>furthestLoc){
                furthestLoc = loc;
            }
            if(furthestLoc<=i){
                break;
            }
        }
        if(furthestLoc>=nums.length-1){
            reachable = true;
        }
        return reachable;
    }

    public static void main(String[] args) {
        int[] arr = {2,0,0};
        System.out.println(canJump(arr));
    }
}
