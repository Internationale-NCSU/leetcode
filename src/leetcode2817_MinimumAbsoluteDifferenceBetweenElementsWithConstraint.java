import java.util.List;
import java.util.TreeSet;

public class leetcode2817_MinimumAbsoluteDifferenceBetweenElementsWithConstraint {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int diff = Integer.MAX_VALUE;
        int start = nums.size()-x-1;
        TreeSet<Integer> set = new TreeSet<>();
        int j = nums.size()-1;
        for(int i = start; i>=0; i--){
            set.add(nums.get(j));
            j--;
            int ele = nums.get(i);
            Integer lower = set.ceiling(ele);
            Integer upper = set.floor(ele);
            if(lower!=null){
                diff = Math.min(diff, Math.abs(lower-ele));
            }
            if(upper!=null){
                diff = Math.min(diff, Math.abs(upper-ele));
            }
        }
        return diff;
    }
}
