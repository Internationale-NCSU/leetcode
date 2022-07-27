import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class leetcode39_CombinationSumIII {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        backtracking(result,candidates,target,0,new LinkedList<>(),0);
        return result;
    }
    public void backtracking(List<List<Integer>> list, int[] candidates, int target, int index, Deque<Integer> path, int sum){
        if(sum>target){
            return;
        }
        if(sum==target){
            List<Integer> result = new LinkedList(path);
            list.add(result);
            return;
        }
        for(int i=index;i<candidates.length;i++){
            path.add(candidates[i]);
            backtracking(list,candidates,target,i,path,sum+candidates[i]);
            path.removeLast();
        }
    }
}
