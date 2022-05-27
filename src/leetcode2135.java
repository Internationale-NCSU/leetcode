import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class leetcode2135 {
    public static int wordCount(String[] startWords, String[] targetWords) {
        int count = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < startWords.length; i++) {
            char[] charArray = startWords[i].toCharArray();
            Arrays.sort(charArray);
            String s = String.valueOf(charArray);
            set.add(s);
        }
        for (int i = 0; i < targetWords.length; i++) {
            char[] charArray = targetWords[i].toCharArray();
            Arrays.sort(charArray);
            StringBuilder s = new StringBuilder(String.valueOf(charArray));
            for (int j = 0; j < charArray.length; j++) {
                String tmp = s.toString();
                s.deleteCharAt(j);
                if(set.contains(s.toString())){
                    count++;
                    break;
                }
                s = new StringBuilder(tmp);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] startWords = new String[]{"ant","act","tack"};
        String[] targetWords = new String[]{"tack","act","acti"};
        System.out.println(wordCount(startWords,targetWords));
    }
}
