import org.junit.Test;

import java.math.BigInteger;

// dp with memo

public class leetcode2400_NumberOfWaysToReachAPositionAfterExactlyKSteps {
    int[][] memo;
    int MOD = (int)(Math.pow(10,9)+7);
    public int numberOfWays(int startPos, int endPos, int k) {
        memo = new int[4000][k+1];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                memo[i][j] =-1;
            }
        }
        return dfs(startPos,k,endPos);
    }
    public int dfs(int index,int s,int target){
        if(index==target&&s==0){
            return 1;
        }
        if(index+s<target||s==0){
            return 0;
        }
        if(memo[index+1500][s]!=-1){
            return memo[index+1500][s];
        }
        int c1 = dfs(index+1,s-1,target)%MOD;
        int c2 = dfs(index-1,s-1,target)%MOD;
        memo[index+1500][s] = (c1+c2)%MOD;
        return (c1+c2)%MOD;
    }
    @Test
    public void test(){
        System.out.println(numberOfWays(2,6,10));
    }
}
