import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class leetcode6017 {
    public static long minimalKSum(int[] nums, int k) {
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            set.add(nums[i]);
//        }

//        int num = 1;
//        while (k>0){
//            if(set.contains(num)){
//                num++;
//            }else {
//                k--;
//                curSum = curSum+num;
//                num++;
//            }
//        }
//        return curSum;
        Arrays.sort(nums);
        long curSum = 0;
        if(nums[0]!=1){
            if(k<nums[0]){
                return curSum = (long)(1+k)*(long)k/2;
            }else {
                curSum = (long)(1+nums[0]-1)*(long)(nums[0]-1)/2;
                k = k-(nums[0]-1);
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if(k<=0){
                break;
            }
            if(nums[i]==nums[i-1]||nums[i]==nums[i-1]+1){
                continue;
            }
            if(k>nums[i]-nums[i-1]-1){
                curSum = curSum+ (long)(nums[i-1]+nums[i])*(long)(nums[i]-nums[i-1]-1)/2;
                k = k-(nums[i]-nums[i-1]-1);
            }else {
                curSum = curSum+(long)(nums[i-1]+1+nums[i-1]+k)*(long)k/2;
                k=0;
            }

        }
        if(k>0){
            curSum = curSum+(long)(nums[nums.length-1]+1+nums[nums.length-1]+k)*(long)k/2;
        }
        return curSum;
    }

    public static void main(String[] args) {
        System.out.println(minimalKSum(new int[]{
                96,44,99,25,61,84,88,18,19,33,60,86,52,19,32,47,35,50,94,17,29,98,22,21,72,100,40,84
        },35));
    }
}
