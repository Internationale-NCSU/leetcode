import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class leetcode241 {
    public List<Integer> diffWaysToCompute(String expression) {
        Set<Integer> result = new HashSet<>();
        backtracking(result,new StringBuilder(expression));
        return new LinkedList<>(result);
    }
    public void backtracking(Set<Integer> result, StringBuilder path){
        if(path.length()<=3){
            if(path.length()==3&&path.charAt(0)=='-'){
                result.add(Integer.valueOf(path.toString()));
                return;
            }else if(path.length()!=3) {
                result.add(Integer.valueOf(path.toString()));
                return;
            }
        }
        for (int i = 0; i < path.length()-1; i=i+2) {
            String origin = path.toString();
            String exp = path.substring(i,i+3);
            int num;
            int num1 = exp.charAt(0)-'0', num2 = exp.charAt(2)-'0';
            if(exp.charAt(1)=='+'){
                num = num1+num2;
            }else if(exp.charAt(1)=='-'){
                num = num1-num2;
            }else{
                num = num1*num2;
            }
            path.replace(i,i+3,String.valueOf(num));
            backtracking(result,path);
            path = new StringBuilder(origin);
        }
    }
    @Test
    public void test(){
        System.out.println(diffWaysToCompute("2*3-4*5"));
    }
}
