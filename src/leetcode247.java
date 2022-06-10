import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class leetcode247 {
    private char[] one = new char[]{'0','1','8'};
    private char[] two = new char[]{'0','1','8','6','9'};
    public List<String> findStrobogrammatic(int n) {
        List<String> result = new LinkedList<>();
        backtracking(result,n,new StringBuilder());
        return result;
    }
    public void backtracking(List<String> result,int n,StringBuilder sb){
        if(sb.length()==n/2){
            String mirror = mirrorString(sb);
            if(n%2==0){
                result.add(sb.toString()+mirror);
            }else {
                for (char c : one) {
                    String s = sb.toString()+String.valueOf(c)+mirror;
                    result.add(s);
                }
            }
            return;
        }
        for (int i = 0; i < two.length; i++) {
            if(i==0&&sb.length()==0){
                continue;
            }
            sb.append(two[i]);
            backtracking(result,n,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public String mirrorString(StringBuilder s){
        StringBuilder mirror = new StringBuilder(s);
        mirror.reverse();
        for (int i = 0; i < mirror.length(); i++) {
            if( mirror.charAt(i)=='6'){
                mirror.setCharAt(i,'9');
            }else if( mirror.charAt(i)=='9'){
                mirror.setCharAt(i,'6');
            }
        }
        return mirror.toString();
    }
    @Test
    public void test(){
        System.out.println(findStrobogrammatic(14));
    }

}
