import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class leetcode46_PermutationIII {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        backtrack(nums,result,new LinkedList<>(),new boolean[nums.length]);
        return result;
    }
    public void backtrack(int[] nums, List<List<Integer>> result, Deque<Integer> path, boolean[] visited){
        if(path.size()== nums.length){
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(visited[i]==true){
                continue;
            }else {
                path.add(nums[i]);
                visited[i] = true;
                backtrack(nums,result,path,visited);
                path.removeLast();
                visited[i] = false;
            }
        }
    }
    @Test
    public void test(){
        System.out.println(permute(new int[]{1}));;
    }
}
