import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class leetcode22_GenerateParentheses_III {
    public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();
        dfs(list,n,new StringBuilder(),0,0);
        return list;
    }
    public void dfs(List<String> list,int n,StringBuilder sb,int leftPar,int rightPar){
        if(leftPar>n){
            return;
        }
        if(leftPar-rightPar<0){
            return;
        }
        if(sb.length()==n*2){
            list.add(sb.toString());
            return;
        }
        dfs(list,n,new StringBuilder(sb).append("("),leftPar+1,rightPar);
        dfs(list,n,new StringBuilder(sb).append(")"),leftPar,rightPar+1);
    }
    @Test
    public void test(){
        System.out.println(generateParenthesis(8));
    }
}
