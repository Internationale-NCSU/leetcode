import java.util.HashMap;
import java.util.Map;

public class leetcode3_II {
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int start = -1;
        Map<Character,Integer> wordsMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(wordsMap.containsKey(s.charAt(i))){
                int length = i-wordsMap.get(s.charAt(i));
                if(length>maxLength){
                    maxLength = length;
                }
                start = i-1;
                wordsMap.replace(s.charAt(i),i);
            }else {
                wordsMap.put(s.charAt(i), i);
                if(maxLength<i-start){
                    maxLength = i-start;
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }
}
