import java.util.Arrays;

public class leetcode697 {
    public static int findShortestSubArray(int[] nums) {
        int[][] timesCounter = new int[50001][3];
        for (int i = 0; i < timesCounter.length; i++) {
            timesCounter[i][1]=-1;
            timesCounter[i][2]=-1;
        }

        for (int i = 0; i < nums.length; i++) {
            timesCounter[nums[i]][0]++;
            if(timesCounter[nums[i]][1]==-1){
                timesCounter[nums[i]][1] = i;
            }
            timesCounter[nums[i]][2] = Math.max(timesCounter[nums[i]][2],i);
        }
        int degree = 0;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < timesCounter.length; i++) {
            if(timesCounter[i][0]>degree){
                degree = timesCounter[i][0];
                minLen = timesCounter[i][2]-timesCounter[i][1]+1;
            }else if(timesCounter[i][0]==degree){
                minLen = Math.min(minLen,timesCounter[i][2]-timesCounter[i][1]+1);
            }
        }
        return minLen;
    }

    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[]{6,5,5}));
    }
}
