import java.util.HashSet;
import java.util.Set;

public class leetcode2559_CountVowelStringsInRanges {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefix = new int[words.length+1];
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        for (int i = 0; i < words.length; i++) {
            boolean isVow=false;
            char begin = words[i].charAt(0);
            char end = words[i].charAt(words[i].length()-1);
            if(set.contains(begin)&&set.contains(end)){
                isVow=true;
            }
            if(isVow){
                prefix[i+1] = prefix[i] + 1;
            }else {
                prefix[i+1] = prefix[i];
            }
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = prefix[queries[i][1]+1]-prefix[queries[i][0]];
        }
        return result;
    }
}
