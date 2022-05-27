import java.util.*;

public class leetcode139 {

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];
        queue.add(0);
        while(queue!=null){
            int start = queue.remove();
            if(visited[start]){
                continue;
            }
            for (int end = start+1; end <= s.length(); end++) {
                if(wordDictSet.contains(s.substring(start,end))){
                    queue.add(end);
                    if(end==s.length()){
                        return true;
                    }
                }
            }
            visited[start] = true;
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> wordDict = new LinkedList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        System.out.println(wordBreak("catsandog",wordDict));
    }
}
