import org.junit.Test;

import java.util.*;

public class leetcode15_3SumIII {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Map<Integer,Integer> map = new HashMap<>();
        List<List<Integer>> list = new LinkedList<>();

        for (int i = 0; i < nums.length-1; i++) {
            map.put(nums[i],i);
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]!=nums[j]||nums[j]==0) {
                    if (map.containsKey(-(nums[i] + nums[j]))) {
                        List<Integer> tmp = new LinkedList<>();
                        tmp.add(-(nums[i] + nums[j]));
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        list.add(tmp);
                        i = j+1;
                    }
                }else {
                    break;
                }
            }
        }
        return list;
    }
    @Test
    public void test(){
        System.out.println(threeSum(new int[]{0,0,0}));
    }
    
}
