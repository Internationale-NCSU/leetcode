import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class leetcode_15_II {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer,Integer> map = new HashMap<>();
        List<List<Integer>> result = new LinkedList<>();
        int separate = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.containsKey(nums[i])?map.get(nums[i])+1:1);
        }

        for (int i = 0; i < nums.length-2; i++) {
            map.replace(nums[i],map.get(nums[i])-1);
            for (int j = i+1; j < nums.length-1; j++) {
                map.replace(nums[j],map.get(nums[j])-1);
                int target = -nums[i]-nums[j];
                if(map.containsKey(target)&&map.get(target)!=0){
                    List<Integer> tmpList = new LinkedList<>();
                    tmpList.add(nums[i]);
                    tmpList.add(nums[j]);
                    tmpList.add(target);
                    result.add(tmpList);
                }
                map.replace(nums[j],map.get(nums[j])+1);
                if(nums[j+1]==nums[j]){
                    j++;
                }
            }
            if(nums[i+1]==nums[i]){
                i++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
}
