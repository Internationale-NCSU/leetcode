import java.util.*;

public class leetcode416 {
    static int totalSum;
    public static boolean recursion(Deque<Integer> path, int index, int[] nums, Set<Deque<Integer>> memo,int curSum){
        boolean isDivided = false;
        if(memo.contains(path)){
            return false;
        }
        if(index==nums.length){
            return false;
        }
        if(curSum>totalSum/2){
            memo.add(path);
            return false;
        }
        if(curSum==totalSum/2){
            return true;
        }
        for (int i = index; i < nums.length; i++) {
            path.addLast(nums[i]);
            if(isDivided = recursion(path,i,nums,memo,curSum+nums[i])){
                break;
            }
            path.removeLast();
        }
        return isDivided;
    }
    public static boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            totalSum = totalSum + nums[i];
        }
        return recursion(new LinkedList<>(),0,nums,new HashSet<>(),0);
    }
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1,1}));
    }
}
