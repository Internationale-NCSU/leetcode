import java.util.*;

public class leetcode127_WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> words = new HashSet<>();
        words.remove(beginWord);
        queue.add(beginWord);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                if(currentWord.equals(endWord)){
                    return level;
                }
                List<String> neighbors = neighbors(currentWord);
                for(String neigh:neighbors){
                    if(words.contains(neigh)) {
                        words.remove(neigh);
                        queue.add(neigh);
                    }
                }
            }
        }
        return 0;
    }
    public List<String> neighbors(String currentWord){
        return null;
    }
}
