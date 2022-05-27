public class leetcode494 {
    static int count = 0;
    public static void recursion(int[] nums,int i,int sum,int target){
        if(i == nums.length){
            if(sum == target){
                count++;
            }
        }else {
            recursion(nums,i+1,sum+nums[i],target);
            recursion(nums,i+1,sum-nums[i],target);
        }
    }
    public static int findTargetSumWays(int[] nums, int target) {
        recursion(nums,0,0,target);
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        System.out.println(findTargetSumWays(nums,3));
    }
}
