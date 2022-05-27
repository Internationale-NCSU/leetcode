import java.util.*;

public class leetcode1048_II {
    public static int dfs(Set<String> wordsSet, Map<String,Integer> memo,String currentWord){
        if(memo.containsKey(currentWord)){
            return memo.get(currentWord);
        }
        int maxLength = 1;
        StringBuilder sb = new StringBuilder(currentWord);
        for (int i = 0; i < currentWord.length(); i++) {
            sb.deleteCharAt(i);
            if(wordsSet.contains(sb.toString())){
                maxLength = Math.max(maxLength,1+dfs(wordsSet,memo,sb.toString()));
            }
            sb.insert(i,currentWord.charAt(i));
        }
        memo.put(currentWord,maxLength);
        return maxLength;
    }
    public static int longestStrChain(String[] words) {
        Set<String> wordsSet = new HashSet<>();
        Map<String,Integer> memo = new HashMap<>();
        Collections.addAll(wordsSet,words);
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            result = Math.max(result,dfs(wordsSet,memo,words[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"a","b","ba","bca","bda","bdca","bdcea"};
        System.out.println(longestStrChain(words));
    }
}
