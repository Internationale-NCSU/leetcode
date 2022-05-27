import java.util.HashMap;
import java.util.Map;

public class leetcode220 {
    public static long getId(long x,long w){
        return x < 0 ? (x + 1) / w - 1 : x / w;
    }
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Long,Long> bucket = new HashMap<>();
        long w = t + 1;
        for (int i = 0; i < nums.length; i++) {
            if(bucket.containsKey(getId(nums[i],w))){
                return true;
            }else if(bucket.containsKey(getId(nums[i],w)-1)&&Math.abs(nums[i]-bucket.get(getId(nums[i],w)-1)) < w){
                return true;
            }else if(bucket.containsKey(getId(nums[i],w)+1)&&Math.abs(nums[i]-bucket.get(getId(nums[i],w)+1)) < w){
                return true;
            }
            bucket.put(getId(nums[i],w),(long)nums[i]);
            if(i>=k){
                bucket.remove(getId(nums[i-k],w));
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {2147483640,2147483641};
        System.out.println(containsNearbyAlmostDuplicate(arr,1,1));
    }
}
