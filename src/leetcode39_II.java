import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetcode39_II {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        backtracking(result,new ArrayList<>(),0,0,target,candidates);
        return result;
    }
    public void backtracking(List<List<Integer>> result,List<Integer> currentList,int curSum, int index, int target, int[] candidates){
        if(curSum==target){
            result.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if(curSum+candidates[i]<=target){
                currentList.add(candidates[i]);
                backtracking(result,currentList,curSum+candidates[i],i,target,candidates);
                currentList.remove(currentList.size()-1);
            }
        }
    }
    @Test
    public void test(){
        System.out.println(combinationSum(new int[]{2,3,6,7},8));
    }
}
