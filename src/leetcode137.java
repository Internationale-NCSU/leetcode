import java.util.*;

public class leetcode137 {
    public static int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])==3){
                map.remove(nums[i]);
            }
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            return entry.getKey();
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1,1,1,2}));
    }
}
