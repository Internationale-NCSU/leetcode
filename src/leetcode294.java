import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class leetcode294 {
    Map<String,Boolean> memo = new HashMap<>();
    public boolean canWin(String currentState) {
        return check(currentState);
    }
    public boolean check(String currentState){
        if(memo.containsKey(currentState)){
            return memo.get(currentState);
        }
        if(currentState.length()==1){
            return false;
        }
        if(currentState.length()==2){
            if(currentState.charAt(0)=='+'&&currentState.charAt(1)=='+'){
                return true;
            }else{
                return false;
            }
        }
        boolean willwin = false;
        for (int i = 0; i < currentState.length(); i++) {
            if(i+1 < currentState.length() && currentState.charAt(i)==currentState.charAt(i+1) && currentState.charAt(i)=='+') {
                String nextState = currentState.substring(0, i) + "--" + currentState.substring(i + 2, currentState.length());
                willwin |= !check(nextState);
                if(willwin){
                    memo.put(currentState,true);
                    return true;
                }
            }
        }
        memo.put(currentState,false);
        return false;
    }
    @Test
    public void test(){
        System.out.println(canWin("++++"));
    }
}
