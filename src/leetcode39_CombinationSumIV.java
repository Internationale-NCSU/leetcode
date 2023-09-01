import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class leetcode39_CombinationSumIV {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result,candidates,new LinkedList<>(),target,0,0);
        return result;
    }
    public void backtracking(List<List<Integer>> result, int[] candidates, Deque<Integer> deque, int target, int curSum, int index){
        if(curSum==target){
            result.add(new ArrayList<>(deque));
            return;
        }
        if(curSum>target){
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            deque.addLast(candidates[i]);
            backtracking(result,candidates,deque,target,curSum+candidates[i],i);
            deque.removeLast();
        }
    }
    @Test
    public void test(){
        System.out.println(combinationSum(new int[]{2,3,6,7},7));
    }
}
