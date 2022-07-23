import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class leetcode46_PermutationsII {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        backtracking(nums,result,new LinkedList<>(),new boolean[nums.length]);
        return result;
    }
    public void backtracking(int[] nums, List<List<Integer>> result, Deque<Integer> path, boolean[] visited){
        if(path.size()==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!visited[i]){
                path.add(nums[i]);
                visited[i]=true;
                backtracking(nums,result,path,visited);
                visited[i]=false;
                path.removeLast();
            }else {
                continue;
            }
        }
    }
    @Test
    public void test(){
        System.out.println(permute(new int[]{}));
    }
}
