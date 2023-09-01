import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class leetcode491_Non_decreasingSubsequence {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result,nums,new ArrayList<>(),0,nums[0]);
        return result;
    }
    public void backtracking(List<List<Integer>> result, int[] nums, List<Integer> path, int index,int pre){
        if(path.size()>=2){
            if(!result.contains(path)) {
                result.add(new ArrayList<>(path));
            }
        }
        for (int i = index; i < nums.length; i++) {
            if(nums[i]>=pre){
                path.add(nums[i]);
                backtracking(result,nums,path,i+1,nums[i]);
                path.remove(path.size()-1);
            }
        }
    }
    @Test
    public void test(){
        System.out.println(findSubsequences(new int[]{4,6,7,7}));
    }
}
