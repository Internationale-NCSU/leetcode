import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class leetcode5989 {
    public static int countElements(int[] nums) {
//        if(nums.length<3){
//            return 0;
//        }
//        Arrays.sort(nums);
//        boolean start = false,end=false;
//        int count = 0;
//        for (int i = 1; i < nums.length; i++) {
//            if(!start&&nums[i]==nums[i-1]){
//                count++;
//            }else {
//                break;
//            }
//        }
//        for (int i = nums.length-1; i >= 1; i++) {
//            if(!end&&nums[i]==nums[i-1]){
//
//            }
//        }
        Map<Integer,Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int count = 0;
        int index = 0;
        boolean start = false;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            index++;
            if(!start){
                start=true;
                continue;
            }
            if(index==map.size()){
                break;
            }
            count = count + map.get(entry.getKey());
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countElements(new int[]{3,3,3,3,3,4,4,4,5,5,5,5}));
    }
}
