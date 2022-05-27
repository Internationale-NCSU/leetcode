import java.util.HashMap;
import java.util.Map;

public class leetcode91 {
    static Map<Integer,Integer> memo = new HashMap<>();
    public static int countValid(String s,int index,Map<Integer,Integer> memo){
        if(memo.containsKey(index)) {
            return memo.get(index);
        }
        if(index==s.length()){
            return 1;
        }
        if(index==s.length()-1){
            return 1;
        }
        int count = countValid(s,index+1,memo);
        if(Integer.parseInt(s.substring(index,index+2))<=26){
            count += countValid(s,index+2,memo);
        }
        memo.put(index,count);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countValid("12345",0,memo));
    }
}
