import java.util.HashMap;

public class leetcode523 {
    public static boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int sum = 0;
        hashMap.put(0,-1);
        for (int i = 0; i < nums.length; i++) {
            sum = (sum+ nums[i])%k;
            if(hashMap.containsKey(sum)&&i-hashMap.get(sum)>1){
                return true;
            }else if(!hashMap.containsKey(sum)) {
                hashMap.put(sum,i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {23,2,4,6,6};
        System.out.println(checkSubarraySum(nums,7));
    }
}
