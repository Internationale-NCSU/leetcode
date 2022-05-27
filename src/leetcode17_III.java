import java.util.LinkedList;
import java.util.List;

public class leetcode17_III {
    public static void dfs(String digit, String[] numToChar, int index, StringBuilder sb,List<String> result ){
        if(sb.length()!=0&&sb.length()==digit.length()){
            result.add(sb.toString());
        }
        if(index>=digit.length()){
            return;
        }
        int d = digit.charAt(index)-'0';
        String s = numToChar[d];
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            dfs(digit,numToChar,index+1,sb,result);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public static List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        String[] numToChar= {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        dfs(digits,numToChar,0,new StringBuilder(),result);
        return result;
    }
    public static void main(String[] args) {
        letterCombinations("");
    }
}
