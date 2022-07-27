import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class leetcode216_CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new LinkedList<>();
        backtracking(k,n,0,list,new LinkedList<>(),0);
        return list;
    }
    public void backtracking(int k, int n, int sum, List<List<Integer>> list, Deque<Integer> path, int index){
        if(sum==n&&path.size()==k){
            List<Integer> result = new LinkedList<>(path);
            list.add(result);
            return;
        }
        if(sum>n||path.size()>k){
            return;
        }
        for(int i = index+1;i<=9;i++){
            path.add(i);
            backtracking(k,n,sum+i,list,path,i);
            path.removeLast();
        }
    }
}
