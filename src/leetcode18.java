
import java.util.*;

public class leetcode18 {
    public static void backTracking(int[] nums, int target, int curSum, int index, List<List<Integer>> result, Deque<Integer> deque){
        if(deque.size()==4){
            if(curSum==target){
                List<Integer> list = new LinkedList<>(deque);
                result.add(list);
            }
            return;
        }
        for (int i = index; i < nums.length; i++) {
            deque.addLast(nums[i]);
            backTracking(nums,target,curSum+nums[i],i+1,result,deque);
            deque.removeLast();
        }
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Deque<Integer> deque = new LinkedList<>();
        Arrays.sort(nums);
        List<int []> list = new LinkedList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        backTracking(nums,target,0,0,result,deque);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{2,2,2,2},8));
    }
}
