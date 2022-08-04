import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class leetcode424_LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] charCounter = new int[26];
        int left = 0, right = 0, max = Integer.MIN_VALUE, mostFreq = 0;
        while(right<s.length()){
            char c = s.charAt(right);
            charCounter[c-'A']++;
            for (int i = 0; i < charCounter.length; i++) {
                mostFreq = Math.max(mostFreq,charCounter[i]);
            }
            while(right-left+1-mostFreq>k){
                charCounter[s.charAt(left)-'A']--;
                left++;
            }
            max = Math.max(max,right-left+1);
            right++;
        }
        return max;
    }
    @Test
    public void test(){
        System.out.println(characterReplacement("ABAA",0));
    }
}
