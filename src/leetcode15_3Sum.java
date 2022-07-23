import java.util.*;

public class leetcode15_3Sum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for (int k = 0; k < nums.length-2; k++) {
            int target = -nums[k];
            int i = k+1;
            int j = nums.length-1;
            while(i<j){
                if(target==nums[i]+nums[j]){
                    List<Integer> result = new LinkedList<>();
                    result.add(nums[k]);
                    result.add(nums[i]);
                    result.add(nums[j]);
                    set.add(result);
                    i++;
                    j--;
                }else if(target>nums[i]+nums[j]){
                    i++;
                }else {
                    j--;
                }
            }
        }
        List<List<Integer>> results = new LinkedList<>(set);
        return results;
    }

    public static void main(String[] args) {
        int[] arr = {3,0,-2,-1,1,2};
        System.out.println(threeSum(arr));
    }
}
