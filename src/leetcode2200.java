import java.util.*;

public class leetcode2200 {
    public static List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==key){
                set.add(i);
            }
        }
        Set<Integer> result = new HashSet<>();
        for (Integer integer : set) {
            int start = integer-k>=0? integer-k:0;
            int end = integer+k<nums.length?integer+k:nums.length-1;
            for (int i = start; i <= end; i++) {
                result.add(i);
            }
        }
        List<Integer> list = new LinkedList<>(result);
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        findKDistantIndices(new int[]{1,1000,1,1000},1000,1);
    }
}
