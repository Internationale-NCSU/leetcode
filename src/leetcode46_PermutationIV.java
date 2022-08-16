import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class leetcode46_PermutationIV {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        dfs(nums,list,new LinkedList<>(),nums.length,new boolean[nums.length]);
        return list;
    }
    public void dfs(int[] nums, List<List<Integer>> list, Deque<Integer> deque, int n,boolean[] visited){
        if(n==deque.size()){
            list.add(new LinkedList<>(deque));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!visited[i]) {
                deque.addLast(nums[i]);
                visited[i] = true;
                dfs(nums,list,deque,n,visited);
                visited[i] = false;
                deque.removeLast();
            }
        }
    }
    @Test
    public void test(){
        System.out.println(permute(new int[]{1,2,3}));
    }
}
