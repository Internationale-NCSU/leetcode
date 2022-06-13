import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class leetcode22_II {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        backtrack(result,0,0,new StringBuilder(),n);
        return result;
    }
    public void backtrack(List<String> result,int leftParenthesesCount, int rightParenthesesCount, StringBuilder path,int n){
        if(path.length()==2*n){
            result.add(path.toString());
            return;
        }
        if(leftParenthesesCount==0){
            path.append("(");
            backtrack(result,leftParenthesesCount+1,rightParenthesesCount,path,n);
            path.deleteCharAt(path.length()-1);
        }else if(leftParenthesesCount==n){
            path.append(")");
            backtrack(result,leftParenthesesCount,rightParenthesesCount,path,n);
            path.deleteCharAt(path.length()-1);
        }else if(leftParenthesesCount>=rightParenthesesCount) {
            backtrack(result,leftParenthesesCount+1,rightParenthesesCount,path.append("("),n);
            path.deleteCharAt(path.length()-1);
            backtrack(result,leftParenthesesCount,rightParenthesesCount+1,path.append(")"),n);
            path.deleteCharAt(path.length()-1);
        }
    }
    @Test
    public void test(){
        System.out.println(generateParenthesis(3));
    }
}
