import java.util.LinkedList;
import java.util.List;

public class leetcode17_II {
    public static void backTracking(List<String> result,String[] mapping,String digits,int i,String path){
        if(digits.length()==0){
            return;
        }
        if(path.length()==digits.length()){
            result.add(path);
        }
        if(i>=digits.length()){
            return;
        }
        for (int k = 0; k < mapping[digits.charAt(i)-'0'-2].length(); k++) {
            path = path.concat(String.valueOf(mapping[digits.charAt(i) - '0' - 2].charAt(k)));
            backTracking(result, mapping, digits, i + 1, path);
            path = path.substring(0, path.length() - 1);
        }
    }

    public static List<String> letterCombinations(String digits) {
        String[] mapping = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result = new LinkedList<>();
        backTracking(result,mapping,digits,0,"");
        return result;
    }
    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
    }
}
