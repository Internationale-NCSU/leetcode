import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetcode916_WordSubsets {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] max = new int[26];
        for (String s : words2) {
            int[] count = charCount(s);
            for (int i = 0; i < 26; i++) {
                max[i] = Math.max(count[i],max[i]);
            }
        }
        List<String> list = new ArrayList<>();
        search : for (String s : words1) {
            int count[] = charCount(s);
            for (int i = 0; i < 26; i++) {
                if(count[i]<max[i]){
                    continue search;
                };
            }
            list.add(s);
        }
        return list;

    }
    public int[] charCount(String word){
        int[] count = new int[26];
        for (int i = 0; i < word.length(); i++) {
            count[word.charAt(i)-'A']++;
        }
        return count;
    }
}
