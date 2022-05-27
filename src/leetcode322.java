import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public class leetcode322 {
    public static void dfs(int[] coins, int index,int count,int sum,int[] memo){
        if(index>=coins.length){
            return;
        }
        if(sum>=memo.length||sum<0){
            return;
        }
        if(memo[sum]!=-1&&count>=memo[sum]){
            return;
        }
        memo[sum] = count;

        for (int i = coins.length-1; i >=0; i--) {
            dfs(coins,i,count+1,sum+coins[i],memo);
        }
    }
    public static int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount+1];
        Arrays.fill(memo,-1);
        Arrays.sort(coins);
        dfs(coins,0,0,0,memo);
        return memo[amount];
    }
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2147483647},2));
    }
}
