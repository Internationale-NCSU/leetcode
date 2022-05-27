import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class leetcode136 {
    public static int singleNumber(int[] nums){
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i])){
                list.remove(list.indexOf(nums[i]));
            }else {
                list.add(nums[i]);
            }
        }
        int n = 0;
        for (Integer integer : list) {
            n = integer;
        }
        return n;
    }
    public static void main(String[] args) {
        int[] arr = {2,2,1};
        System.out.println(singleNumber(arr));
    }
}
