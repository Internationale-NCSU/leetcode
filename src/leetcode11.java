import java.util.Map;
import java.util.regex.Matcher;

public class leetcode11 {
    public static int maxArea(int[] height) {
        int head = 0;
        int rear = height.length-1;
        int max = 0;
        while (rear!=head){
            max = Math.max(max,(rear-head)*Math.min(height[rear],height[head]));
            if(height[rear]>height[head]){
                head++;
            }else {
                rear--;
            }
        }
        return max;
//        int[][] dp = new int[height.length][height.length];
//        int max = 0;
//        for (int i = height.length-1; i >=0; i--) {
//            for (int j = i; j < height.length; j++) {
//                if(i==j) dp[i][j] = 0;
//                max = Math.max(max,Math.min(height[i],height[j])*Math.abs(i-j));
//                dp[i][j] = max;
//            }
//        }
//        for (int i = 0; i < height.length; i++) {
//            for (int j = 0; j < height.length; j++) {
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
//        return dp[height.length-1][height.length-1];

    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
