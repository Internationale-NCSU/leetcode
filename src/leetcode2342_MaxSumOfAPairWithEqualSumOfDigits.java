import org.junit.Test;

import java.util.*;

public class leetcode2342_MaxSumOfAPairWithEqualSumOfDigits {
    public int sumOfDigits(int num){
        if(num==0){
            return 0;
        }else {
            return sumOfDigits(num/10)+num%10;
        }
    }
    public int maximumSum(int[] nums) {
        int[] sumArrays = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sumArrays[i] = sumOfDigits(nums[i]);
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(sumArrays[i])){
                map.get(sumArrays[i]).add(nums[i]);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                map.put(sumArrays[i],list);
            }
        }
        int maxSum = -1;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            if(list.size()<2){
                continue;
            }
            int max = Integer.MIN_VALUE;
            int secMax = Integer.MIN_VALUE;
            for (Integer integer : list) {
                if(integer>max){
                    secMax = max;
                    max = integer;
                    continue;
                }else if(integer>secMax){
                    secMax = integer;
                }
            }
            maxSum = Math.max(max+secMax,maxSum);
        }
        return maxSum;
    }
    @Test
    public void test(){
        System.out.println(maximumSum(new int[]{10,12,19,14}));
    }
}
