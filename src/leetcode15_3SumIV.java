import org.junit.Test;

import java.util.*;

public class leetcode15_3SumIV {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            twoSum(nums,0-nums[i],result,i+1,nums[i],visited);
        }
        return result;
    }
    public void twoSum(int[] nums, int target, List<List<Integer>> result,int from, int cur, Set<Integer> visited){
        Set<Integer> set = new HashSet<>();
        if(!visited.contains(cur)){
            for (int i = from; i < nums.length; i++) {
                if(set.contains(target-nums[i])){
                    List<Integer> list = new ArrayList<>();
                    list.add(cur);
                    list.add(target-nums[i]);
                    list.add(nums[i]);
                    result.add(list);
                    visited.add(cur);
                }
            }
        }

    }
    @Test
    public void test(){
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
