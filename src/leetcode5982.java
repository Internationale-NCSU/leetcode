import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class leetcode5982 {
    public static void findMax(int[][] question, int index,int curSum,Map<Integer,Integer> dp ){
        if(index>=question.length){
            return;
        }
        if(dp.containsKey(index)){
            int sum = dp.get(index);
            if(curSum>sum){

            }
        }
        curSum = curSum + question[index][0];


    }
    public static long mostPoints(int[][] questions) {
        int[] dp = new int[questions.length];
        dp[questions.length-1] = questions[questions.length-1][0];
        for (int i = questions.length-2; i >= 0 ; i--) {
            if(i+questions[i][1]+1<questions.length){
                dp[i] = Math.max(dp[i+1],questions[i][0]+dp[i+questions[i][1]+1]);
            }else {
                dp[i] = Math.max(dp[i+1],questions[i][0]);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(mostPoints(new int[][]
                {{21,5},{92,3},{74,2},{39,4},{58,2},{5,5},{49,4},{65,3}}
        ));;
    }
}
