import org.junit.Test;

import java.util.*;

public class leetcode159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int l = 0,r = 0,maxLen = 0;
        while(r<s.length()){
            map.put(s.charAt(r),r);
            r++;
            if(map.size()==3){
                int del_idx = Collections.min(map.values());
                map.remove(s.charAt(del_idx));
                l = del_idx+1;
            }
            maxLen = Math.max(maxLen,r-l);
        }
        return maxLen;
    }
    @Test
    public void test(){
        System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));
    }
}
