import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class leetcode17_LetterCombinationOfAPhoneNumberIV {
    public List<String> letterCombinations(String digits) {

        char[][] numbers = new char[10][];
        numbers[2] = new char[]{'a','b','c'};
        numbers[3] = new char[]{'d','e','f'};
        numbers[4] = new char[]{'g','h','i'};
        numbers[5] = new char[]{'j','k','l'};
        numbers[6] = new char[]{'m','n','o'};
        numbers[7] = new char[]{'p','q','r','s'};
        numbers[8] = new char[]{'t','u','v'};
        numbers[9] = new char[]{'w','x','y','z'};
        List<String> result = new ArrayList<>();
        if(digits.length()==0){
            return result;
        }
        backtracking(numbers,result,new StringBuilder(),digits,0);
        return result;
    }
    public void backtracking(char[][] numbers, List<String> result, StringBuilder curCom, String digit, int index){
        if(curCom.length()==digit.length()){
            result.add(curCom.toString());
        }
        if(index==digit.length()){
            return;
        }
        int num = digit.charAt(index)-'0';
        for (char c : numbers[num]) {
            curCom.append(c);
            backtracking(numbers,result,curCom,digit,index+1);
            curCom.deleteCharAt(curCom.length()-1);
        }
    }
    @Test
    public void test(){
        System.out.println(letterCombinations("234"));
    }
}
