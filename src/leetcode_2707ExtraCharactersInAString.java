import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class leetcode_2707ExtraCharactersInAString {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> dic = new HashSet<>();
        int[] memo = new int[s.length()];
        Arrays.fill(memo,-1);
        for (int i = 0; i < dictionary.length; i++) {
            dic.add(dictionary[i]);
        }
        return dp(0,s,dic,memo);
    }
    public int dp(int start, String s, Set<String> dic, int[] memo){
        if(start==s.length()){
            return 0;
        }
        if(memo[start]!=-1){
            return memo[start];
        }
        int ans = dp(start+1, s, dic, memo)+1;
        for (int i = start; i < s.length(); i++) {
            String substring = s.substring(start, i+1);
            if(dic.contains(substring)){
                ans = Math.min(ans, dp(i+1,s,dic,memo));
            }
        }
        return memo[start] = ans;
    }
    @Test
    public void test(){
        System.out.println(minExtraChar("leetscode",new String[]{"leet","code","leetcode"}));
    }
}
