import org.junit.Test;

import java.util.Arrays;

public class leetcode473_MatchsticksToSquare {
    public boolean makesquare(int[] matchsticks) {
        int edgeLen = 0;
        edgeLen = Arrays.stream(matchsticks).sum();
        if(edgeLen%4!=0){
            return false;
        }else {
            edgeLen = edgeLen/4;
        }
        Arrays.sort(matchsticks);
        return backtracking(matchsticks,0,edgeLen,0,0,new boolean[matchsticks.length]);
    }
    public boolean backtracking(int[] matchsticks, int matchCount, int edgeLen, int curLen, int edgeCount,boolean[] isUsed){
        if(matchCount==matchsticks.length&&edgeCount==4) {
            return true;
        }
        boolean result;
        for (int i = 0; i < matchsticks.length; i++) {
            if(isUsed[i]==false && curLen+matchsticks[i]==edgeLen){
                isUsed[i] = true;
                result = backtracking(matchsticks,matchCount+1,edgeLen,0,edgeCount+1,isUsed);
                if(result){
                    return true;
                }
                isUsed[i] = false;
            }
            if(isUsed[i]==false && curLen+matchsticks[i]<edgeLen){
                isUsed[i] = true;
                result = backtracking(matchsticks,matchCount+1,edgeLen,curLen+matchsticks[i],edgeCount,isUsed);
                if(result){
                    return true;
                }
                isUsed[i] = false;
            }
        }
        return false;
    }
    @Test
    public void test(){
        System.out.println(makesquare(new int[]{4,4,4,4,1}));
    }
}
