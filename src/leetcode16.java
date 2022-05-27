import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class leetcode16 {
    static int result = 9999999;
    public static void dfs(int index, int[] nums, int target, int curSum, Deque<Integer> path){
        if(path.size()==3){
            if(Math.abs(curSum-target)<Math.abs(result-target)) {
                result = curSum;
            }
            return;
        }
        for (int i = index; i < nums.length; i++) {
            path.addLast(nums[i]);
            curSum = curSum+nums[i];
            dfs(i+1,nums,target,curSum,path);
            curSum = curSum-nums[i];
            path.removeLast();
        }
    }
    public static int threeSumClosest(int[] nums, int target) {
        Deque<Integer> deque = new LinkedList<>();
        dfs(0,nums,target,0,deque);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{0,0,0},1));
    }
}
