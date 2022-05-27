import java.util.*;

public class leetcode1048 {
    public static int dfs(Set<String> words, Map<String,Integer> memo,String currentWord){
        if(memo.containsKey(currentWord)){
            return memo.get(currentWord);
        }
        int maxLength = 1;
        StringBuilder sb = new StringBuilder(currentWord);
        for (int i = 0; i < currentWord.length(); i++) {
            sb.deleteCharAt(i);
            String newWord = sb.toString();
            if(words.contains(newWord)){
                int currentLength = 1 + dfs(words,memo,newWord);
                maxLength = Math.max(currentLength,maxLength);
            }
            sb.insert(i,currentWord.charAt(i));
        }
        memo.put(currentWord,maxLength);
        return maxLength;
    }
    public static int longestStrChain(String[] words) {
        Map<String,Integer> memo = new HashMap<>();
        Set<String> wordsPresent = new HashSet<>();
        Collections.addAll(wordsPresent,words);
        int ans = 0;
        for(String word:words){
            ans = Math.max(ans,dfs(wordsPresent,memo,word));
        }
        return ans;
    }
    public static void main(String[] args) {
        String[] words = new String[]{
                "a","b","ba","bca","bda","bdca"
        };
        System.out.println(longestStrChain(words));
    }
}
