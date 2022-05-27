import java.util.HashSet;
import java.util.Set;

public class leetcode5993 {
    public static int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        while(set.contains(original)){
            original *=2;
        }
        return original;
    }

    public static void main(String[] args) {
        System.out.println(findFinalValue(new int[]{2,7,9},4));
    }
}
