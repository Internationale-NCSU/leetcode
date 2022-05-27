import java.util.Arrays;

public class leetcode2136 {
    public static int earliestFullBloom(int[] plantTime, int[] growTime) {
        int[][] flowerAttribute = new int[plantTime.length][2];
        for (int i = 0; i < plantTime.length; i++) {
            flowerAttribute[i][0] = plantTime[i];
            flowerAttribute[i][1] = growTime[i];
        }
        Arrays.sort(flowerAttribute,(a,b)->{
            return b[1]-a[1];
        });
        int maxTime = 0;
        int curTime = 0;
        for (int i = 0; i < flowerAttribute.length; i++) {
            int time = curTime+flowerAttribute[i][0]+flowerAttribute[i][1];
            maxTime = Math.max(maxTime,time);
            curTime += flowerAttribute[i][0];
        }
        return maxTime;
    }

    public static void main(String[] args) {
        int[] plantTime = new int[]{1,2,3,2};
        int[] growTime = new int[]{2,1,2,1};
        System.out.println(earliestFullBloom(plantTime,growTime));
    }
}
