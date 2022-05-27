import java.util.*;

public class leetcode347 {
    public static int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < nums.length ; i++) {
            treeMap.put(nums[i],treeMap.getOrDefault(nums[i],0)+1);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(treeMap.entrySet());
        Collections.sort(list,(a,b)->{
            return b.getValue()-a.getValue();
        });
        int[] reuslt = new int[k];
        for (int i = 0; i < k; i++) {
            reuslt[i] = list.get(i).getKey();
        }
        return reuslt;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,3,3,2,2,2,4};
        Arrays.stream(topKFrequent(nums,2)).forEach(
                (a)->{
                    System.out.println(a);
                }
        );
    }
}
