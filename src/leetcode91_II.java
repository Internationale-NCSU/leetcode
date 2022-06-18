import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class leetcode91_II {
    private Map<Integer,Integer> memo = new HashMap<>();
    public int numDecodings(String s) {
        return backtracking(s,0);
    }
    public int backtracking(String s, int index){
        if(memo.containsKey(index)){
            return memo.get(index);
        }
        if(index==s.length()){
            return 1;
        }
        if(s.charAt(index)=='0'){
            return 0;
        }
        if(index == s.length() -1){
            return 1;
        }
        int ans = backtracking(s,index+1);
        if(Integer.parseInt(s.substring(index,index+2))<=26){
           ans+=backtracking(s,index+2);
        }
        memo.put(index,ans);
        return ans;
    }
    @Test
    public void test(){
        System.out.println(numDecodings("12"));
    }
}
