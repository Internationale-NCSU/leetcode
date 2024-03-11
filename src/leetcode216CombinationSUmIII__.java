import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class leetcode216CombinationSUmIII__ {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new LinkedList<>();
        backtracking(result, new LinkedList<>(), 1, k, n, 0);
        return result;
    }
    public void backtracking(List<List<Integer>> result, Deque<Integer> path, int num, int k, int n, int sum){
        if(sum==n&&path.size()==k){
            result.add(new LinkedList<>(path));
        }
        if( sum > n || num > 9 || path.size() >= k ){
            return;
        }
        path.addLast(num);
        for (int i = num+1; i < 9; i++) {
            sum += num;
            backtracking(result, path, i, k, n, sum);
            sum -= num;
            path.removeLast();
        }

    }
    @Test
    public void test(){
        combinationSum3(3,7);
    }
}
