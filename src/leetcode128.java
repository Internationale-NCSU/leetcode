import java.util.HashSet;
import java.util.Set;

public class leetcode128 {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (Integer integer : set) {
            if(!set.contains(integer-1)){
                int len = 1;
                while(set.contains(integer+1)){
                    len = len+1;
                    integer++;
                }
                maxLen = Math.max(maxLen,len);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr ={0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(arr));
    }
}
