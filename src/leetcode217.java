import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class leetcode217 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 5};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet set = new HashSet();
        List list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        if (set.size() != nums.length) return true;
        else
            return false;
    }
}
