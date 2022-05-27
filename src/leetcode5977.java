import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class leetcode5977 {

    public static int minSwaps(int[] nums) {
        int[] cycleNums = new  int[nums.length*2];
        for (int i = 0; i < cycleNums.length; i++) {
            cycleNums[i] = nums[i%nums.length];
        }
        int minSwaps = Integer.MAX_VALUE;
        int countOne = 0;
        int[] countOnePreSum = new int[cycleNums.length+1];
        countOnePreSum[0] = 0;
        for (int i = 1; i <= cycleNums.length; i++) {
            if(nums[(i-1)%nums.length]==1){
                countOne++;
            }
            countOnePreSum[i] = countOne;
        }
        int windowSize = countOne/2;
        if(countOne==0){
            return 0;
        }
        for (int i = 1; i <= nums.length; i++) {
            int upper = i+windowSize-1;
            int countZero = windowSize-(countOnePreSum[upper]-countOnePreSum[i-1]);
            minSwaps = Math.min(countZero,minSwaps);
        }
        return minSwaps;
    }

    public static void main(String[] args) {
        System.out.println(minSwaps(new int[]{1,0,1,0,0,1,1,0,0}));
    }

}
