import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class leetcode39_CombinationSum {
    public static void backtracking(int[] candidates, int target, List<List<Integer>> result, Deque<Integer> path,int curSum,int index){
        if(curSum==target){
            List<Integer> list = new LinkedList<>(path);
            result.add(list);
            return;
        }
        for (int i = index; i < candidates.length ; i++) {
            curSum = curSum+candidates[i];
            if(curSum<=target){
                path.addLast(candidates[i]);
                backtracking(candidates,target,result,path,curSum,index);
                path.removeLast();
            }else {
                return;
            }
            curSum = curSum-candidates[i];
            index++;
        }
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Deque<Integer> path = new LinkedList<>();
        Arrays.sort(candidates);
        backtracking(candidates,target,result,path,0,0);
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        System.out.println(combinationSum(arr,7));
    }
}
