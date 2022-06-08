import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class leetcode291 {
    public boolean wordPatternMatch(String pattern, String s) {
        Map<Character,String> map = new HashMap<>();
        return backtracking(pattern,s,0,0,map);
    }
    public boolean backtracking(String pattern, String s, int pIdx, int sIdx, Map<Character,String> map){
        if(pIdx == pattern.length() && sIdx == s.length()) {
            return true;
        }
        if(pIdx == pattern.length() || sIdx == s.length()){
            return false;
        }
        char pChar = pattern.charAt(pIdx);

        if(map.containsKey(pChar)){
            String existInMap = map.get(pChar);
            int pLength = existInMap.length();
            if(sIdx + pLength > s.length()){
                return false;
            }
            String substr = s.substring(sIdx,sIdx+pLength);
            if(substr.equals(existInMap)){
                backtracking(pattern,s,pIdx+1,sIdx+pLength,map);
            }
            return false;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = sIdx; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if(ifExist(map,sb.toString())){
                continue;
            }
            map.put(pChar,sb.toString());
            if(backtracking(pattern,s,pIdx +1,i+1,map)){
                return true;
            }
            map.remove(pChar);
        }
        return false;
    }
    public boolean ifExist(Map<Character,String> map, String current){
        for(Character key:map.keySet()){
            if(map.get(key).equals(current)) {
                return true;
            }
        }
        return false;
    }
    @Test
    public void test(){
        System.out.println(wordPatternMatch("ab","abababab"));
    }

}
