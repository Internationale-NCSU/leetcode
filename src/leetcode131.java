import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetcode131 {
    public List<List<String>> partition(String s) {
        List<List<String>> result=  new LinkedList<>();
        int len = s.length();
        boolean dp[][] = new boolean[len][len];
        dfs(result, new ArrayList<>(), s, dp,0);
        return result;
    }
    public void dfs(List<List<String>> result, List<String> currentPartition,String s , boolean[][] dp, int index){
        if(index>=s.length()) {
            result.add(new ArrayList<>(currentPartition));
        }
        for (int end = index; end < s.length(); end++) {
            if(s.charAt(index)==s.charAt(end)&&(end - index<=2 || dp[index+1][end-1])){
                dp[index][end] = true;
                currentPartition.add(s.substring(index,end+1));
                dfs(result,currentPartition,s,dp,end+1);
                currentPartition.remove(currentPartition.size()-1);
            }
        }
    }
    @Test
    public void test(){
        System.out.println(partition("aaa"));
    }
}
