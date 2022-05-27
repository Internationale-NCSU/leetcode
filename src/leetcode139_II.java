import java.util.*;

public class leetcode139_II {

    public static boolean judge(String s, Set<String> wordSet, int index, boolean[] memo){
        if(index==s.length()){
            return true;
        }
        if(memo[index]){
            return memo[index];
        }
        for (int i = index+1; i <= s.length(); i++) {
            String substring = s.substring(index,i);
            if(wordSet.contains(substring)&&judge(s,wordSet,i,memo)){
                return memo[index] = true;
            }
        }
        return memo[index];
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return judge(s,wordSet,0,new boolean[s.length()]);
    }

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("leet");
        list.add("code");
        System.out.println(wordBreak("leetcode",list));
    }
}
