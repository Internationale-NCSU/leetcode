import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class leetcode17 {
    Map<Integer,String> board = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        board.put(2,"abc");
        board.put(3,"def");
        board.put(4,"ghi");
        board.put(5,"jkl");
        board.put(6,"mno");
        board.put(7,"pqrs");
        board.put(8,"tuv");
        board.put(9,"wxyz");
        List<String> result = new LinkedList<>();
        backtracking(digits,0,result,new StringBuilder());
        return result;
    }
    public void backtracking(String digit, int index, List<String> result,StringBuilder path){
        if(index==digit.length()){
            if(path.length()==0){
                return;
            }
            result.add(path.toString());
            return;
        }
        int num = digit.charAt(index)-'0';
        for (int i = 0; i < board.get(num).length(); i++) {
            path.append(board.get(num).charAt(i));
            backtracking(digit,index+1,result,path);
            path.delete(path.length()-1,path.length());
        }
    }
    @Test
    public void test(){
        System.out.println(letterCombinations("23"));
    }
}
