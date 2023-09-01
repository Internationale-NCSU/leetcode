import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class leetcode46_PermutationsV {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(nums,result,new LinkedList<>(), new boolean[nums.length]);
        return result;
    }
    public void backtracking(int[] nums, List<List<Integer>> result, Deque<Integer> path,boolean[] isUsed){
        if(path.size()==nums.length){
            result.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if(!isUsed[i]){
                path.addLast(nums[i]);
                isUsed[i] = true;
                backtracking(nums,result,path,isUsed);
                isUsed[i] = false;
                path.removeLast();
            }
        }
    }
    @Test
    public void test(){
        List<List<Integer>> list = permute(new int[]{1,2,3});
        System.out.println(list);
    }
}

