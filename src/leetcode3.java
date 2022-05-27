import java.util.HashMap;
import java.util.Map;

public class leetcode3 {
    public static int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int start = -1;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),i);
            }else {
                start = Math.max(start,map.get(s.charAt(i)));
                map.replace(s.charAt(i),i);
            }
            maxLen = Math.max(maxLen,i-start);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }
}
